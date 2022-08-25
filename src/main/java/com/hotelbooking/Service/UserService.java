package com.hotelbooking.Service;

import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.Users;

@Service
public interface UserService{

	public Integer createUsers(Users user);
	
	public Users getUserDetails(int userId);
	
	public Users updateUsers(int userId, Users user);
	
	public Boolean deleteUserDetails(int userId);
}
