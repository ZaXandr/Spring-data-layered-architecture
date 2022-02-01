package com.zakharov.SpringJPA.configuration;

import com.zakharov.SpringJPA.logger.DevLogger;
import com.zakharov.SpringJPA.logger.Logger;
import com.zakharov.SpringJPA.logger.ProdLogger;
import com.zakharov.SpringJPA.logger.TestLogger;
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
