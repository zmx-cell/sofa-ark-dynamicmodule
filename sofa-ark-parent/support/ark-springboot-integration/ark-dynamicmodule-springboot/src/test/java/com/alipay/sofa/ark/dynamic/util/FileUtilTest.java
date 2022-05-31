/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.sofa.ark.dynamic.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hanyue
 * @version : FileUtilsTest.java, v 0.1 2022年05月31日 3:33 PM hanyue Exp $
 */
public class FileUtilTest {

    @Test
    public void testToFile() throws MalformedURLException {
        URL url = FileUtilTest.class.getResource("/");
        File file = FileUtil.toFile(url);
        Assert.assertNotNull(file);
    }

    @Test
    public void testPathBaseOn() {
        String base = "/opt/ant/sofa-ark/";
        String test = FileUtil.getPathBasedOn(base, "test");
        Assert.assertEquals(test, base + "test");
    }
}