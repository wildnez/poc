package poc.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.concurrent.TimeUnit;

public class POCUserCodeDepTestClient {

    POCUserCodeDepTestClient() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getUserCodeDeploymentConfig().setEnabled(true);


        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("poc_map");
        Object result = map.executeOnKey(1L, new POCEntryProcessor());
        System.out.println("EntryProcessor execution: " + result);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Map Entry: " + map.get(1L));
    }

    public static void main(String[] args) {
        new POCUserCodeDepTestClient();
    }
}




