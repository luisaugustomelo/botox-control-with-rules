package com.medicine.control.handler;

import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends javax.mail.Authenticator {

    public static final String SMTP_HOST_NAME = "smtp.gmail.com";
    public static final String SMTP_HOST_PORT = "465";
    public static final String SMTP_AUTH_USER = "envio.jbpm@gmail.com";
    public static final String SMTP_AUTH_PWD  = "mestradoufes2016";
    public static final String SEND_TO = "envio.jbpm@gmail.com";
       public PasswordAuthentication getPasswordAuthentication() {
          String username = SMTP_AUTH_USER;
          String password = SMTP_AUTH_PWD;
          return new PasswordAuthentication(username, password);
       }
}
