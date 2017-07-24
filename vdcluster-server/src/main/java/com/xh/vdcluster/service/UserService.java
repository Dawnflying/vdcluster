package com.xh.vdcluster.service;

import com.xh.vdcluster.common.VdResult;

/**
 * Created by bloom on 2017/7/24.
 */
public interface UserService {
    boolean authenicate(String name, String code);
    VdResult requestToken(String username, String code);
}
