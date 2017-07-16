package com.xh.videodetect.registry;

import com.xh.videodetect.rpc.Invocation;
import com.xh.videodetect.rpc.Invoker;

import java.util.List;

/**
 * Created by bloom on 2017/7/13.
 */
public interface Directory<T> {
    List<Invoker<T>> list(Invocation invocation);
}