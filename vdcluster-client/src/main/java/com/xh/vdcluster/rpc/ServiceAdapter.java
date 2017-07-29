package com.xh.vdcluster.rpc;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bloom on 2017/7/26.
 */
public abstract class ServiceAdapter {
    private TTransport transport;

    private TProtocol protocol;

    protected DetectService.Client client;

    private ExecutorService pool = Executors.newCachedThreadPool();

    private boolean isConnected = false;

    private boolean isStopped = false;

    private Timer timer;

    public ConnectionStatusListener listener;

    protected ServiceAdapter(String host, int port) throws TException{
        transport = new TSocket(host, port);
        transport.open();
        protocol = new TBinaryProtocol(transport);
        client = new DetectService.Client(protocol);
        timer = new Timer();
    }

    private class RetryTask extends TimerTask {
        @Override
        public void run() {
            tryOpen();
        }
    }

    public void tryOpen() {
        if (isConnected) return;

        // Make sure it's closed
        transport.close();

        try {
            transport.open();
            isConnected = true;

            return;
        } catch (TTransportException e) {

        }

        timer.schedule(new ServiceAdapter.RetryTask(), 5 * 1000);
    }
}

