package Beans;

import java.util.Date;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named ("MailBean")
@RequestScoped
public class MailBean {


	private String email;
	private String subject;
	private String message;
	static final String username = "bloodonapp@gmail.com";
	static final String password = "bloodon 2020";

	public String sendmail() {
		System.out.println(this.email);
		System.out.println(this.subject);
		System.out.println(this.message);

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
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
			message.setFrom(new InternetAddress("bloodonapp@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("bloodonapp@gmail.com"));
			message.setSubject(this.subject);
			message.setText("This e-mail was sent from : "+this.email+"\n\n"
					+ this.message);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		this.email = "";
		this.subject = "";
		this.message = "";
		return "/Contact.xhtml";
	}





	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getsubject() {
		return subject;
	}

	public void setsubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}