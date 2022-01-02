package com.jamesvrooney.customer.services;

import com.jamesvrooney.clients.fraud.FraudClient;
import com.jamesvrooney.clients.fraud.model.FraudCheckResponse;
import com.jamesvrooney.customer.model.Customer;
import com.jamesvrooney.customer.model.CustomerRegistrationRequest;
import com.jamesvrooney.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    @Override
    public Customer registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Registering new customer {}", customerRegistrationRequest);

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        Customer savedCustomer = customerRepository.save(customer);

//        final FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                savedCustomer.getId()
//        );

        final FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(savedCustomer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Customer is a fraudster");
        }

        return savedCustomer;
    }
}
