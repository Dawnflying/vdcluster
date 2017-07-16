package com.xh.videodetect.rpc;

import com.xh.videodetect.common.URL;

/**
 * Created by juemingzi on 16/7/12.
 */
public interface Protocol {

    <T> void export(String interfaceName, Class<T> clazz) throws Exception;

    <T> Invoker<T> refer(Class<T> type, URL url) throws Exception;

}
