package br.usp.poli.pcs.capstoneProject.mailer;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.usp.poli.pcs.capstoneProject.models.User;

public class Mailer {
	
	public void sendVerificationCode(User user) {

		final String username = System.getenv("email");
		final String password = System.getenv("password");

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
			message.setFrom(new InternetAddress(System.getenv("email")));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(user.getEmail()));
			message.setSubject("Verification Code");
			message.setText("Dear "+user.getName()+","
				+ "\n\nYour verification code is: "+user.getVerificationCode()+".\n\n"
				+ "Hope you have a good experience with us.\n\n"
				+ "Equipe Sistema de Agendamentos de Transferencias Bancarias - SATB");

			Transport.send(message);


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
