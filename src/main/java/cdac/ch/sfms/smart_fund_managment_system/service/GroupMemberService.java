package cdac.ch.sfms.smart_fund_managment_system.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.smart_fund_managment_system.entity.GroupMember;
import cdac.ch.sfms.smart_fund_managment_system.repository.GroupMemberRepository;


@Service
public class GroupMemberService {

	@Autowired
    private GroupMemberRepository groupMemberRepository;

    public String getGroupName(Long userId, Long groupId) {
        GroupMember groupMember = groupMemberRepository.findByUserIdAndGroupId(userId, groupId);
        return groupMember != null ? groupMember.getGroupName() : null;
    }
    
    public List<String> getGroupNamesByUserId(Long userId) {
        List<GroupMember> groupMembers = groupMemberRepository.findByUserId(userId);
        return groupMembers.stream()
                .map(GroupMember::getGroupName)
                .collect(Collectors.toList());
    }
    
	
	
}
