package com.session.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisIndexedHttpSession;

@Configuration(proxyBeanMethods = false)
@EnableRedisIndexedHttpSession //to listen session events
public class RedisConfig {

    @Value("${REDIS_CLOUD_HOST_NAME}")
    private String redisHostName;
    @Value("${REDIS_CLOUD_PORT}")
    private int redisPort;
    @Value("${REDIS_CLOUD_PASSWORD}")
    private String redisPassword;
    @Value("${REDIS_CLOUD_DATABASE}")
    private int redisDatabase;

    @Bean//RedisConnectionFactory , connects Spring Session to the Redis Server.
    public LettuceConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisHostName);
        config.setPort(redisPort);
        config.setPassword(redisPassword);
        config.setDatabase(redisDatabase);
        return new LettuceConnectionFactory(config);
    }


}
