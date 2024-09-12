
---

### Story: The Reliable Notification System

**Title: "The Tale of the Reliable Notification System"**

---

Once upon a time in a bustling tech town, there was a company named **TechTales** that wanted to send notifications to their customers via email. They had a simple plan: create a notification service that would send emails and ensure that every customer got their message. But, as the company grew, they realized that their notification system needed to be more robust.

**1. The Basic Email Service**

In the early days, TechTales had a straightforward service called **EmailNotificationService**. This service was responsible for sending out emails:

```java
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}
```

Everything worked fine, but as the volume of emails increased, so did the number of issues—sometimes emails failed to send, and customers were left in the dark.

**2. The Logging Hero**

To tackle this, TechTales hired **LoggingNotificationServiceDecorator** to keep track of every notification:

```java
public class LoggingNotificationServiceDecorator implements NotificationService {
    private final NotificationService decoratedService;

    public LoggingNotificationServiceDecorator(NotificationService decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Logging notification: " + message);
        decoratedService.sendNotification(message);
    }
}
```

The **LoggingDecorator** was like a diligent scribe, noting every message sent and making sure that no detail was missed. It was a great addition, but TechTales still faced occasional problems where notifications failed to be delivered.

**3. The Retry Champion**

To handle the failures, they introduced **RetryNotificationServiceDecorator**, a true champion of reliability:

```java
public class RetryNotificationServiceDecorator implements NotificationService {
    private static final int MAX_RETRIES = 3;
    private final NotificationService decoratedService;

    public RetryNotificationServiceDecorator(NotificationService decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public void sendNotification(String message) {
        int attempts = 0;
        while (attempts < MAX_RETRIES) {
            try {
                System.out.println("Retrying... Attempt " + (attempts + 1));
                decoratedService.sendNotification(message);
                break;
            } catch (Exception e) {
                attempts++;
                if (attempts >= MAX_RETRIES) {
                    throw new RuntimeException("Failed after retries", e);
                }
            }
        }
    }
}
```

The **RetryDecorator** was like a tenacious guardian, retrying to send the notification multiple times if the first attempt failed. It ensured that every notification was eventually delivered, even in the face of intermittent problems.

**4. The Heroic Ensemble**

TechTales then combined all these services in their Spring Boot application, creating a powerful notification system:

```java
@Configuration
public class AppConfig {
    @Bean
    public NotificationService emailNotificationService() {
        return new EmailNotificationService();
    }

    @Bean
    public NotificationService loggingNotificationService(NotificationService emailNotificationService) {
        return new LoggingNotificationServiceDecorator(emailNotificationService);
    }

    @Bean
    public NotificationService retryNotificationService(NotificationService loggingNotificationService) {
        return new RetryNotificationServiceDecorator(loggingNotificationService);
    }
}
```

In this setup, the **RetryDecorator** wrapped around the **LoggingDecorator**, which in turn wrapped around the core **EmailNotificationService**. This setup ensured that every email was sent, logged, and retried if needed.

**5. The Controller**

Lastly, TechTales had a **NotificationController** to trigger this robust notification system:

```java
@RestController
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody String message) {
        notificationService.sendNotification(message);
        return ResponseEntity.ok("Notification sent!");
    }
}
```

The **NotificationController** was like the manager, calling upon the combined power of the decorators to ensure that every customer received their notification.

---

And so, TechTales enjoyed a reliable and efficient notification system that combined logging, retry logic, and core email sending functionality—all thanks to the Decorator Pattern!

**[Fade Out]**

**Host (Voiceover):**
Thanks for joining us in this tale of notification reliability. If you enjoyed this story and want more tech insights, don’t forget to like, subscribe, and hit the bell icon for updates!

---
