package com.xh.vdcluster.vdmanager.beans;

import com.xh.vdcluster.repository.model.Stream;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VdServant {

    private String serviceId;

    private Stream streamModel;

    private ConcurrentLinkedQueue<String> requestQueue;

    
}
