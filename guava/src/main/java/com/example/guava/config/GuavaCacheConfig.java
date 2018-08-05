package com.example.guava.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author weipeng_yuan
 * @date 2018-08-05
 */
@Configuration
@EnableCaching
public class GuavaCacheConfig {

    private static final String DEFAUT_LOCAL_CACHE = "default_local_cache";

    @Bean("defaultLocalCache")
    public Cache cache() {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        guavaCacheManager.setAllowNullValues(false);
        guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS));
        return guavaCacheManager.getCache(DEFAUT_LOCAL_CACHE);
    }

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        guavaCacheManager.setAllowNullValues(false);
        guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS));
        return guavaCacheManager;
    }
}
