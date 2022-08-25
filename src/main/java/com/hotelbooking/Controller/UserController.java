package com.hotelbooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.Entity.UserRequestEntity;
import com.hotelbooking.Entity.Users;
import com.hotelbooking.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@Operation(summary = "Get user details by userId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Operation", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@GetMapping(value = "/{userId}", produces = { "application/json" })
	public ResponseEntity<Users> getUserInfo(
			@Parameter(description = "userId to get the user information") @PathVariable Integer userId) {

		Users responseUser = userService.getUserDetails(userId);

		return new ResponseEntity<>(responseUser, HttpStatus.OK);
	}

	@Operation(summary = "Create a new User")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "User created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Users.class)) }),
			@ApiResponse(responseCode = "404", description = "User not created", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@PostMapping("/add")
	public ResponseEntity<String> createNewUser(@RequestBody UserRequestEntity user) {
		Users addedUser = userService.createUsers(user);

		// Check whether the user is created or not
		if (addedUser != null) {
			String response = "New user has been created Successfully\nYour user ID is :" + addedUser.getUserId();
			// Send created userID with 202 status code to client
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}

		// If no user is found send 404 status code as response
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Update a user by userId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "User details updated", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Users.class)) }),
			@ApiResponse(responseCode = "404", description = "User not updated", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@PatchMapping(value = "/update/{userId}", produces = { "application/json" })
	public ResponseEntity<Users> updateUser(
			@Parameter(description = "id of user to be updated") @PathVariable int userId,
			@Parameter(description = "user updated information") @RequestBody UserRequestEntity user) {

		Users updatedUser = userService.updateUsers(userId, user);

		// Check whether the user exist and is updated or not
		if (updatedUser != null) {
			// Send updated user with 202 status code to client
			return new ResponseEntity<Users>(updatedUser, HttpStatus.ACCEPTED);
		}

		// If no user is found send 404 status code as response
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Delete a User by userId")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "User deleted", content = @Content),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@DeleteMapping(value = "delete/{userId}")
	public ResponseEntity<String> deleteUser(
			@Parameter(description = "id of User to be deleted") @PathVariable int userId) {

		// Delete the User by its Id and check for the result
		if (Boolean.TRUE.equals(userService.deleteUserDetails(userId)))
			// Sent empty response with 202 status code
			return new ResponseEntity<>("User has been deleted Successfully", HttpStatus.ACCEPTED);
		else
			// If no User is found send 404 status code as response
			return new ResponseEntity<>("Cannot deleted user not found", HttpStatus.NOT_FOUND);
	}
}
