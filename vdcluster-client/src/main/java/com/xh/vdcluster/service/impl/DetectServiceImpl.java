package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.FastdfsHelper;
import com.xh.vdcluster.rpc.*;
import com.xh.vdcluster.service.MessageService;
import org.apache.thrift.TException;
import org.csource.fastdfs.ClientGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bloom on 2017/7/26.
 */
public class DetectServiceImpl implements DetectService.Iface {
    private static final Logger log = LoggerFactory.getLogger(DetectServiceImpl.class);


    @Resource
    MessageService messageService;


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

        log.info(detectStatus.toString());
        System.out.println(detectStatus.toString());

    }

    @Override
    public void sendSeriveDetectResult(DetectResult detectResult) throws TException {

        try {

            ClassPathResource fileResource = new ClassPathResource("/config/fdfs_client.conf");

            ClientGlobal.init(fileResource.getFile().getAbsolutePath());

            String picUrl = detectResult.getPreviewPicURL();

            String newUrl = FastdfsHelper.uploadFile(picUrl);

            detectResult.setPreviewPicURL(newUrl);

            messageService.pushMessage("",detectResult.toString());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }
}
