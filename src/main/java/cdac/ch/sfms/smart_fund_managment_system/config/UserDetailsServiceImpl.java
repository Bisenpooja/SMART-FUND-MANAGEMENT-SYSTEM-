package cdac.ch.sfms.smart_fund_managment_system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.smart_fund_managment_system.entity.User;
import cdac.ch.sfms.smart_fund_managment_system.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepo.findByEmail(email);

		if (user != null) {
			return new CustomUserdetails(user);
		}

		throw new UsernameNotFoundException("user not available");
	}

	

}
