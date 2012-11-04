package io.webservices.test;

import io.webservices.api.WebservicesConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Rintcius Blok
 */
public class Configurations {
    @Configuration
    @Profile("prod")
    public static class ProdConfig {

        @Bean
        public WebservicesConfiguration config() {
            return new WebservicesConfiguration("demo@webservices.io", "secret");
        }
    }

    @Configuration
    @Profile("test")
    public static class TestConfig {

        @Bean
        public WebservicesConfiguration config() {
            return new WebservicesConfiguration("demo@webservices.io", "secret", WebservicesConfiguration.SSLSecurityType.INSECURE);
        }
    }

    @Configuration
    @Profile("dev")
    public static class DevConfig {

        @Bean
        public WebservicesConfiguration config() {
            return new WebservicesConfiguration("demo@webservices.io", "secret", "http://localhost:9001", WebservicesConfiguration.SSLSecurityType.SECURE);
        }
    }

}
