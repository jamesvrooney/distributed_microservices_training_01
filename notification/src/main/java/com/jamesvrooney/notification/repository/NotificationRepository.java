package com.jamesvrooney.notification.repository;

import com.jamesvrooney.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
