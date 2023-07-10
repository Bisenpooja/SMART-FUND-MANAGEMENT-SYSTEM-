package cdac.ch.sfms.pay.services;

import cdac.ch.sfms.pay.dto.CardTransactionDTO;
import cdac.ch.sfms.pay.dto.TransactionCompletedDTO;

public interface TransactionService 
{
	public TransactionCompletedDTO transact(CardTransactionDTO cardDTO);
	public TransactionCompletedDTO getTransactionDetails(int txId);
}
