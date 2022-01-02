package com.jamesvrooney.fraud.service;

import com.jamesvrooney.clients.model.FraudCheckResponse;
import com.jamesvrooney.fraud.model.FraudCheckHistory;
import com.jamesvrooney.fraud.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public FraudCheckResponse isFraudulentCustomer(UUID customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .isFraudster(Boolean.FALSE)
                        .build()
        );

        return new FraudCheckResponse(false);
    }
}
