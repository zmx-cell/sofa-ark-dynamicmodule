/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.sofa.ark.dynamic.launcher;

import com.alipay.sofa.ark.dynamic.util.JarUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.alipay.sofa.ark.dynamic.launcher.PrepareLauncher.TARGET_BIZ_PACKAGE_SH;
import static com.alipay.sofa.ark.dynamic.launcher.PrepareLauncher.TARGET_MASTER_PACKAGE_SH;
import static com.alipay.sofa.ark.dynamic.launcher.PrepareLauncher.checkAndCopySh;
import static com.alipay.sofa.ark.dynamic.launcher.PrepareLauncher.checkBizFatJar;
import static com.alipay.sofa.ark.dynamic.launcher.PrepareLauncher.checkMasterFatJAr;

/**
 * @author hanyue
 * @version : PrepareLauncherTest.java, v 0.1 2022年05月31日 3:46 PM hanyue Exp $
 */
public class PrepareLauncherTest {

    @Test
    public void testCheckAndCopySh() throws IOException {
        checkAndCopySh();

        String targetMasterPackageSh = TARGET_MASTER_PACKAGE_SH;
        String targetBizPackageSh = TARGET_BIZ_PACKAGE_SH;

        Assert.assertTrue(new File(targetMasterPackageSh).exists());
        Assert.assertTrue(new File(targetBizPackageSh).exists());
    }

    @Test
    public void testCheckMasterFatJAr() throws Exception {
        checkAndCopySh();
        checkMasterFatJAr();

        File masterBizFatJar = JarUtils.getMasterBizFatJar();
        Assert.assertTrue(masterBizFatJar.exists());
    }

    @Test
    public void testCheckBizFatJar() throws Exception {
        checkAndCopySh();
        checkBizFatJar();

        File bizFatJar = JarUtils.getBizFatJar();
        Assert.assertTrue(bizFatJar.exists());
    }
}