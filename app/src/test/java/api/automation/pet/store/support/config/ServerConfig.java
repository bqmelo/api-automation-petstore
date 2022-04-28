package api.automation.pet.store.support.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${ENV}.properties",
        "classpath:properties/local.properties"})
public interface ServerConfig extends Config {
    @Key("api.base.url")
    String baseURI();

    @Key("api.base.path")
    String basePath();

    int port();
}