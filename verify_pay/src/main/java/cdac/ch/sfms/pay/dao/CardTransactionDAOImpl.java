package cdac.ch.sfms.pay.dao;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cdac.ch.sfms.pay.entity.CardTransaction;
import cdac.ch.sfms.pay.entity.Cards;
import cdac.ch.sfms.pay.repository.CardTransactionRepository;
import cdac.ch.sfms.pay.repository.CardsRepository;

@Component
public class CardTransactionDAOImpl implements CardTransactionDAO 
{
	@Autowired
	CardsRepository cardRepository;
	
	@Autowired
	CardTransactionRepository transactionRepository;
	
	@Override
	public boolean deductCardBalance(int cardNo, String expiry, float amount) 
	{
		Optional<Cards> optCards = cardRepository.findById(cardNo);
		if(optCards.isPresent())
		{
			Cards objCards = optCards.get();
			float balance = objCards.getBalance() ;
			if(objCards.getExpiry().equals(expiry) && balance > amount)
			{
				objCards.setBalance(balance - amount);
				cardRepository.save(objCards);
				return true;
			}			
		}	
		return false;
	}

	@Override
	public CardTransaction transactCard(int cardNo, float amount) {
		
		CardTransaction objTransaction = new CardTransaction(cardNo,amount,new Date());
		objTransaction.setStatus(true);
		CardTransaction completedTransaction = transactionRepository.save(objTransaction);		
		
		return completedTransaction;
	}

	@Override
	public CardTransaction getTransactionDetails(int txId)
	{
		return transactionRepository.findById(txId).get();		
	}

}
