package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.common.FastdfsHelper;
import com.xh.vdcluster.rpc.DetectResult;
import com.xh.vdcluster.rpc.DetectStatus;
import com.xh.vdcluster.rpc.ReportService;
import com.xh.vdcluster.service.MessageService;
import org.apache.thrift.TException;
import org.csource.fastdfs.ClientGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/29.
 */
@Component
public class ReportServiceImpl implements ReportService.Iface {
    private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Resource
    MessageService messageService;

    @Override
    public void ping() throws TException {

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

            System.out.println(detectResult.toString());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }
}
