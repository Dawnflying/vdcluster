package com.xh.vdcluster.vdmanager;

import com.xh.vdcluster.common.VdConfiguration;
import com.xh.vdcluster.rpc.DetectService;
import com.xh.vdcluster.rpc.DetectServiceConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by macbookpro on 17/7/23.
 */
public abstract class ServantAdapter implements ServantHandler {

    private static final Logger logger = LoggerFactory.getLogger(ServantAdapter.class);

    private String servantId;

    private DetectService.Client client;

    protected VdConfiguration configuration;

    @Override
    public void start() {
        try {
            DetectServiceConfiguration detectServiceConfiguration = new
                    DetectServiceConfiguration(servantId, configuration.getStreamURL(),configuration.getStreamType(),
                    configuration.getDecodeMode(),configuration.getFrameWidth(),configuration.getFrameHeight(),null,null);
            client.addService(detectServiceConfiguration);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void stop() {
        try{

        }
        catch (Exception e)
        {
            logger.equals(e.getMessage());
        }
    }

    @Override
    public void remove() {
        try{

        }
        catch (Exception e)
        {
            logger.equals(e.getMessage());
        }
    }
}
