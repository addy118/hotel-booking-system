package com.hotelbooking.Service;

import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.UserRequestEntity;
import com.hotelbooking.Entity.Users;

@Service
public interface UserService {

	public Users createUsers(UserRequestEntity user);

	public Users getUserDetails(int userId);

	public Users updateUsers(int userId, UserRequestEntity user);

	public Boolean deleteUserDetails(int userId);
}
