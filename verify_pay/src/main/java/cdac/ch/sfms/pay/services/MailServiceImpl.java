package cdac.ch.sfms.pay.services;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService 
{
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(String to, String subject, String message) 
	{
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			
			mimeMessage.addFrom(new InternetAddress[] {new InternetAddress("cdac.patna@frankelsinfotech.com")});
			mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setContent(message, "text/html");
			
			mailSender.send(mimeMessage);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
