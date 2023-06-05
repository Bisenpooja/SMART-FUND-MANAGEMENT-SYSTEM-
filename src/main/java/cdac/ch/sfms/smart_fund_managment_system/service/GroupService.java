package cdac.ch.sfms.smart_fund_managment_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.smart_fund_managment_system.entity.Group;
import cdac.ch.sfms.smart_fund_managment_system.repository.GroupRepository;



@Service
public class GroupService {
    
    @Autowired
    private GroupRepository groupRepository;
    
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
    
    public void saveGroup(Group group) {
        groupRepository.save(group);
    }
}