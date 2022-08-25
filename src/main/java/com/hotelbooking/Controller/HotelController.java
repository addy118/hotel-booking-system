package com.hotelbooking.Controller;

import java.util.List;

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

import com.hotelbooking.Entity.HotelRequestEntity;
import com.hotelbooking.Entity.Hotels;
import com.hotelbooking.Service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;

	@Operation(summary = "Get list of hotels (Ordered by rating in ascending order)")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Operation", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<Hotels>> getAllHotels() {

		List<Hotels> allHotels = hotelService.getAllHotelDetails();

		return new ResponseEntity<>(allHotels, HttpStatus.OK);
	}

	@Operation(summary = "Get list of hotels (Ordered by rating in ascending order)")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Operation", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@GetMapping(value = "/{cityName}", produces = { "application/json" })
	public ResponseEntity<List<Hotels>> getAllHotelsByCityName(
			@Parameter(description = "city name to filter the list of hotels") @PathVariable String cityName) {

		List<Hotels> allHotels = hotelService.getAllHotelByCityName(cityName);

		return new ResponseEntity<>(allHotels, HttpStatus.OK);
	}

	@Operation(summary = "Create a new Hotel")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Hotel created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Hotels.class)) }),
			@ApiResponse(responseCode = "404", description = "Hotel not created", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@PostMapping("/add")
	public ResponseEntity<String> createNewHotel(@RequestBody HotelRequestEntity hotel) {
		Hotels addedHotel = hotelService.createHotels(hotel);

		// Check whether the Hotel is created or not
		if (addedHotel != null) {
			String response = "New Hotel has been created Successfully\nYour Hotel ID is :" + addedHotel.getHotelId();
			// Send created hotelID with 202 status code to client
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}

		// If no Hotel is found send 404 status code as response
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Update a hotel by it's id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Hotel details updated", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Hotels.class)) }),
			@ApiResponse(responseCode = "404", description = "Hotel not updated", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@PatchMapping(value = "/update/{hotelId}", produces = { "application/json" })
	public ResponseEntity<Hotels> updateHotel(
			@Parameter(description = "id of hotel to be updated") @PathVariable int hotelId,
			@Parameter(description = "hotel updated information") @RequestBody HotelRequestEntity hotel) {

		Hotels updatedHotel = hotelService.updateHotels(hotelId, hotel);

		// Check whether the hotel exist and is updated or not
		if (updatedHotel != null) {
			// Send updated hotel with 202 status code to client
			return new ResponseEntity<Hotels>(updatedHotel, HttpStatus.ACCEPTED);
		}

		// If no hotel is found send 404 status code as response
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Delete a Hotel by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Hotel deleted", content = @Content),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Hotel not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@DeleteMapping(value = "delete/{hotelId}")
	public ResponseEntity<String> deleteHotel(
			@Parameter(description = "id of Hotel to be deleted") @PathVariable int hotelId) {

		// Delete the Hotel by its Id and check for the result
		if (Boolean.TRUE.equals(hotelService.deleteHotelDetails(hotelId)))
			// Sent empty response with 202 status code
			return new ResponseEntity<>("Hotel has been deleted Successfully", HttpStatus.ACCEPTED);
		else
			// If no Hotel is found send 404 status code as response
			return new ResponseEntity<>("Cannot deleted hotel not found", HttpStatus.NOT_FOUND);
	}
}
