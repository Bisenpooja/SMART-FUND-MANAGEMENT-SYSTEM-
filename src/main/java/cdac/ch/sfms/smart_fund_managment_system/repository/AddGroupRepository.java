package cdac.ch.sfms.smart_fund_managment_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cdac.ch.sfms.smart_fund_managment_system.entity.AddGroup;
import cdac.ch.sfms.smart_fund_managment_system.entity.CompositeKey;


public interface AddGroupRepository extends JpaRepository<AddGroup, CompositeKey>{
	AddGroup findByUserIdAndGroupId(Long userId, Long groupId);
}
