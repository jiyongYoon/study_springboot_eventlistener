package com.example.eventlistener.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public void helloEvent() {
        log.info("----- controller start -----");
        helloService.helloEvent();
        log.info("----- controller finish -----");
    }

}
