package com.xh.vdcluster;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.DetectType;
import com.xh.vdcluster.rabbitmq.MessageAdapter;
import com.xh.vdcluster.rpc.DetectService;
import com.xh.vdcluster.rpc.DetectServiceInAdapter;
import com.xh.vdcluster.rpc.DetectServiceInAsyncAdapter;
import com.xh.vdcluster.rpc.DetectServiceOutAdapter;
import com.xh.vdcluster.service.MessageService;
import com.xh.vdcluster.service.impl.DetectServiceImpl;
import com.xh.vdcluster.service.impl.MessageServiceImpl;
import org.apache.thrift.async.AsyncMethodCallback;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/7/28.
 */

public class VdclusterClientTest {


    public static void main(String[] args) {
        try {
            MessageAdapter messageAdapter = MessageAdapter.getInstance();

            messageAdapter.setHostName("10.200.8.102");
            messageAdapter.setPort(5672);
            messageAdapter.setUserName("vdcluster");
            messageAdapter.setPassword("vdcluster");
            messageAdapter.setVirtualHost("/");

            MessageService messageService = new MessageServiceImpl();

            DetectService.Iface detectService = new DetectServiceImpl();

            DetectServiceOutAdapter detectServiceOutAdapter = new DetectServiceOutAdapter(9091, detectService);

//        DetectServiceInAsyncAdapter detectServiceInAsyncAdapter = new DetectServiceInAsyncAdapter("10.200.9.130",9090);

            DetectServiceInAdapter detectServiceInAdapter = new DetectServiceInAdapter("10.200.9.130", 9090);
            List<DetectType> detectTypes = new ArrayList<>();
            detectTypes.add(new DetectType("smoke", 0.9));
            DetectServiceConfiguration configuration = new DetectServiceConfiguration();
            configuration.setDetectType(detectTypes);
            configuration.setStreamType(0);
            configuration.setDecodeMode(0);
            configuration.setServiceId("123123123123123");
            configuration.setFrameHeight(300);
            configuration.setFrameWidth(400);
            configuration.setStreamURL("rtsp://admin:hk1234567890@10.200.9.225:554/h264/ch1/sub/av_stream");
            Thread.sleep(1000);
            detectServiceInAdapter.addService(configuration);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
