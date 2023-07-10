package cdac.ch.sfms.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.ch.sfms.pay.entity.CardTransaction;

@Repository
public interface CardTransactionRepository extends JpaRepository<CardTransaction, Integer> {

}
