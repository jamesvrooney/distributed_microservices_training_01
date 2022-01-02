package com.jamesvrooney.clients.notification;

import com.jamesvrooney.clients.notification.model.RegisterCustomerNotification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification",
        path = "api/v1/notification"
)
public interface NotificationClient {

    @PostMapping
    void saveNotification(@RequestBody RegisterCustomerNotification registerCustomerNotification);
}
