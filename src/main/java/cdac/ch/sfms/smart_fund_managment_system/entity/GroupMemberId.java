package cdac.ch.sfms.smart_fund_managment_system.entity;

import java.io.Serializable;

public class GroupMemberId implements Serializable {
	private Long userId;

    private Long groupId;

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

	public GroupMemberId(Long userId, Long groupId) {
		super();
		this.userId = userId;
		this.groupId = groupId;
	}

	public GroupMemberId() {
		super();
	}

}
