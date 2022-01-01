package com.jamesvrooney.customer.services;

import com.jamesvrooney.customer.model.Customer;
import com.jamesvrooney.customer.model.CustomerRegistrationRequest;

public interface CustomerService {
    Customer registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
}
