package com.wizz.yxr.wizzCommunity;

import com.wizz.yxr.wizzCommunity.annotation.PassToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

@SpringBootApplication
public class WizzcommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(WizzcommunityApplication.class, args);

    }


    public boolean PreHandler() {
        Object object = new Object();
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
//        检查是否有token认证 有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        return false;
    }
}