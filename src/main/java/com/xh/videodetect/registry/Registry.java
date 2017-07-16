package com.xh.videodetect.registry;

import java.net.URL;
import java.util.List;

/**
 * Created by bloom on 2017/7/13.
 */
public interface Registry {
    void register(URL url) throws Exception;
    void subscribe(URL url, NotifyListener listener) throws Exception;
    List<URL> lookup(URL url) throws Exception;
}