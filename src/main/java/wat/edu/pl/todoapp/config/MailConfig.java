package wat.edu.pl.todoapp.config;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailConfig {

    public static void send(String recipient,String text) {
        String to = recipient;//"todoapp.ai@gmail.com";
        String subject = "Przypomnienie o zadaniu! - Przekierowano ze strony internetowej TodoApp";
        String msg = text;
        final String from ="todoapp.ai@gmail.com";
        final String password ="12wq!@WQ";


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        //session.setDebug(true);
        Transport transport = null;
        try {
            transport = session.getTransport();
            InternetAddress addressFrom = new InternetAddress(from);

            MimeMessage message = new MimeMessage(session);
            message.setSender(addressFrom);
            message.setSubject(subject);
            message.setContent(msg, "text/plain; charset=UTF-8");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            transport.connect();
            Transport.send(message);
            transport.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}