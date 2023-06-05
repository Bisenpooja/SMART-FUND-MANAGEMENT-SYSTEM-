package cdac.ch.sfms.smart_fund_managment_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cdac.ch.sfms.smart_fund_managment_system.entity.Transaction;



public interface TransactionRepository  extends JpaRepository<Transaction, Long> {

}
