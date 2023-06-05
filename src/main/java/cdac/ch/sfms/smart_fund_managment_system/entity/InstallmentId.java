package cdac.ch.sfms.smart_fund_managment_system.entity;

import java.io.Serializable;
import java.util.Objects;

public class InstallmentId implements Serializable{


    private Long groupId;

    
    private Long userId;

    
    private Long installmentNumber;


	public Long getGroupId() {
		return groupId;
	}


	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getInstallmentNumber() {
		return installmentNumber;
	}


	public void setInstallmentNumber(Long installmentNumber) {
		this.installmentNumber = installmentNumber;
	}


	public InstallmentId(Long groupId, Long userId, Long installmentNumber) {
		super();
		this.groupId = groupId;
		this.userId = userId;
		this.installmentNumber = installmentNumber;
	}


	public InstallmentId() {
		super();
	}


	@Override
	public int hashCode() {
		return Objects.hash(groupId, installmentNumber, userId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstallmentId other = (InstallmentId) obj;
		return Objects.equals(groupId, other.groupId) && Objects.equals(installmentNumber, other.installmentNumber)
				&& Objects.equals(userId, other.userId);
	}

	
}
