package com.hotelbooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import lombok.Data;

@Entity
@Table(name = "`reviews`")
@Data
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;
	
	@Column(name = "hotel_id")
	private Integer hotelId;
	
	private String reviewerName;
	
	@Max(10)
	private Integer rating;
	
	private String comment;
}
