package com.demo.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(FraudCheckHistoryRepository repository) {

    public boolean isFraudulentCustomer(Long customerId){
        repository.save(
                FraudCheckHistory.builder().
                        id(customerId).
                        isFraudster(false).
                        createdAt(LocalDateTime.now()).
                        build());
        return false;
    }
}
