package com.xh.videodetect.registry.zookeeper;

import com.xh.videodetect.common.URL;
import com.xh.videodetect.registry.ChildListener;
import com.xh.videodetect.registry.StateListener;
import java.util.List;

/**
 * Created by bloom on 2017/7/13.
 */
public interface ZkClient {

    void create(URL url) throws Exception;

    List<String> getChildNode(String path) throws Exception;

    List<String> addNodeListener(final URL url, final ChildListener listener) throws Exception;

    void addStateListener(StateListener stateListener);

}