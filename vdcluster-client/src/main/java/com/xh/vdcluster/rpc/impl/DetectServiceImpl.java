package com.xh.vdcluster.rpc.impl;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.rpc.*;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by bloom on 2017/7/26.
 */
public class DetectServiceImpl implements DetectService.Iface {

    @Override
    public void addService(DetectServiceConfiguration serviceConfig) throws TException {

    }

    @Override
    public SeviceStatusType deleteService(String serviceId) throws TException {

        return null;

    }

    @Override
    public SeviceStatusType checkService(String serviceId) throws TException {

        return null;

    }

    @Override
    public int getMaxServiceNum() throws TException {

        return 0;

    }

    @Override
    public List<String> getServices() throws TException {

        return null;

    }

    @Override
    public void reportServiceStatus(DetectStatus detectStatus) throws TException {



    }

    @Override
    public void sendSeriveDetectResult(DetectResult detectResult) throws TException {



    }
}
