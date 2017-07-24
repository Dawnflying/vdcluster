package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.authenication.Token;
import com.xh.vdcluster.authenication.TokenManager;
import com.xh.vdcluster.common.VdConfiguration;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdResultErrorCode;
import com.xh.vdcluster.repository.mapper.UserMapper;
import com.xh.vdcluster.repository.model.User;
import com.xh.vdcluster.service.UserService;
import com.xh.vdcluster.service.VdService;
import com.xh.vdcluster.vdmanager.VdServantManager;
import com.xh.vdcluster.vdmanager.beans.VdServant;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServiceImpl implements VdService {

    @Resource
    UserMapper userMapper;

    @Resource
    UserService userService;

    /**
     * 请求识别服务,如果验证通过则自动重新生成token,用户通过token来获取服务。
     *
     * @param username 用户名
     * @param password 加密后密码
     * @return
     */
    @Override
    public VdResult requestServant(String username, String password) {
        if (userService.authenticate(username, password)) {
            User user = userMapper.getUserByUsername(username);

            Token token = TokenManager.getToken();

            userMapper.updateUserToken(user.getUserId(), token.getTokenString());

            return new VdResult("ok", VdResultErrorCode.AUTH_SUCCESS, token);
        } else {
            return new VdResult("ok", VdResultErrorCode.AUTH_FAILED, null);
        }
    }

    @Override
    public VdResult addServant(String userId, String token, List<VdConfiguration> configurationList) {

        if (!TokenManager.checkTokenExpiration(token))
            return new VdResult("ok", VdResultErrorCode.TOKEN_EXPIRED, null);
        else {
            User user = userMapper.getUserByUserId(userId);

            if (user == null)
                return new VdResult("ok", VdResultErrorCode.AUTH_FAILED, null);

            String tokenStored = userMapper.getTokenByUserId(userId);
            if (tokenStored == null || tokenStored != token)
                return new VdResult("ok", VdResultErrorCode.TOKEN_ERROR, null);

            Integer grain = userMapper.getGrainByUserId(userId);

            if (configurationList.size() > grain)
                return new VdResult("ok", VdResultErrorCode.SERVANT_OVERLOAD, null);


            List<VdServant> servants = VdServantManager.getInstance().createServants(userId, configurationList);

            return new VdResult("ok", VdResultErrorCode.SERVANT_SUCCESS, servants);
        }
    }

    @Override
    public VdResult stopServant(String userId, String token, List<String> servantIds) {

        if (!TokenManager.checkTokenExpiration(token))
            return new VdResult("ok", VdResultErrorCode.TOKEN_EXPIRED, null);
        User user = userMapper.getUserByUserId(userId);

        if (user == null)
            return new VdResult("ok", VdResultErrorCode.AUTH_FAILED, null);

        String tokenStored = userMapper.getTokenByUserId(userId);
        if (tokenStored == null || tokenStored != token)
            return new VdResult("ok", VdResultErrorCode.TOKEN_ERROR, null);

        List<VdServant> vdServants = VdServantManager.getInstance().stopServants(userId, servantIds);

        return new VdResult("ok", VdResultErrorCode.SERVANT_SUCCESS, vdServants);
    }


    @Override
    public VdResult removeServant(String userId, String token, List<String> servantIds) {
        List<VdServant> vdServants = VdServantManager.getInstance().removeServants(userId,servantIds);

        return new VdResult("ok", VdResultErrorCode.SERVANT_SUCCESS,vdServants);
    }

}
