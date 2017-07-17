package com.xh.vdcluster;

import com.xh.vdcluster.common.URL;
import com.xh.vdcluster.registry.ChildListener;
import com.xh.vdcluster.registry.RegistryService;
import com.xh.vdcluster.registry.zookeeper.ZookeeperRegistryFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bloom on 2017/7/17.
 */
public class RegistryTest {

    public static void main(String[] args) throws Exception {

        ZookeeperRegistryFactory factory = new ZookeeperRegistryFactory();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", "admin");
        parameters.put("password", "hk123456");
        URL url = new URL("rtsp", "10.200.9.225", 554, "stream", parameters);
        RegistryService service = factory.createRegistry("10.200.8.102:2181");

        service.register(url);

        service.subscribe(url, new ChildListener() {
            @Override
            public void childChanged(String path, List<String> children) throws Exception {

            }

            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {

            }
        });
    }
}
