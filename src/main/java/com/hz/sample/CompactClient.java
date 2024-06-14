package com.hz.sample;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hz.sample.domain.Dashboard;
import com.hz.sample.domain.DashboardSerializer;

/**
 * Incomplete class.
 * Client that uses Compact Serialization
 * https://docs.hazelcast.com/hazelcast/5.4/serialization/compact-serialization
 * 
 */
public class CompactClient {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1");
        clientConfig.getSerializationConfig().getCompactSerializationConfig().addClass(DashboardSerializer.class);
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
