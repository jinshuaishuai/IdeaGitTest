package com.jin.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jin.GoogleAuthenticatorUtil;
import com.jin.entity.ao.DynamicCodeAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;


/**
 * @author shuai.jin
 * @date 2020/6/2 14:04
 */

@Controller
@Slf4j
public class QRCodeController {

    @GetMapping(value = "test")
    public String test(HttpServletRequest request) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        //每个用户对应一个秘钥，
        String secret = GoogleAuthenticatorUtil.generateSecret();
        System.out.println(secret);
        String qrCode = GoogleAuthenticatorUtil.getQrBarcode("lisi@qq.com", secret);

        BitMatrix bitMatrix = qrCodeWriter.encode(qrCode, BarcodeFormat.QR_CODE, 128, 128);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "jpg", outputStream);

        Base64.Encoder encoder = Base64.getEncoder();

        String text = encoder.encodeToString(outputStream.toByteArray());
        request.setAttribute("text",text);

        return "test";
    }

    @PostMapping(value = "checkDynamicCode")
    public void checkDynamicCode(@RequestBody DynamicCodeAO dynamicCodeAO) {
       log.info("接口请求入参为：------>{}", dynamicCodeAO);
        boolean b = GoogleAuthenticatorUtil.checkCode(dynamicCodeAO.getSecret(), dynamicCodeAO.getDynamicCode(), System.currentTimeMillis());
        log.info("验证是否通过：------>{}", b);
    }
}
