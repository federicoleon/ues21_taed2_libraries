package com.ues21.utils;

import com.ues21.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fleon on 1/7/17.
 */
public class NumberUtilsTest extends BaseTest {

    @Test
    public void testGetRandomInt() {
        NumberUtils nu = new NumberUtils();
        Assert.assertEquals("NumberUtils", nu.toString());

        int i = NumberUtils.getRandomTo(10);
        Assert.assertTrue("i should be bigger or equals than 0", (i >= 0));
        Assert.assertTrue("i should be smaller or equals than 10", (i <= 10));
    }
}
