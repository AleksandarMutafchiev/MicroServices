package com.demo.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public final record CustomerController(CustomerService customerService) {

    @PostMapping("registration")
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistration) {
        log.info("New customer registration {}", customerRegistration);
        customerService.registerCustomer(customerRegistration);
    }
}
