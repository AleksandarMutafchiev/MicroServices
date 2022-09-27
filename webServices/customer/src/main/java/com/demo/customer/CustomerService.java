package com.demo.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public final record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .secondName(request.secondName())
                .email(request.email()).build();

        customerRepository.saveAndFlush(customer);

        FraudCheckHistoryResponse response = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckHistoryResponse.class, customer.getId());
        if (response != null && response.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
