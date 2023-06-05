package cdac.ch.sfms.smart_fund_managment_system.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class WinnerHistoryId implements Serializable {

	private Long groupId;

	private Long installmentNumber;

	private Long winnerId;

	public WinnerHistoryId(Long groupId, Long installmentNumber, Long winnerId) {
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

	public void setInstallmentNumber(Long installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public Long getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}

	public WinnerHistoryId() {
		super();
	}
	
	
}
