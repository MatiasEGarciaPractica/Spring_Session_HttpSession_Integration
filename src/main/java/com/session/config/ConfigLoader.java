package com.session.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class ConfigLoader extends AbstractHttpSessionApplicationInitializer {

    public ConfigLoader(){
        super(Config.class); //name of redis configuration class.
    }
}
