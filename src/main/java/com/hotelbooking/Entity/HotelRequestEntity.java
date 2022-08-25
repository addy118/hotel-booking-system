package com.hotelbooking.Entity;

import java.util.Date;

import lombok.Data;

@Data
public class HotelRequestEntity {

	private String hotelName;

	private String cityName;

	private String address;

	private String phoneNumber;

	private Boolean isWifiAvailable;

	private Boolean isAcAvailable;

	private Boolean isMealsAvailable;

	private Integer noOfRooms;

	private Date roomAvailableFromDate;

	private Date roomAvailableToDate;
}
