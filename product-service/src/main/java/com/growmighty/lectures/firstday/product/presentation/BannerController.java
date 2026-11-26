package com.growmighty.lectures.firstday.product.presentation;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RefreshScope: /actuator/refresh 신호가 오면 이 빈을 버리고 새로 만든다.
// 그때 @Value 가 "새 설정값"으로 다시 주입된다 — 재시작 없는 설정 변경의 열쇠.
@RefreshScope
@RestController
public class BannerController {

    // config-repo/product-service.yml 의 값이 주입된다. 뒤의 :기본값 은 못 받았을 때의 보험.
    @Value("${product.banner.message:이벤트 준비 중}")
    private String bannerMessage;

    @GetMapping("/products/banner")
    public Map<String, String> banner() {
        return Map.of("message", bannerMessage);
    }
}
