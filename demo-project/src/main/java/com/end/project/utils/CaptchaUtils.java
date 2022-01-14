package com.end.project.utils;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.util.FastByteArrayOutputStream;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CaptchaUtils {


    /**
     * 生成验证码
     * @return
     * @throws IOException
     */
    public static Map<String,String> validateCode(DefaultKaptcha captchaProducer) throws IOException {
        Map<String,String> map = new HashMap<>();
        String capText = captchaProducer.createText();
        map.put("capText",capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        ImageIO.write(bi, "jpg", os);
        os.flush();
        os.close();
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encodeBuffer(os.toByteArray()).trim();
        base64 = base64.replaceAll("\n", "").replaceAll("\r", "");
        map.put("base64",base64);
        return map;
    }

}
