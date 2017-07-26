package com.xh.vdcluster.rpc;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.rpc.impl.DetectServiceImpl;
import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import java.util.List;

/**
 * Created by bloom on 2017/7/26.
 */
public class DetectServiceAdapter{

    private static DetectService.Processor processor;

    public DetectServiceAdapter(DetectService.Iface service){
        try {

            processor = new DetectService.Processor(service);
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
