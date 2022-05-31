package com.alipay.sofa.ark.dynamic.hook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAutoConfigurationHook implements BizConfigurationHook, MasterConfigurationHook {

    @Bean
    public SofaArkTestBean sofaArkTestBean() {
        return new SofaArkTestBean();
    }
}