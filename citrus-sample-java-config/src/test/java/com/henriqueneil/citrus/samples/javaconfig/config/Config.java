package com.henriqueneil.citrus.samples.javaconfig.config;

import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.http.client.HttpEndpointConfiguration;
import com.consol.citrus.http.server.HttpServer;
import com.consol.citrus.http.server.HttpServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Henrique Neil
 */
@Configuration
public class Config {
    
    @Bean
    public HttpClient httpClient() {
        HttpEndpointConfiguration configuration = new HttpEndpointConfiguration();
        configuration.setRequestUrl("http://127.0.0.1:9191");
        configuration.setCharset("UTF-8");
        configuration.setContentType("application/json");
        return new HttpClient(configuration);
    }
    
    @Bean
    public HttpServer httpServer() {
        return new HttpServerBuilder().autoStart(true).port(9191).build();
    }
}
