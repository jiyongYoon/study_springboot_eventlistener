package com.example.eventlistener.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class HelloService {

    private final ApplicationEventPublisher eventPublisher;

    private final HelloRepository helloRepository;

    public void helloEvent() {
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("----- service start, {} -----", transactionName);
        HelloEvent helloEvent = HelloEvent.builder()
            .name("hello 1")
            .build();
        eventPublisher.publishEvent(helloEvent);
        log.info("----- service finish -----");
//        throw new RuntimeException("service exception!!");
    }

    public HelloEntity hello2() {
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("----- service start, {} -----", transactionName);
        HelloEntity helloEntity = HelloEntity.builder()
            .name("hello 2")
            .build();
        HelloEntity savedHello = helloRepository.save(helloEntity);
        log.info("----- service finish -----");
        return savedHello;
    }

    public HelloEntity getHelloEntity(Long id) {
        return helloRepository.findById(id)
            .orElseThrow();
    }

    public HelloDto hello3() {
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("----- service start, {} -----", transactionName);
        HelloEntity helloEntity = HelloEntity.builder()
            .name("hello 3")
            .build();
        HelloEntity savedHello = helloRepository.save(helloEntity);
        log.info("----- service finish -----");
        return HelloDto.toDto(savedHello);
    }

    public HelloDto getHelloDto(Long id) {
        return HelloDto.toDto(helloRepository.findById(id).orElseThrow());
    }

    public HelloEntity hello4() {
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("----- service start, {} -----", transactionName);
        HelloEntity helloEntity = HelloEntity.builder()
            .name("hello 4")
            .build();
        HelloEntity savedHello = helloRepository.save(helloEntity);
        log.info("----- service finish -----");
        return savedHello;
    }

    public void update(HelloEntity helloEntity) {
        helloEntity.setName("hello 수정");
    }
}
