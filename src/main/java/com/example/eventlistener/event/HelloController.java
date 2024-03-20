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

    @GetMapping("/hello2")
    public HelloEntity hello2() {
        log.info("----- controller start -----");
        HelloEntity helloEntity = helloService.hello2();
        log.info("----- controller step2 -----");
        HelloEntity helloEntity1 = helloService.getHelloEntity(helloEntity.getId());
        log.info("----- controller finish -----");
        return helloEntity1;
    }

    // OSIV false인 경우, 영속성 컨텍스트가 종료되므로 select 쿼리 발생
    @GetMapping("/hello3")
    public HelloDto hello3() {
        log.info("----- controller start -----");
        HelloDto helloDto = helloService.hello3();
        log.info("----- controller step2 -----");
        HelloDto helloDto1 = helloService.getHelloDto(helloDto.getId());
        log.info("----- controller finish -----");
        return helloDto1;
    }

    @GetMapping("/hello4")
    public HelloDto hello4() {
        log.info("----- controller start -----");
        HelloEntity helloEntity = helloService.hello4();
        log.info("----- controller step2 -----");
        helloService.update(helloEntity); // dirty check
        log.info("----- controller finish -----");
        return HelloDto.toDto(helloEntity);
    }
}
