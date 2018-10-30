package com.eway.sample.config

import com.eway.common.util.HttpUtil
import groovy.util.logging.Slf4j
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

import java.util.concurrent.TimeUnit

@Configuration
@Slf4j
class AppConfig {
    final long TIME_OUT_5_MINS = 300l

    @Autowired Environment environment

    @Bean(name="okHttpClient")
    OkHttpClient okHttpClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(TIME_OUT_5_MINS, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT_5_MINS, TimeUnit.SECONDS).readTimeout(TIME_OUT_5_MINS, TimeUnit.SECONDS).build()
        HttpUtil.setClient(httpClient)
        log.info("Init okHttpClient with timeout => {}", TIME_OUT_5_MINS)
        return httpClient
    }
}