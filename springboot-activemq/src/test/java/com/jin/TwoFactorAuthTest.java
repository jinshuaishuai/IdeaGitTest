package com.jin;

import com.j256.twofactorauth.TimeBasedOneTimePasswordUtil;
import org.junit.Test;

import java.security.GeneralSecurityException;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/26 18:27
 */
public class TwoFactorAuthTest {
    public static void main(String[] args) throws GeneralSecurityException, InterruptedException {

        String base32Secret = "NY4A5CPJZ46LXZCP";

        System.out.println("secret = " + base32Secret);

        // this is the name of the key which can be displayed by the authenticator program
        String keyId = "jinshuaishuai";
        // generate the QR code
        System.out.println("Image url = " + TimeBasedOneTimePasswordUtil.qrImageUrl(keyId, base32Secret));
        // we can display this image to the user to let them load it into their auth program

        // we can use the code here and compare it against user input
        String code = TimeBasedOneTimePasswordUtil.generateCurrentNumberString(base32Secret);

        /*
         * this loop shows how the number changes over time
         */
        while (true) {
            long diff = TimeBasedOneTimePasswordUtil.DEFAULT_TIME_STEP_SECONDS
                    - ((System.currentTimeMillis() / 1000) % TimeBasedOneTimePasswordUtil.DEFAULT_TIME_STEP_SECONDS);
            code = TimeBasedOneTimePasswordUtil.generateCurrentNumberString(base32Secret);
            System.out.println("Secret code = " + code + ", change in " + diff + " seconds");
            Thread.sleep(1000);
        }
    }

    @Test
    public void test1() {
        String base32Secret = TimeBasedOneTimePasswordUtil.generateBase32Secret();
        System.out.println(base32Secret);
        String keyId = "jinshuaishuai";
        String url = TimeBasedOneTimePasswordUtil.qrImageUrl(keyId, base32Secret);
        System.out.println(url);
    }

}
