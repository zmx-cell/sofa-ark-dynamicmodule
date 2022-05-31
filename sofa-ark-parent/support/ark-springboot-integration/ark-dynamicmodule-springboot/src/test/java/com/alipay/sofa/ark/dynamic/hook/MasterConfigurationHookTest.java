/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.sofa.ark.dynamic.hook;

import com.alipay.sofa.ark.api.ArkClient;
import com.alipay.sofa.ark.dynamic.support.testng.AbstractTestNGServerlessContextTests;
import com.alipay.sofa.ark.springboot.util.RootApplicationContextUtils;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * -objectfactory com.alipay.sofa.ark.dynamic.support.testng.SofaArkTestIObjectFactory
 *
 * @author hanyue
 * @version : ConfigurationHookTest.java, v 0.1 2022年05月31日 1:48 PM hanyue Exp $
 */
public class MasterConfigurationHookTest extends AbstractTestNGServerlessContextTests {

    static {
        System.setProperty("sofa.ark.embed.enable", "true");
        System.setProperty("com.alipay.sofa.ark.master.biz", "sofa-ark-spring-guides");
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = RootApplicationContextUtils.getApplicationContext(ArkClient.getMasterBiz());
        Assert.assertNotNull(applicationContext);
        Object sofaArkTestBean = applicationContext.getBean("sofaArkTestBean");
        Assert.assertNotNull(sofaArkTestBean);
    }
}