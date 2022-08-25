package com.hotelbooking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.HotelRequestEntity;
import com.hotelbooking.Entity.Hotels;

@Service
public interface HotelService {

	public Boolean deleteHotelDetails(int hotelId);

	public Hotels updateHotels(int hotelId, HotelRequestEntity hotel);

	public Hotels createHotels(HotelRequestEntity hotel);

	public List<Hotels> getAllHotelDetails();

	public List<Hotels> getAllHotelByCityName(String cityName);

}
