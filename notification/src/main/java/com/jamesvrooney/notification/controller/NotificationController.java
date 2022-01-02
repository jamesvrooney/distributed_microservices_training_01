package com.jamesvrooney.notification.controller;

import com.jamesvrooney.clients.notification.model.RegisterCustomerNotification;
import com.jamesvrooney.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void saveNotification(@RequestBody RegisterCustomerNotification registerCustomerNotification) {
        log.info("Save new notification");

        notificationService.saveNotification(registerCustomerNotification);

        log.info("Notification saved");
    }

}
