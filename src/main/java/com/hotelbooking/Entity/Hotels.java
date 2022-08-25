package com.hotelbooking.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import lombok.Data;

@Entity
@Table(name = "`hotels`")
@Data
public class Hotels {
	
	@Id
	@Column(name = "hotel_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelId;

	private String hotelName;
	
	private String cityName;
	
	private String address;
	
	private String phoneNumber;
	
	private Boolean isWifiAvailable;
	
	private Boolean isAcAvailable;
	
	private Boolean isMealsAvailable;
	
	private Integer noOfRooms;
	
	@Max(10)
	private Integer overAllRatings = 0;
	
	private Date roomAvailableFromDate;
	
	private Date roomAvailableToDate;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="hotel_id",referencedColumnName = "hotel_id")
	private List<Reviews> reviews;
}
