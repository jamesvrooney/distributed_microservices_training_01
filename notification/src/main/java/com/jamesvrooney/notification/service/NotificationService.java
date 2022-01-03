package com.jamesvrooney.notification.service;

import com.jamesvrooney.clients.notification.model.NotificationRequest;

public interface NotificationService {
    void saveNotification(NotificationRequest notification);
}
