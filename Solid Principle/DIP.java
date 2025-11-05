// The Dependency Inversion Principle (DIP) states:

// High-level modules should not depend on low-level modules. Both should depend on abstractions.
// class EmailService {
//     public void sendEmail(String message) {
//         System.out.println("Email sent: " + message);
//     }
// }

// class Notification {
//     private EmailService emailService;

//     public Notification() {
//         emailService = new EmailService();
//     }

//     public void send(String message) {
//         emailService.sendEmail(message);
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Notification notification = new Notification();
//         notification.send("Hello Suraj!");
//     }
// }


interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}

class WhatsappService implements MessageService{
    public void sendMessage(String message) {
        System.out.println("Whatsapp message sent: " + message);
    }
}

class Notification {
    private MessageService messageService;

   
    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String message) {
        messageService.sendMessage(message);
    }

}

public class DIP {
    public static void main(String[] args) {
        MessageService emailService = new EmailService();
        MessageService whatsappService = new WhatsappService();
        Notification notification = new Notification(emailService);
        notification.send("Hello Suraj!");
        notification = new Notification(whatsappService);
        notification.send("Hello Suraj!");
    }
    
}
