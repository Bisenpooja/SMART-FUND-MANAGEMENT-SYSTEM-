package cdac.ch.sfms.smart_fund_managment_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cdac.ch.sfms.smart_fund_managment_system.entity.User;
import cdac.ch.sfms.smart_fund_managment_system.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");

		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}
	
	

	
	
	

}
