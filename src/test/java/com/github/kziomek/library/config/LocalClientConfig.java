package com.github.kziomek.library.config;

import feign.Feign;
import feign.Logger;
import feign.jaxrs.JAXRSContract;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@Configuration
public class LocalClientConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    private final static String API_BASE_URL = "http://localhost:4000";


    @Bean
    public CentralLibraryClient getCentralLibraryClient() {
        return Feign.builder().logger(new Slf4jLogger())
                .encoder(new SpringEncoder(messageConverters))
                .decoder(new ResponseEntityDecoder(new SpringDecoder(messageConverters)))
                .logLevel(Logger.Level.FULL)
                /* TODO Try SpringMvcContract in version newer then 1.0.4.RELEASE
                        1.0.4 causes many requests and timeouts when invoking
                 */
//               .contract(new SpringMvcContract())
                .contract(new JAXRSContract())
//                .errorDecoder(new ClientExceptionDecoder())
                .target(CentralLibraryClient.class, API_BASE_URL);
    }

}
