package cdac.ch.sfms.pay.dto;

import java.util.Date;

public class TransactionCompletedDTO 
{
	public int txId;
	
	public int cardNo;
	
	public Date txDate;
	
	public float amount;
	
	public boolean status;

	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getResultMessage() {
        return this.status ? "Success" : "Failed";
    }
	
	
}
