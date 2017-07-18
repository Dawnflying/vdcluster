package com.xh.vdcluster.registry;

import com.xh.vdcluster.rpc.Invocation;
import com.xh.vdcluster.rpc.Invoker;
import java.util.List;

/**
 * Created by bloom on 2017/7/13.
 */
public interface Directory<T> {
    List<Invoker<T>> list(Invocation invocation);
}