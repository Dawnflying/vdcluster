package com.xh.vdcluster.vdmanager.beans;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.repository.model.Stream;
import com.xh.vdcluster.vdmanager.ServantAdapter;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServant extends ServantAdapter {

    private String servantId;

    private Stream stream;

    public VdServant(DetectServiceConfiguration configuration){
        this.configuration = configuration;
    }

    public String getServantId() {
        return servantId;
    }

    public void setServantId(String servantId) {
        this.servantId = servantId;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

}
