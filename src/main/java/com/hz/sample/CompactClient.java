package com.hz.sample;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hz.sample.domain.Dashboard;
import com.hz.sample.domain.DashboardSerializer;

/**
 * The server config maps dashboard database table to Hazelcast IMap dashboard but this class uses compact serializer to retrieve the data.
 * https://docs.hazelcast.com/hazelcast/5.4/serialization/compact-serialization
 * Please see documentation for other more efficient ways to register serializers.
 * 
 */
public class CompactClient {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1");
        clientConfig.getSerializationConfig().getCompactSerializationConfig().addSerializer(new DashboardSerializer());
    try{
            HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
            IMap<Long, Dashboard> map = client.getMap("dashboard");
            System.out.println("## bankcode:" + map.get(1L).getBankcode());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HazelcastClient.shutdownAll();
        }
    }
}
