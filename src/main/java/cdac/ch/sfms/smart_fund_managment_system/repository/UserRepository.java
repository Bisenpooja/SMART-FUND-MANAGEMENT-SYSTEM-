package cdac.ch.sfms.smart_fund_managment_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cdac.ch.sfms.smart_fund_managment_system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	public boolean existsByEmail(String email);

	public User findByEmail(String email);

}
