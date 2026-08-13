package com.javabro.spring_boot_learning.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelCastServerConfig {

    @Bean(name = "hazelcastServerInstance", destroyMethod = "shutdown")
    public HazelcastInstance hazelcastServerInstance() {
        Config config = new Config();
        config.setInstanceName("my-hazelcast-instance");
        config.setClusterName("spring-boot-learning-cluster");
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getTcpIpConfig().setEnabled(true).addMember("127.0.0.1");
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("users");
        mapConfig.setTimeToLiveSeconds(120);
        mapConfig.setEvictionConfig(new EvictionConfig()
                .setSize(1000)
                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                .setEvictionPolicy(EvictionPolicy.LRU));
        config.addMapConfig(mapConfig);
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        System.out.println("Hazel Server started: ========> " + instance.getCluster().getClusterState().getId());
        System.out.println("number of members added to the hazelcast cluster ======> " + instance.getCluster().getMembers());
        return instance;
    }
}
