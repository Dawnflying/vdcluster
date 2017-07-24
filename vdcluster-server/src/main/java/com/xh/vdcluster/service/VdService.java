package com.xh.vdcluster.service;

import com.xh.vdcluster.common.VdConfiguration;
import com.xh.vdcluster.common.VdResult;

import java.util.List;

/**
 * Created by macbookpro on 17/7/22.
 */
public interface VdService {

    VdResult requestServant(String username, String password);

    VdResult addServant(String userId, String token, List<VdConfiguration> configuration);

    VdResult stopServant(String userId, String token, List<String> servantId);

    VdResult removeServant(String userId, String token, List<String> servantId);
}
