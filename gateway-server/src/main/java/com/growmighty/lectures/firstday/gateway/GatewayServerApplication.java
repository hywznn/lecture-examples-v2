package com.growmighty.lectures.firstday.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // @Enable~ 애너테이션조차 필요 없다. 스타터가 곧 스위치다.
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }
}
