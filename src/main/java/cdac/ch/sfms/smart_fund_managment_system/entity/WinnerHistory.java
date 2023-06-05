package cdac.ch.sfms.smart_fund_managment_system.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(WinnerHistoryId.class)
@Table(name = "winners_history")
public class WinnerHistory {

	  @Id
	  @Column(name = "group_id")
	  private Long groupId;

	  @Id
	  @Column(name = "installment_number")
	  private Long installmentNumber;

	  
	  @Column(name = "winner_id")
	  private Long winnerId;

	  
	public WinnerHistory(Long groupId, Long installmentNumber, Long winnerId) {
		super();
		this.groupId = groupId;
		this.installmentNumber = installmentNumber;
		this.winnerId = winnerId;
	}


	public Long getGroupId() {
		return groupId;
	}


	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}


	public Long getInstallmentNumber() {
		return installmentNumber;
	}


	public void setInstallmentNumber(long installmentNumber) {
		this.installmentNumber = installmentNumber;
	}


	public Long getWinnerId() {
		return winnerId;
	}


	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}


	public WinnerHistory() {
		super();
	}

    
}
