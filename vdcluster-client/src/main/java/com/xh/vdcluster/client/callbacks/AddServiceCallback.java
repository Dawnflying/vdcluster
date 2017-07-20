package com.xh.vdcluster.client.callbacks;

import com.xh.vdcluster.rpc.DetectService;
import org.apache.thrift.async.AsyncMethodCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bloom on 2017/7/19.
 */
public class AddServiceCallback implements AsyncMethodCallback<Integer> {
    private static Logger logger = LoggerFactory.getLogger(AddServiceCallback.class);
    @Override
    public void onComplete(Integer result) {
        logger.info("addService complete!!!");
        logger.info("result: "+result);
    }

    @Override
    public void onError(Exception e) {
        logger.info("addService error!!!");
    }
}