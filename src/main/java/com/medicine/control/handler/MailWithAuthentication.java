package com.medicine.control.handler;


//import java.util.ArrayList;
//import java.util.List;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Date;
import java.util.Properties;

import com.medicine.control.handler.SMTPAuthenticator;
 
public class MailWithAuthentication {
 
	public static void alert() throws Exception{
		String subject = "Elevação de temperatura [URGENTE]";
		String body = "Foi detectada a elevação de temperatura do freezer, recomendado verificar!";
		sendEmail(subject, body);
	}
	
	public static void announcement() throws Exception{
		String subject = "Temperatura estabilizada";
		String body = "A temperatura do freezer voltou ao normal!";
		sendEmail(subject, body);
	}
	
    public static void sendEmail(String subject, String body) throws Exception{
        Properties props = new Properties();
        props.put("mail.smtp.user", SMTPAuthenticator.SMTP_AUTH_USER);
        props.put("mail.smtp.host", SMTPAuthenticator.SMTP_HOST_NAME);
        props.put("mail.smtp.port", SMTPAuthenticator.SMTP_HOST_PORT);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", SMTPAuthenticator.SMTP_HOST_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SMTPAuthenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(SMTPAuthenticator.SMTP_AUTH_USER));
        //InternetAddress[] toAddresses = { new InternetAddress(SMTPAuthenticator.SMTP_AUTH_USER) };
        //msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(SMTPAuthenticator.SEND_TO));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(body, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
        
        try{
            Transport transport = session.getTransport("smtps");
                transport.connect(SMTPAuthenticator.SMTP_HOST_NAME, Integer.valueOf(SMTPAuthenticator.SMTP_HOST_PORT), SMTPAuthenticator.SMTP_AUTH_USER, SMTPAuthenticator.SMTP_AUTH_PWD);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();

            } catch (AddressException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
    }
 
    
}

