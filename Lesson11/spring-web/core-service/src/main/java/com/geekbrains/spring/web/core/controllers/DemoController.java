package com.geekbrains.spring.web.core.controllers;

import com.geekbrains.spring.web.api.dto.StringResponse;
import com.geekbrains.spring.web.core.integrations.CartServiceIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final CartServiceIntegration cartServiceIntegration;

    @GetMapping
    public StringResponse demo() {
        cartServiceIntegration.getUserCart("1");
        return new StringResponse("OK");
    }
}
