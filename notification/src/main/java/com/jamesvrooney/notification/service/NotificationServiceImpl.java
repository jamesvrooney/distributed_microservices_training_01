package com.jamesvrooney.notification.service;

import com.jamesvrooney.clients.notification.model.RegisterCustomerNotification;
import com.jamesvrooney.notification.model.Notification;
import com.jamesvrooney.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void saveNotification(RegisterCustomerNotification notification) {
        Notification savedNotification = notificationRepository.save(Notification.builder()
                        .customerId(notification.getCustomerId())
                        .message(notification.getMessage())
                .build()
        );

        log.info("New notification - {} - saved for customer - {}", savedNotification.getId(), notification.getCustomerId());
    }
}
