package cdac.ch.sfms.smart_fund_managment_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CompositeKey.class)
@Table(name = "group_members")
public class AddGroup {

	@Id
	@Column(name = "user_id")
	private Long userId;

	@Id
	@Column(name = "group_id")
	private Long groupId;
	
	@Column(name = "group_name")
	private String groupName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
