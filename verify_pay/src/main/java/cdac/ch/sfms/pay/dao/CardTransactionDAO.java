package cdac.ch.sfms.pay.dao;

import cdac.ch.sfms.pay.entity.CardTransaction;

public interface CardTransactionDAO 
{
	public boolean deductCardBalance(int cardNo, String expiry, float amount);
	public CardTransaction transactCard(int cardNo, float amount);
	public CardTransaction getTransactionDetails(int txId);
}
