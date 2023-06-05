package cdac.ch.sfms.smart_fund_managment_system.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups_details")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_limit")
	private int groupLimit;

	@Column(name = "expiry")
	private String expiry;

	@Column(name = "status")
	private String status;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	

	public Group() {
		super();
	}

	public Group(Long groupId, String groupName, int groupLimit, String expiry, String status) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupLimit = groupLimit;
		this.expiry = expiry;
		this.status = status;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupLimit() {
		return groupLimit;
	}

	public void setGroupLimit(int groupLimit) {
		this.groupLimit = groupLimit;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	

}
