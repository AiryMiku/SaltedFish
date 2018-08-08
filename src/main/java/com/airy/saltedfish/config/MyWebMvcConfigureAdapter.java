package com.airy.saltedfish.config;

import com.airy.saltedfish.interceptor.TokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Airy on 2018/8/8
 */
@Configuration
public class MyWebMvcConfigureAdapter extends WebMvcConfigurerAdapter {

    @Bean
    public TokenVerifyInterceptor tokenVerifyInterceptor(){
        return new TokenVerifyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenVerifyInterceptor())
//                .addPathPatterns("/saltedfish/api/")
//                .excludePathPatterns("/saltedfish/api/message");
        super.addInterceptors(registry);
    }
}
