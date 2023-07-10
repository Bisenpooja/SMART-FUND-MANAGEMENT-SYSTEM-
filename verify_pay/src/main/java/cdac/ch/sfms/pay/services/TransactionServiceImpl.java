package cdac.ch.sfms.pay.services;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.pay.dao.CardTransactionDAO;
import cdac.ch.sfms.pay.dto.CardTransactionDTO;
import cdac.ch.sfms.pay.dto.TransactionCompletedDTO;
import cdac.ch.sfms.pay.entity.CardTransaction;
import cdac.ch.sfms.pay.exceptions.CardTransactionException;

@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	CardTransactionDAO daoTransaction;
	
	@Autowired
	MailService mailService;
		
	@Transactional
	@Override
	public TransactionCompletedDTO transact(CardTransactionDTO cardDTO) 
	{
		int cardNo = cardDTO.getCardNo();
		String expiry = cardDTO.getExpiry();
		float amount = cardDTO.getAmount();
		TransactionCompletedDTO dtoTransaction=null;
		
		if(cardDTO.getAmount()>5000)
			throw new CardTransactionException("You have exceeded your daily limit");
		
		boolean status = daoTransaction.deductCardBalance(cardNo, expiry, amount);
		if(status)
		{
			CardTransaction transaction = daoTransaction.transactCard(cardNo, amount);
			dtoTransaction = new TransactionCompletedDTO();
			BeanUtils.copyProperties(transaction, dtoTransaction);
			
			String message = "<html><body><b>This is a Transaction alert on card No " + cardNo;
			message+="</b><br/>Your card has been swiped for Rs. " + amount ;
			message+="<br/> on " + dtoTransaction.getTxDate();
			message+="<br/><br/><b>Transaction ID : " + dtoTransaction.getTxId();
			message+="</b><br>If not done by you contact Bank.</body></html>";
			
			mailService.sendMail("bisenpooja5413@gmail.com", "Transcation Alert", message);
			
			return dtoTransaction;
		}
		return null;
	}

	@Override
	public TransactionCompletedDTO getTransactionDetails(int txId) {
		
		CardTransaction transaction = daoTransaction.getTransactionDetails(txId);
		TransactionCompletedDTO dtoTransaction = new TransactionCompletedDTO();
		BeanUtils.copyProperties(transaction, dtoTransaction);
		
		return dtoTransaction;
	}

}
