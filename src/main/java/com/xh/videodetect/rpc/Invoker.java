package com.xh.videodetect.rpc;

/**
 * Created by bloom on 2017/7/13.
 */
public interface Invoker<T> {

    /**
     * get service interface.
     *
     * @return service interface.
     */
    Class<T> getInterface();

    /**
     * invoke.
     *
     * @param invocation
     * @return result
     * @throws Exception
     */
    Result invoke(Invocation invocation) throws Exception;

}