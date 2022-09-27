package com.demo.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService service) {
    @GetMapping(path = "{customerId}")
    public FraudCheckHistoryResponse isFraudster(@PathVariable("customerId") Long customerId){
        boolean isFraudster = service.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer with id: {}",customerId);
        return new FraudCheckHistoryResponse(isFraudster);
    }
}
