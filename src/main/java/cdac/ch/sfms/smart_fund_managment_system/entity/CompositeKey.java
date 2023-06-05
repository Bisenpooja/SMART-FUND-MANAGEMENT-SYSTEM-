package cdac.ch.sfms.smart_fund_managment_system.entity;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKey implements Serializable {
	private Long userId;
	private Long groupId;

	public CompositeKey() {
		super();
	}

	public CompositeKey(Long userId, Long groupId) {
		super();
		this.userId = userId;
		this.groupId = groupId;

	}

	@Override
	public int hashCode() {
		return Objects.hash(groupId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		return Objects.equals(groupId, other.groupId) && Objects.equals(userId, other.userId);
	}

}
