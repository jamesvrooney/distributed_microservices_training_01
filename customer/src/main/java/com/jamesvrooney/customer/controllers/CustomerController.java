package com.jamesvrooney.customer.controllers;

import com.jamesvrooney.customer.model.Customer;
import com.jamesvrooney.customer.model.CustomerRegistrationRequest;
import com.jamesvrooney.customer.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {

        log.info("New customer registration: {}", customerRegistrationRequest);
        Customer savedCustomer = customerService.registerCustomer(customerRegistrationRequest);

        return ResponseEntity.ok(savedCustomer);
    }
}
