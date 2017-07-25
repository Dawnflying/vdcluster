package com.xh.vdcluster.rpc;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;


/**
 * Created by bloom on 2017/7/25.
 */
public class NodeServiceServer {

    private static DetectService.Processor processor;
    private static DetectService.Iface detectService;

    public void start() {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
