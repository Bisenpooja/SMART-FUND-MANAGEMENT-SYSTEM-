package cdac.ch.sfms.smart_fund_managment_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.ch.sfms.smart_fund_managment_system.entity.Installment;
import cdac.ch.sfms.smart_fund_managment_system.entity.InstallmentId;


@Repository
public interface InstallmentRepository extends JpaRepository<Installment, InstallmentId>{

	Installment findByGroupIdAndUserIdAndInstallmentNumber(Long groupId, Long userId, Long installmentNumber);
	
	List<Installment> findByGroupIdAndInstallmentNumber(Long groupId, Long installmentNumber);

	List<Installment> findByGroupIdAndInstallmentNumberAndStatus(Long groupId, Long installmentNumber, String status);

}
