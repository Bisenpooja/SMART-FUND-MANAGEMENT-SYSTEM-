package cdac.ch.sfms.pay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class CardTransaction 
{
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name="txid")
	int txId;
	
	@Column(name="cardno")
	int cardNo;
	
	@Column(name="amount")
	float amount;
	
	@Column(name="txdate")
	Date txDate;
	
	@Column(name="status")
	boolean status;

	public CardTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CardTransaction(int cardNo, float amount, Date txDate) {
		this.cardNo = cardNo;
		this.amount = amount;
		this.txDate = txDate;
	}


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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
}
