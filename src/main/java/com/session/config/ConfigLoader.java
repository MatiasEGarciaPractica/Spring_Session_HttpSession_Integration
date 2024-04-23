package com.session.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class ConfigLoader extends AbstractHttpSessionApplicationInitializer {

    public ConfigLoader(){
        super(RedisConfig.class); //name of redis configuration class.
    }
}
