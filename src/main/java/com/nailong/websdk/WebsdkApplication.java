package com.nailong.websdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsdkApplication {
    /**
     * todo
     * - 省流模式 : 根据网关附加的区域头 将大文件重定向至 CDN
     */
    static void main(String[] args) {
        SpringApplication.run(WebsdkApplication.class, args);
    }
}
