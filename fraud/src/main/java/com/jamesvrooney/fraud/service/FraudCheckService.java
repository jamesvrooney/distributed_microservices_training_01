package com.jamesvrooney.fraud.service;

import com.jamesvrooney.clients.fraud.model.FraudCheckResponse;

import java.util.UUID;

public interface FraudCheckService {
    FraudCheckResponse isFraudulentCustomer(UUID customerId);
}
