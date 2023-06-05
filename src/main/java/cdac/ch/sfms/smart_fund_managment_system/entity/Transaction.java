package cdac.ch.sfms.smart_fund_managment_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "cards")
public class Transaction {

	@Id
    @Column(name = "cardno")
	private int card;
	
	
    @Column(name = "expiry")
    private String expiry;
    
	
    @Column(name = "balance")
    private float balance;

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Transaction(int card, String expiry, float balance) {
		super();
		this.card = card;
		this.expiry = expiry;
		this.balance = balance;
	}

	public Transaction() {
		super();
	}
    
    

}
