package com.xh.vdcluster.service;

import com.xh.vdcluster.model.StreamModel;

import java.util.List;

/**
 * Created by bloom on 2017/7/16.
 */
public interface StreamService {

    StreamModel createStream();

    List<StreamModel> listStreams();

    StreamModel getStream();

    StreamModel unregisterStream();

    boolean registerStream(StreamModel streamModel);
}