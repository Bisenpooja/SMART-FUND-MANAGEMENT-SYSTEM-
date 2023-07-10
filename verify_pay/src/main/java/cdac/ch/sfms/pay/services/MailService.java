package cdac.ch.sfms.pay.services;

public interface MailService 
{
	public void sendMail(String to, String subject, String message);
}
