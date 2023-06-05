package cdac.ch.sfms.smart_fund_managment_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cdac.ch.sfms.smart_fund_managment_system.entity.GroupMember;
import cdac.ch.sfms.smart_fund_managment_system.entity.GroupMemberId;


public interface GroupMemberRepository extends JpaRepository<GroupMember, GroupMemberId> {
	GroupMember findByUserIdAndGroupId(Long userId, Long groupId);
	
	List<GroupMember> findByUserId(Long userId);
	
	List<GroupMember> findByGroupId(Long groupId);
}
