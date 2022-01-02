package com.jamesvrooney.notification.service;

import com.jamesvrooney.clients.notification.model.RegisterCustomerNotification;

public interface NotificationService {
    void saveNotification(RegisterCustomerNotification notification);
}
