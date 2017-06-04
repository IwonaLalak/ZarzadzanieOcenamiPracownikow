package sample.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

//public class EmailDispatcher {
//    public static void sendFromGMail(String emailLogin, String emailPassword, String[] emailsToSend) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Properties props = new Properties();
//                props.put("mail.smtp.auth", "true");
//                props.put("mail.smtp.starttls.enable", "true");
//                props.put("mail.smtp.host", "smtp.gmail.com");
//                props.put("mail.smtp.port", "587");
//
//                Session session = Session.getInstance(props,
//                        new javax.mail.Authenticator() {
//                            protected PasswordAuthentication getPasswordAuthentication() {
//                                return new PasswordAuthentication(emailLogin, emailPassword);
//                            }
//                        });
//                try {
//                    Message message = new MimeMessage(session);
//                    message.setFrom(new InternetAddress(emailLogin));
//                    message.setSubject("Przypomnienie o niewypełnionych ankietach.");
//                    message.setText("Dzień dobry, proszę o wypełnienie zaległych ankiet."
//                            + "\n\n Pozdrawiam, szef.");
//                    for (int i = 0; i < emailsToSend.length; i++) {
//                        message.setRecipients(Message.RecipientType.TO,
//                                InternetAddress.parse(emailsToSend[i]));
//                        Transport.send(message);
//                    }
//                } catch (MessagingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//    }
//}
