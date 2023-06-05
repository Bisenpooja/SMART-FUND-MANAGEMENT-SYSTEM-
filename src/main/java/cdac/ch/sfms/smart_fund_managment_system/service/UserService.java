package cdac.ch.sfms.smart_fund_managment_system.service;

import cdac.ch.sfms.smart_fund_managment_system.entity.User;

public interface UserService {

	public User createUser(User user);

	public boolean checkEmail(String email);
	

}
