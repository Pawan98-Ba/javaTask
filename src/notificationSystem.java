class MissingDetailException extends Exception {
    public MissingDetailException(String message) {
        super(message);
    }
}

abstract class Notification {
    private String recipient;

    public Notification(String recipient) throws MissingDetailException {
        if (recipient == null || recipient.isEmpty()) {
            throw new MissingDetailException("Recipient cannot be empty!");
        }
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public abstract void send() throws MissingDetailException;
}

class EmailNotification extends Notification {
    private String subject;
    private String body;

    public EmailNotification(String recipient, String subject, String body) throws MissingDetailException {
        super(recipient);
        if (subject == null || subject.isEmpty() || body == null || body.isEmpty()) {
            throw new MissingDetailException("Email must have subject and body!");
        }
        this.subject = subject;
        this.body = body;
    }

    @Override
    public void send() {
        System.out.println("Sending Email to " + getRecipient());
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}

class SMSNotification extends Notification {
    private String message;

    public SMSNotification(String recipient, String message) throws MissingDetailException {
        super(recipient);
        if (message == null || message.isEmpty()) {
            throw new MissingDetailException("SMS must have a message!");
        }
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + getRecipient());
        System.out.println("Message: " + message);
    }
}

class PushNotification extends Notification {
    private String title;
    private String content;

    public PushNotification(String recipient, String title, String content) throws MissingDetailException {
        super(recipient);
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            throw new MissingDetailException("Push Notification must have title and content!");
        }
        this.title = title;
        this.content = content;
    }

    @Override
    public void send() {
        System.out.println("Sending Push Notification to " + getRecipient());
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}

public class notificationSystem {
    public static void main(String[] args) {
        try {
            Notification n1 = new EmailNotification("user@example.com", "Welcome!", "Thank you for signing up.");
            Notification n2 = new SMSNotification("9841234567", "Your OTP is 123456");
            Notification n3 = new PushNotification("User123", "Reminder", "Don't forget to check your messages!");

            n1.send();
            System.out.println("---------------------------");
            n2.send();
            System.out.println("---------------------------");
            n3.send();

        } catch (MissingDetailException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}






