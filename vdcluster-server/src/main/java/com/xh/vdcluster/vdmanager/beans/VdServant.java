package com.xh.vdcluster.vdmanager.beans;

import com.xh.vdcluster.model.StreamModel;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdService {

    private String serviceId;

    private StreamModel streamModel;

    private ConcurrentLinkedQueue<String> requestQueue;

    
}
