package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.authenication.Token;
import com.xh.vdcluster.authenication.TokenManager;
import com.xh.vdcluster.common.Md5Utils;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdResultErrorCode;
import com.xh.vdcluster.repository.mapper.UserMapper;
import com.xh.vdcluster.repository.model.User;
import com.xh.vdcluster.service.UserService;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/24.
 */
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /**
     * 请求识别服务,如果验证通过则自动重新生成token,用户通过token来获取服务。
     *
     * @param name 用户名
     * @param code 加密后密码
     * @return
     */

    @Override
    public boolean authenicate(String name, String code) {
        User user = userMapper.getUserByUsername(name);

        if(code.equals(Md5Utils.MD5(user.getPassword())))
            return true;

        return false;
    }

    @Override
    public  VdResult requestToken(String username, String code){
        if (this.authenicate(username, code)) {

            User user = userMapper.getUserByUsername(username);

            Token token = TokenManager.getToken();

            userMapper.updateUserToken(user.getUserId(), token.getTokenString());

            return new VdResult("ok", VdResultErrorCode.AUTH_SUCCESS, token, user.getUserId());

        } else {

            return new VdResult("ok", VdResultErrorCode.AUTH_FAILED, null,"");
        }
    }
}
