package cdac.ch.sfms.smart_fund_managment_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.smart_fund_managment_system.entity.AddGroup;
import cdac.ch.sfms.smart_fund_managment_system.repository.AddGroupRepository;


@Service
public class AddGroupService {
	
	@Autowired
    private AddGroupRepository addgroupRepository;

    public void addGroup(Long userId, Long groupId, String groupName) {
        AddGroup group = new AddGroup();
        group.setUserId(userId);
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        addgroupRepository.save(group);
    }

    public String findGroupNameByUserIdAndGroupId(Long userId, Long groupId) {
        AddGroup group = addgroupRepository.findByUserIdAndGroupId(userId, groupId);
        return group.getGroupName();
    }

}
