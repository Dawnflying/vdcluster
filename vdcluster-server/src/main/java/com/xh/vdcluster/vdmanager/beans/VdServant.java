package com.xh.vdcluster.vdmanager.beans;

import com.xh.vdcluster.common.VdConfiguration;
import com.xh.vdcluster.repository.model.Stream;
import com.xh.vdcluster.vdmanager.ServantHandler;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServant implements ServantHandler {

    private String servantId;

    private Stream stream;

    public VdServant(VdConfiguration configuration){

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

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void remove() {

    }
}
