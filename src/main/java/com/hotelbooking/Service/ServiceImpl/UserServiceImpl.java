package com.hotelbooking.Service.ServiceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.UserRequestEntity;
import com.hotelbooking.Entity.Users;
import com.hotelbooking.Repository.UsersRepository;
import com.hotelbooking.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepository usersRepo;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Users createUsers(UserRequestEntity user) {
		Users userDto = modelMapper.map(user, Users.class);
		return usersRepo.save(userDto);
	}

	@Override
	public Users getUserDetails(int userId) {
		Users userEntity = usersRepo.findById(userId).get();
		return userEntity;
	}

	@Override
	public Users updateUsers(int userId, UserRequestEntity user) {
		Optional<Users> userEntity = usersRepo.findById(userId);
		// Check if the user exists
		if (userEntity.isPresent()) {
			Users updateUserEntity = userEntity.get();
			if (user.getUserName().isEmpty()) {
				updateUserEntity.setUserName(user.getUserName());
			}
			if (user.getPassword().isEmpty()) {
				updateUserEntity.setPassword(user.getPassword());
			}
			if (user.getAddress().isEmpty()) {
				updateUserEntity.setAddress(user.getAddress());
			}
			if (user.getEmail().isEmpty()) {
				updateUserEntity.setEmail(user.getEmail());
			}
			if (user.getPhoneNumber().isEmpty()) {
				updateUserEntity.setPhoneNumber(user.getPhoneNumber());
			}
			// Save and return updated user object
			return usersRepo.save(updateUserEntity);
		}

		// returns null if the given Id doesn't exist
		return null;
	}

	@Override
	public Boolean deleteUserDetails(int userId) {
		Optional<Users> deleteUser = usersRepo.findById(userId);
		if (deleteUser.isPresent()) {
			usersRepo.delete(deleteUser.get());
			return true;
		}
		return false;
	}

}
