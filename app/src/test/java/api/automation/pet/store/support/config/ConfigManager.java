package api.automation.pet.store.support.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    private ConfigManager() {}

    public static ServerConfig getConfiguration() {
        return ConfigCache.getOrCreate(ServerConfig.class);
    }
}