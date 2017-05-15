package sample.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailDispatcher {
    public static void sendFromGMail(String[] emailsToSend) {

        final String username = "testpracownikemail@gmail.com";
        // testpracownikemail2@gmail.com , testpracownikemail3@gmail.com
        final String password = "test1234567";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("testpracownikemail@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");
            for (int i = 0; i < emailsToSend.length; i++) {
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(emailsToSend[i]));
                Transport.send(message);
            }
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
