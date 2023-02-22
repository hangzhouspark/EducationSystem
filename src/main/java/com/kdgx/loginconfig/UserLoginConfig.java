package com.kdgx.loginconfig;

import com.kdgx.loginInter.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserLoginConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(loginInterceptor).excludePathPatterns("/loginAllUser").excludePathPatterns("/").excludePathPatterns("/js/*.js").excludePathPatterns("/css/*.css").excludePathPatterns("/img/*.jpg").excludePathPatterns("/img/*.gif");
    }
}
