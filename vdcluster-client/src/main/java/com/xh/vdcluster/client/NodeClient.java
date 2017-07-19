package com.xh.vdcluster.client;

import com.xh.vdcluster.client.callbacks.AddServiceCallback;
import com.xh.vdcluster.rpc.DetectService;
import com.xh.vdcluster.rpc.DetectServiceConfiguration;
import org.apache.thrift.TException;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bloom on 2017/7/19.
 */
public class NodeClient {

    public void start() throws Exception {
        TTransport transport = new TSocket("10.200.9.130", 9090);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        DetectService.Client client = new DetectService.Client(protocol);
        DetectServiceConfiguration configuration = new DetectServiceConfiguration();
        configuration.setServiceId("test_id_123");
        configuration.setDecodeMode(1);
        configuration.setStreamURL("rtsp://admin:hk1234567890@10.200.9.225:554/h264/ch1/sub/av_stream");
        List<Integer> typeList = new ArrayList<Integer>();
        typeList.add(1);
        typeList.add(2);
        configuration.setDetectType(typeList);
        configuration.setStreamType(1);
        Map<Integer, Double> detectSensitivity = new HashMap<>();
        detectSensitivity.put(1, 0.3);
        detectSensitivity.put(2, 0.4);
        configuration.setDetectSensitivity(detectSensitivity);
        configuration.setFrameWidth(1080);
        configuration.setFrameHeight(768);
        while (true) {
            int result = client.addService(configuration);
            Thread.sleep(10);
        }
//        transport.close();
//        TProtocolFactory tProtocolFactory = new TCompactProtocol.Factory();
//        TAsyncClientManager tAsyncClientManager = new TAsyncClientManager();
//        TNonblockingSocket tNonblockingSocket = new TNonblockingSocket("10.200.9.130", 9090);
//        DetectService.AsyncClient asyncClient = new DetectService.AsyncClient(tProtocolFactory, tAsyncClientManager, tNonblockingSocket);
//        AddServiceCallback addServiceCallback = new AddServiceCallback();
//        while (true) {
//            asyncClient.addService(configuration, addServiceCallback);
//            Thread.sleep(2000);
//        }

    }

}
