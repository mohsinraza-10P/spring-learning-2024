package com.mohsin.learn_spring_boot;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//currency-service.url=
//currency-service.username=
//currency-service.key=

@ConfigurationProperties(prefix = "currency-service")
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;

    public CurrencyServiceConfiguration(String url, String username, String key) {
        this.url = url;
        this.username = username;
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
