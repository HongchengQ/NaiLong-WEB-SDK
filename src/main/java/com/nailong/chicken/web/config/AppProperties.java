package com.nailong.chicken.web.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
    private Map<String, GateServer> gateServerMap;
    private String nebulaCommandServer;
    private String nebulaCommandServerAuthToken;
    private String defaultRegion;
    private String toolBoxUrl;
    private String openIpUrl;

    @Data
    public static class GateServer {
        String gateServerAddress;
        String reportServerAddress;
        String bigVersion;
        Integer dataVersion;
        Integer statusCode;
        Integer zoneId;
    }
}
