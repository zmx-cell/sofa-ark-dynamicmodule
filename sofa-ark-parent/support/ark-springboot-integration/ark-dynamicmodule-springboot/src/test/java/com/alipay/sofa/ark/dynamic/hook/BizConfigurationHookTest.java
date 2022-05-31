/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.sofa.ark.dynamic.hook;

import com.alipay.sofa.ark.dynamic.support.testng.AbstractTestNGServerlessContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * -objectfactory com.alipay.sofa.ark.dynamic.support.testng.SofaArkTestIObjectFactory
 *
 * @author hanyue
 * @version : TestConfigurationHookTest.java, v 0.1 2022年05月31日 1:49 PM hanyue Exp $
 */
public class BizConfigurationHookTest extends AbstractTestNGServerlessContextTests {

    static {
        System.setProperty("sofa.ark.embed.enable", "true");
        System.setProperty("com.alipay.sofa.ark.master.biz", "sofa-ark-spring-guides");
    }

    @Autowired
    private SofaArkTestBean sofaArkTestBean;

    @Test
    public void test() {
        Assert.assertNotNull(sofaArkTestBean);

        String name = "11";
        String string = sofaArkTestBean.getString(name);
        Assert.assertEquals(name, string);
    }
}