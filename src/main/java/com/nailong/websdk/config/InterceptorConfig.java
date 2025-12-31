package com.nailong.websdk.config;

import com.nailong.websdk.interceptor.AuthInterceptor;
import com.nailong.websdk.interceptor.GateWayRegionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final AppProperties appProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 认证拦截器 - 参数完整性校验，并将解析后的对象放入request attribute
        registry
                .addInterceptor(new AuthInterceptor())
                .addPathPatterns("/user/**", "/common/**")
                .excludePathPatterns("/meta/**", "/res/**")
                .order(1);

        // 网关区域拦截器
        //      - 它不做任何拦截相关操作，只做下面的内容
        //      - 获取网关添加的区域头，并将区域头放入request attribute
        //      - 如果未获取到内容 则使用默认区域(cn)
        registry
                .addInterceptor(new GateWayRegionInterceptor(appProperties))
                .addPathPatterns("/meta/**", "/res/**")
                .excludePathPatterns("/user/**", "/common/**")
                .order(2);
    }
}