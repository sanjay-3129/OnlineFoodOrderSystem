package com.foodorder.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSystem {

	public static void sendMail(String recipientEmail, String subject, String msg) {
		// email ID of Recipient.
		String recipient = recipientEmail;

		// email ID of Sender.
		String senderEmail = "dummymail00197@gmail.com";
		String senderPassword = "Dummymail00197!@#";

		// Getting system properties
		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.fallback", "false");

		// Setting up mail server
		// properties.setProperty("mail.smtp.host", host);

		// creating session object to get properties
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// Specify the Username and the PassWord
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});
		session.setDebug(true);

		try {
			// MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From Field: adding senders email to from field.
			message.setFrom(new InternetAddress(senderEmail));

			// Set To Field: adding recipient's email to from field.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// Set Subject: subject of the email
			message.setSubject(subject);

			// set body of the email.
			message.setText(msg);

			// Send email.
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", senderEmail, senderPassword);
			Transport.send(message, message.getAllRecipients());
			System.out.println("Mail successfully sent");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
