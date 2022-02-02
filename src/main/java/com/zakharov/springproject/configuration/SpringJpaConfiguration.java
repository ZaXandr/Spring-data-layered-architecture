package com.zakharov.springproject.configuration;

import com.zakharov.springproject.logger.DevLogger;
import com.zakharov.springproject.logger.Logger;
import com.zakharov.springproject.logger.ProdLogger;
import com.zakharov.springproject.logger.TestLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringJpaConfiguration {


    @Value("${environment}")
    private String env;

    @Bean
    public Logger logger() {
        switch (env) {
            case "dev":
                return new DevLogger();
            case "test":
                return new TestLogger();
            default:
                return new ProdLogger();
        }
    }
}
