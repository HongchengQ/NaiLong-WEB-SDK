package com.nailong.chicken.web;

import com.nailong.chicken.web.config.AppProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebsdkApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AppProperties appProperties;

    @Test
    void test() {
        IO.println(appProperties);
    }

}
