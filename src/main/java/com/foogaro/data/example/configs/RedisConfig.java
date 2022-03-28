package com.foogaro.data.example.configs;

import com.foogaro.data.example.repositories.ActorRepository;
import com.foogaro.data.example.repositories.MovieRepository;
import com.foogaro.data.redisframework.FTSDetector;
import com.foogaro.data.redisframework.handlers.DataStoreInvocationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class RedisConfig {

    @Bean
    public FTSDetector getFTSDetector() {
        return new FTSDetector("com.foogaro.data.example.models");
    }

    @Bean
    public ActorRepository actorRepository() {
        DataStoreInvocationHandler invocationHandler = new DataStoreInvocationHandler();
        return (ActorRepository) Proxy.newProxyInstance(
                DataStoreInvocationHandler.class.getClassLoader(),
                new Class[] { ActorRepository.class},
                invocationHandler);
    }

    @Bean
    public MovieRepository movieRepository() {
        DataStoreInvocationHandler invocationHandler = new DataStoreInvocationHandler();
        return (MovieRepository) Proxy.newProxyInstance(
                DataStoreInvocationHandler.class.getClassLoader(),
                new Class[] { MovieRepository.class},
                invocationHandler);
    }

}