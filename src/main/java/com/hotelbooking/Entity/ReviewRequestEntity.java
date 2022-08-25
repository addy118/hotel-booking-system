package com.hotelbooking.Entity;

import javax.validation.constraints.Max;

import lombok.Data;

@Data
public class ReviewRequestEntity {

	private String hotelName;
	
	private String reviewerName;
	
	@Max(10)
	private Integer rating;
	
	private String comment;
}
