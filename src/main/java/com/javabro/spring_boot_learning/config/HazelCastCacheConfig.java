package com.javabro.spring_boot_learning.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.*;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableCaching
public class HazelCastCacheConfig {

    @Bean
    public ClientConfig hazelcastClientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setInstanceName("my-hazelcast-client");
        clientConfig.setClusterName("spring-boot-learning-cluster");
        ClientNetworkConfig clientNetworkConfig = clientConfig.getNetworkConfig();
        clientNetworkConfig.addAddress("127.0.0.1:5701");
        NearCacheConfig nearCacheConfig = new NearCacheConfig();
        nearCacheConfig.setName("users");
        nearCacheConfig.setTimeToLiveSeconds(300);
        nearCacheConfig.setInvalidateOnChange(true);
        //nearCacheConfig.setEvictionConfig(new EvictionConfig().setSize(100).setEvictionPolicy(EvictionPolicy.LRU).setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE));
        clientConfig.addNearCacheConfig(nearCacheConfig);
        return clientConfig;
    }

    @Bean
    @Primary
    @DependsOn("hazelcastServerInstance")
    public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}
