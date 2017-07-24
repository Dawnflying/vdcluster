package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.common.VdConfiguration;
import com.xh.vdcluster.vdmanager.beans.VdServant;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServiceManager {

    private static String generateServantId(){
        return "";
    }

    public static VdServant createServant(VdConfiguration configuration){
        return new VdServant();
    }

}
