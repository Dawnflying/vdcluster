package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.authenication.Token;
import com.xh.vdcluster.authenication.TokenManager;
import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.Md5Utils;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdResultErrorCode;
import com.xh.vdcluster.repository.mapper.UserMapper;
import com.xh.vdcluster.repository.model.User;
import com.xh.vdcluster.service.VdService;
import com.xh.vdcluster.vdmanager.VdServantManager;
import com.xh.vdcluster.vdmanager.beans.VdServant;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by macbookpro on 17/7/22.
 */
@Component
public class VdServiceImpl implements VdService {

    @Resource
    UserMapper userMapper;

    @Override
    public VdResult addServant(String userId, String token, List<DetectServiceConfiguration> configurationList) {

        if (!TokenManager.checkTokenExpiration(token))
            return new VdResult("token expired", VdResultErrorCode.TOKEN_EXPIRED, null, userId);
        else {
            User user = userMapper.getUserByUserId(userId);

            if (user == null)
                return new VdResult("auth failed", VdResultErrorCode.AUTH_FAILED, null, userId);

            String tokenStored = userMapper.getTokenByUserId(userId);
            if (tokenStored == null || tokenStored != token)
                return new VdResult("token error", VdResultErrorCode.TOKEN_ERROR, null, userId);

            Integer grain = userMapper.getGrainByUserId(userId);

            if (configurationList.size() > grain)
                return new VdResult("servant overload", VdResultErrorCode.SERVANT_OVERLOAD, null, userId);


            List<VdServant> servants = VdServantManager.getInstance().createServants(userId, configurationList);

            return new VdResult("success to add servant", VdResultErrorCode.SERVANT_SUCCESS, servants, userId);
        }
    }

    @Override
    public VdResult stopServant(String userId, String token, List<String> servantIds) {

        if (!TokenManager.checkTokenExpiration(token))
            return new VdResult("ok", VdResultErrorCode.TOKEN_EXPIRED, null, userId);
        User user = userMapper.getUserByUserId(userId);

        if (user == null)
            return new VdResult("ok", VdResultErrorCode.AUTH_FAILED, null, userId);

        String tokenStored = userMapper.getTokenByUserId(userId);
        if (tokenStored == null || tokenStored != token)
            return new VdResult("ok", VdResultErrorCode.TOKEN_ERROR, null, userId);

        List<VdServant> vdServants = VdServantManager.getInstance().stopServants(userId, servantIds);

        return new VdResult("ok", VdResultErrorCode.SERVANT_SUCCESS, vdServants, userId);
    }


    @Override
    public VdResult removeServant(String userId, String token, List<String> servantIds) {
        List<VdServant> vdServants = VdServantManager.getInstance().removeServants(userId, servantIds);

        return new VdResult("ok", VdResultErrorCode.SERVANT_SUCCESS, vdServants, userId);
    }


}
