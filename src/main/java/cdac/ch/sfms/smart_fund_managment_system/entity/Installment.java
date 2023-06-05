package cdac.ch.sfms.smart_fund_managment_system.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(InstallmentId.class)
@Table(name = "installment")
public class Installment {

	
    @Id
    @Column(name = "group_id")
    private Long groupId;
    
    @Id
    @Column(name = "user_id")
    private Long userId;
 
    @Id
    @Column(name = "installment_number")
    private Long installmentNumber;
    
    @Column(name = "status")
    private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Installment(Long groupId, Long userId, Long installmentNumber, String status) {
		super();
		this.groupId = groupId;
		this.userId = userId;
		this.installmentNumber = installmentNumber;
		this.status = status;
	}

	public Installment() {
		super();
	}

	
    
    
    
}