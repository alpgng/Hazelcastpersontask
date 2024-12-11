package com.example;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.UUID;

public class HazelcastMapExample {
    public static void main(String[] args) {
        // Connect to the Hazelcast server
        HazelcastInstance client = HazelcastClient.newHazelcastClient();

        // Get the map
        IMap<String, Person> personMap = client.getMap("personMap");

        // Put 10,000 Person objects into the map
        for (int i = 1; i <= 10_000; i++) {
            String id = UUID.randomUUID().toString();
            Person person = new Person(id, "Person" + i);
            personMap.put(id, person);
        }

        System.out.println("10,000 Person objects added to Hazelcast map.");

        // Retrieve and print the first object
        String sampleKey = personMap.keySet().iterator().next();
        Person retrievedPerson = personMap.get(sampleKey);
        System.out.println("Retrieved Person: " + retrievedPerson);
        ClientConfig clientConfig = new ClientConfig();
       
      
    clientConfig.setClusterName("dev");  // Replace with your actual cluster name
    clientConfig.getNetworkConfig().addAddress("localhost:5701");  // Use the appropriate address

        // Shutdown the client
        client.shutdown();
    }
   

}
