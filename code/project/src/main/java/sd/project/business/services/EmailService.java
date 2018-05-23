package sd.project.business.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);
    void sendMessageWithAttachement(String to,
                                    String subject,
                                    String text,
                                    String pathToAttachment);
}

