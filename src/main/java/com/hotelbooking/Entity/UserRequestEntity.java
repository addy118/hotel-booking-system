package com.hotelbooking.Entity;

import lombok.Data;

@Data
public class UserRequestEntity {
	
	private String userName;

	private String password;

	private String email;
	
	private String address;
	
	private String phoneNumber;

}
