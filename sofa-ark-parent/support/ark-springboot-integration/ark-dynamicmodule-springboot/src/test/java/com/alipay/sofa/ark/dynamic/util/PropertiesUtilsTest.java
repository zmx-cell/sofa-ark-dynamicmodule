/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.sofa.ark.dynamic.util;

import com.alipay.sofa.ark.dynamic.common.SofaArkTestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author hanyue
 * @version : PropertiesUtilsTest.java, v 0.1 2022年05月31日 3:39 PM hanyue Exp $
 */
public class PropertiesUtilsTest {

    @Test
    public void testProperties() {
        String property = PropertiesUtils.getProperty(SofaArkTestConstants.PROJECT_BASE_DIR);
        Assert.assertEquals(property, "src/test/resources");
    }
}