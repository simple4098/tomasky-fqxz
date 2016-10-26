package com.tomasky.serviceName.common;

import com.tomasky.fqxz.common.utils.HttpClientUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpTest
 *
 * @author momo
 * @date 16-10-26
 */
public class HttpTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpTest.class);

    @Test
    public void httpTest() {

        System.out.println(HttpClientUtil.getImageBase64EncoderByGet("http://dimg10.c-ctrip.com/images/230s060000001k53i25DF_W_550_412.jpg"));

        System.out.println(HttpClientUtil.getResponseInfoByGet("http://dimg10.c-ctrip.com/images/230s060000001k53i25DF_W_550_412.jpg"));

    }
}
