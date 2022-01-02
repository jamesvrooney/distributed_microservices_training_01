package com.jamesvrooney.fraud.controller;

import com.jamesvrooney.clients.fraud.model.FraudCheckResponse;
import com.jamesvrooney.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable UUID customerId) {
        FraudCheckResponse fraudCheckResponse = fraudCheckService.isFraudulentCustomer(customerId);

        log.info("Fraud check for customer {} - Response {}", customerId, fraudCheckResponse);

        return fraudCheckResponse;
    }
}
