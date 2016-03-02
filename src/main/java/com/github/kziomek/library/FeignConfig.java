package com.github.kziomek.library;

import feign.Contract;
import feign.Logger;
import feign.jaxrs.JAXRSContract;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@Configuration
@EnableFeignClients
public class FeignConfig {

    @Bean
    public feign.Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Contract feignContract() {
        return new JAXRSContract();
    }


}
