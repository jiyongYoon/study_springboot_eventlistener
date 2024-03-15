package com.example.eventlistener.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
@RequiredArgsConstructor
@Slf4j
public class HelloTransactionalEventListener {

    private final HelloRepository helloRepository;

//    @Async
//    @Transactional
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void helloEvent(HelloEvent helloEvent) {
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("----- listener start, {} -----", transactionName);
        save(HelloEvent.toEntity(helloEvent));
//        exception();
        log.info("----- listener finish -----");
    }

    private void save(HelloEntity helloEntity) {
        helloRepository.save(helloEntity);
    }

    private void exception() {
        throw new RuntimeException("listener exception!!");
    }
}
