package com.xh.vdcluster.rpc;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.ThriftResult;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bloom on 2017/7/28.
 */
public class DetectServiceInAdapter implements ServiceAdapter{

    private TTransport transport;

    private TProtocol protocol;

    private DetectService.Client client;

    private ExecutorService pool = Executors.newCachedThreadPool();

    private boolean isConnected = false;

    private boolean isStopped = false;

    public DetectServiceInAdapter(String host, int port) throws TException {
        transport = new TSocket(host, port);
        transport.open();
        protocol = new TBinaryProtocol(transport);
        client = new DetectService.Client(protocol);
    }

    public ThriftResult addService(DetectServiceConfiguration serviceConfig) throws TException {
        try {
            client.addService(serviceConfig);
            return new ThriftResult(ThriftResult.SUCCESS,null,Void.class);
        } catch (TException ex) {
            return new ThriftResult(ThriftResult.FAILED,null,Void.class);
        }
    }

    public ThriftResult deleteService(String serviceId) throws TException {
        try {
            SeviceStatusType type =  client.deleteService(serviceId);
            return new ThriftResult(ThriftResult.SUCCESS, type, SeviceStatusType.class);
        } catch (TException ex) {
            return new ThriftResult(ThriftResult.FAILED, null, SeviceStatusType.class);
        }
    }

    public ThriftResult checkService(String serviceId) throws TException {
        try {
            SeviceStatusType type =  client.checkService(serviceId);
            return new ThriftResult(ThriftResult.SUCCESS, type, SeviceStatusType.class);
        } catch (TException ex) {
            return new ThriftResult(ThriftResult.FAILED, null, SeviceStatusType.class);
        }
    }

    public ThriftResult getMaxServiceNum() throws TException {
        try {
            int num =  client.getMaxServiceNum();
            return new ThriftResult(ThriftResult.SUCCESS, num, int.class);
        } catch (TException ex) {
            return new ThriftResult(ThriftResult.FAILED, null, int.class);
        }

    }

    public ThriftResult getServices() throws TException {
        try {
            List<String> services =  client.getServices();
            return new ThriftResult(ThriftResult.SUCCESS, services, List.class);
        } catch (TException ex) {
            return new ThriftResult(ThriftResult.FAILED, null, List.class);
        }
    }

}
