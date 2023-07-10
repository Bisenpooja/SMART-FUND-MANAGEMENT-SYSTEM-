package cdac.ch.sfms.pay.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cdac.ch.sfms.pay.services.MailService;

@ControllerAdvice
public class CardTransactionErrorHandler extends ResponseEntityExceptionHandler 
{
	@Autowired
	MailService mailService;
	
	@ExceptionHandler({CardTransactionException.class})
	public ResponseEntity<Object> handleCardException(Exception exception,WebRequest wr)
	{
		StringWriter stringWriter = new StringWriter();
		PrintWriter out = new PrintWriter(stringWriter);
		exception.printStackTrace(out);
		
		mailService.sendMail("bisenpooja5413@gmail.com", "Error occured on App CardTransaction", stringWriter.toString() );
		
		return handleExceptionInternal(exception,
				exception.getMessage(), 
				new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR, wr);
	}
	
	@ExceptionHandler({Throwable.class})
	public ResponseEntity<Object> handleMailException(Exception exception,WebRequest wr)
	{
		StringWriter stringWriter = new StringWriter();
		PrintWriter out = new PrintWriter(stringWriter);
		exception.printStackTrace(out);
		
		mailService.sendMail("bisenpooja5413@gmail.com", "Error occured on App CardTransaction", stringWriter.toString() );
		
		return handleExceptionInternal(exception,
				exception.getMessage(), 
				new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR, wr);
	}
	
}
