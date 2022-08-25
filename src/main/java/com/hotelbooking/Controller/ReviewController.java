package com.hotelbooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.Entity.ReviewRequestEntity;
import com.hotelbooking.Entity.Reviews;
import com.hotelbooking.Service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Operation(summary = "Create a new review for Hotel")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "User created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Reviews.class)) }),
			@ApiResponse(responseCode = "404", description = "User not created", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@PostMapping("/add")
	public ResponseEntity<Reviews> createNewUser(@RequestBody ReviewRequestEntity review) {
		Reviews addedReview = reviewService.createReview(review);

		// Check whether the user is created or not
		if (addedReview != null) {
			// Send created reviewID with 202 status code to client
			return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
		}

		// If no user is found send 404 status code as response
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Update a review by reviewId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "review details updated", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Reviews.class)) }),
			@ApiResponse(responseCode = "404", description = "review not updated", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@PatchMapping(value = "/update/{reviewId}", produces = { "application/json" })
	public ResponseEntity<Reviews> updatereview(
			@Parameter(description = "id of review to be updated") @PathVariable int reviewId,
			@Parameter(description = "review updated information") @RequestBody ReviewRequestEntity review) {

		Reviews updatedreview = reviewService.updateReviews(reviewId, review);

		// Check whether the review exist and is updated or not
		if (updatedreview != null) {
			// Send updated review with 202 status code to client
			return new ResponseEntity<Reviews>(updatedreview, HttpStatus.ACCEPTED);
		}

		// If no review is found send 404 status code as response
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Delete a review by reviewId")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "review deleted", content = @Content),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "review not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@DeleteMapping(value = "delete/{reviewId}")
	public ResponseEntity<String> deletereview(
			@Parameter(description = "id of review to be deleted") @PathVariable int reviewId) {

		// Delete the review by its Id and check for the result
		if (Boolean.TRUE.equals(reviewService.deleteRreview(reviewId)))
			// Sent empty response with 202 status code
			return new ResponseEntity<>("review has been deleted Successfully", HttpStatus.ACCEPTED);
		else
			// If no review is found send 404 status code as response
			return new ResponseEntity<>("Cannot deleted review not found", HttpStatus.NOT_FOUND);
	}
}
