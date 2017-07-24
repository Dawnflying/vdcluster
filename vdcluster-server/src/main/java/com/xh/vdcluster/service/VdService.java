package com.xh.vdcluster.service;

import com.xh.vdcluster.common.VdConfiguration;
import com.xh.vdcluster.common.VdResult;

/**
 * Created by macbookpro on 17/7/22.
 */
public interface VdServant {

    VdResult requestServant(String username, String password);

    VdResult addServant(String token, VdConfiguration configuration);

    VdResult stopServant(String token, String serviceId);

    VdResult removeServant(String token, String serviceId);
}
