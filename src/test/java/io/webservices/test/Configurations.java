package io.webservices.test;

import io.webservices.api.WebservicesConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Rintcius Blok
 */
public class Configurations {

    public static final String DEMO_USERNAME = "demo@webservices.io";

    public static final String DEMO_PASSWORD = "secret";

    @Configuration
    @Profile("prod")
    public static class ProdConfig {

        @Bean
        public WebservicesConfiguration config() {
            return new WebservicesConfiguration(DEMO_USERNAME, DEMO_PASSWORD);
        }
    }

    @Configuration
    @Profile("dev")
    public static class DevConfig {

        @Bean
        public WebservicesConfiguration config() {
            return new WebservicesConfiguration(DEMO_USERNAME, DEMO_PASSWORD, "http://localhost:9001");
        }
    }

}
