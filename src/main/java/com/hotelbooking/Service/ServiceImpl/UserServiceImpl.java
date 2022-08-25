package com.hotelbooking.Service.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.Users;
import com.hotelbooking.Repository.UsersRepository;
import com.hotelbooking.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UsersRepository usersRepo;

	@Override
	public Integer createUsers(Users user) {
		// TODO Auto-generated method stub
		Users savedUser = usersRepo.save(user);
		return savedUser.geUserId;
	}

	@Override
	public Users getUserDetails(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUsers(int userId, Users user) {
		Optional<Users> userEntity = usersRepo.findById(userId);
      //Check if the user exists
      if (userEntity.isPresent()) {
          Users updateUserEntity = userEntity.get();
          if(user.getUserName() !=null) {
        	  updateUserEntity.setName(user.getUserName());
          }
          if(user.getPassword() !=null) {
        	  updateUserEntity.setName(user.getPassword());
          }
          if(user.getAddress() !=null) {
        	  updateUserEntity.setName(user.getAddress());
          }
          if(user.getEmail() !=null) {
        	  updateUserEntity.setName(user.getEmail());
          }
          if(user.getPhoneNumber() !=null) {
        	  updateUserEntity.setName(user.getPhoneNumber());
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
