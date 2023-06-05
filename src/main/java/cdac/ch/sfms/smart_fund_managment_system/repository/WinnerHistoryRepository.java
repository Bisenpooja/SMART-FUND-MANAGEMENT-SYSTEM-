package cdac.ch.sfms.smart_fund_managment_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.ch.sfms.smart_fund_managment_system.entity.WinnerHistory;
import cdac.ch.sfms.smart_fund_managment_system.entity.WinnerHistoryId;



@Repository
public interface WinnerHistoryRepository extends JpaRepository<WinnerHistory, WinnerHistoryId> {
	 
}