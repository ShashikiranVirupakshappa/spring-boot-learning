import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastServer {
    //run this main method as multiple instances so that each member will be added to the cluster
    public static void main(String[] args) {
        Config config = new Config();
        config.setInstanceName("my-hazelcast-instance");
        config.setClusterName("spring-boot-learning-cluster");
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getTcpIpConfig().setEnabled(true).addMember("127.0.0.1");
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("users");
        mapConfig.setTimeToLiveSeconds(120);
        mapConfig.setEvictionConfig(new EvictionConfig().setSize(1000).setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE).setEvictionPolicy(EvictionPolicy.LRU));
        config.addMapConfig(mapConfig);
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        System.out.println("Hazel Server started: ========> "+hazelcastInstance.getCluster().getClusterState().getId());
        System.out.println("number of members added to the hazelcast cluster ======> "+hazelcastInstance.getCluster().getMembers());
    }
}