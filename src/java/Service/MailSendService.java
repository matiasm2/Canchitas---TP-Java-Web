/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;



import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSendService {

    private static String USER_NAME = "eb1f12ab0d3d34";
    private static String PASSWORD = "96449738c79ae6";
    private static String MAILTRAPHOST = "smtp.mailtrap.io";

    public static void sendMailTo(String recipient, String subject, String body) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { recipient };

        sendFromMailTrap(from, pass, to, subject, body);
    }

    private static void sendFromMailTrap(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = MAILTRAPHOST;
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}