package com.hz.sample;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.nio.serialization.genericrecord.GenericRecord;

public class GenericClient {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        System.out.println(clientConfig.toString());

        IMap map = client.getMap("dashboard");
        System.out.println("## bankcode:" + ((GenericRecord)map.get(1)).getInt32("bankcode"));
        System.out.println("## scndate:" + ((GenericRecord)map.get(1)).getDate("scndate"));
        HazelcastClient.shutdownAll();
    }
}