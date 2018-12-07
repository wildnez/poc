package poc.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.UserCodeDeploymentConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class POCUserCodeDepTestLiteMember {

    POCUserCodeDepTestLiteMember() {
        Config config = new Config();
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true).addMember("127.0.0.1");
        config.setLiteMember(true);
        config.setLicenseKey("");

        UserCodeDeploymentConfig userCodeDeploymentConfig = new UserCodeDeploymentConfig();

        userCodeDeploymentConfig.setWhitelistedPrefixes("poc.hazelcast");
        userCodeDeploymentConfig.setProviderMode(UserCodeDeploymentConfig.ProviderMode.LOCAL_AND_CACHED_CLASSES);
        userCodeDeploymentConfig.setClassCacheMode(UserCodeDeploymentConfig.ClassCacheMode.OFF);
        userCodeDeploymentConfig.setEnabled(true);
        config.setUserCodeDeploymentConfig(userCodeDeploymentConfig);

        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        IMap<Long, POCUserCodeDepDataModel> map = instance.getMap("poc_map");

        System.out.println("Map Entry: " + map.size());
    }

    public static void main(String[] args) {
        new POCUserCodeDepTestLiteMember();
    }
}
