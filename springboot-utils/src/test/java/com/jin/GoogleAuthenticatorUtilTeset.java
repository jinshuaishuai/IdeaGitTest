package com.jin;

import org.junit.Test;

/**
 * @author shuai.jin
 * @date 2020/7/6 17:38
 */
public class GoogleAuthenticatorUtilTeset {


    @Test
    public void test1() {
        String jinshuai = GoogleAuthenticatorUtil.getQrBarcode("jinshuai", "123456");
        System.out.println(jinshuai);
    }
}
