/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.sofa.ark.dynamic.listener;

import com.alipay.sofa.ark.dynamic.common.SofaArkTestConstants;
import com.alipay.sofa.ark.dynamic.common.context.SofaArkTestContext;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import java.io.File;

/**
 * @author hanyue
 * @version : TestSofaArkTestExecutionListener.java, v 0.1 2022年05月31日 3:15 PM hanyue Exp $
 */
public class TestSofaArkTestExecutionListener implements SofaArkTestExecutionListener {

    @Override
    public void beforeInstallMaster(SofaArkTestContext testContext, ClassLoader appClassLoader) throws Exception {
        Object attribute = testContext.getAttribute(SofaArkTestConstants.MASTER_FAT_JAR);
        Assert.assertTrue(attribute instanceof File);
        File file = (File) attribute;
        Assert.assertTrue(file.exists());

        ApplicationContext applicationContext = testContext.getApplicationContext();
        Assert.assertNull(applicationContext);

        Assert.assertEquals(getClass().getClassLoader(), appClassLoader);
    }

    @Override
    public void beforeInstallBiz(SofaArkTestContext testContext, ClassLoader masterClassLoader) throws Exception {
        Object attribute = testContext.getAttribute(SofaArkTestConstants.BIZ_FAT_JAR);
        Assert.assertTrue(attribute instanceof File);
        File fIle = (File) attribute;
        Assert.assertTrue(fIle.exists());

        ApplicationContext applicationContext = testContext.getApplicationContext();
        Object sofaArkTestBean = applicationContext.getBean("sofaArkTestBean");
        Assert.assertNotNull(sofaArkTestBean);

        Assert.assertEquals(getClass().getClassLoader(), masterClassLoader);
    }

    @Override
    public void afterInstallBiz(SofaArkTestContext testContext, ClassLoader bizClassLoader) throws Exception {
        ApplicationContext applicationContext = testContext.getApplicationContext();
        Object sofaArkTestBean = applicationContext.getBean("sofaArkTestBean");
        Assert.assertNotNull(sofaArkTestBean);
    }
}