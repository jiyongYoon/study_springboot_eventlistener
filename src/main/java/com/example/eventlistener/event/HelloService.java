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
}
