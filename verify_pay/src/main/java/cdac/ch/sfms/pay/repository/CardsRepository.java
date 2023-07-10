package cdac.ch.sfms.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.ch.sfms.pay.entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Integer> {

}
