package com.hotelbooking.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.HotelRequestEntity;
import com.hotelbooking.Entity.Hotels;
import com.hotelbooking.Repository.HotelsRepository;
import com.hotelbooking.Service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelsRepository hotelRepo;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Boolean deleteHotelDetails(int hotelId) {
		Optional<Hotels> hotelEntity = hotelRepo.findById(hotelId);
		if (hotelEntity.isPresent()) {
			hotelRepo.delete(hotelEntity.get());
			return true;
		}
		return false;
	}

	@Override
	public Hotels updateHotels(int hotelId, HotelRequestEntity hotel) {
		Optional<Hotels> hotelEntity = hotelRepo.findById(hotelId);
		// Check if the user exists
		if (hotelEntity.isPresent()) {
			Hotels updateHotelEntity = hotelEntity.get();
			if (!hotel.getHotelName().isEmpty()) {
				updateHotelEntity.setHotelName(hotel.getHotelName());
			}
			if (!hotel.getCityName().isEmpty()) {
				updateHotelEntity.setCityName(hotel.getCityName());
			}
			if (!hotel.getAddress().isEmpty()) {
				updateHotelEntity.setAddress(hotel.getAddress());
			}
			if (hotel.getPhoneNumber().isEmpty()) {
				updateHotelEntity.setPhoneNumber(hotel.getPhoneNumber());
			}
			if (hotel.getNoOfRooms() == 0) {
				updateHotelEntity.setNoOfRooms(hotel.getNoOfRooms());
			}
			updateHotelEntity.setRoomAvailableFromDate(hotel.getRoomAvailableFromDate());
			updateHotelEntity.setRoomAvailableToDate(hotel.getRoomAvailableToDate());

			// Save and return updated user object
			return hotelRepo.save(updateHotelEntity);
		}

		// returns null if the given Id doesn't exist
		return null;
	}

	@Override
	public Hotels createHotels(HotelRequestEntity hotel) {
		Hotels hotelDto = modelMapper.map(hotel, Hotels.class);
		return hotelRepo.save(hotelDto);
	}

	@Override
	public List<Hotels> getAllHotelDetails() {
		return hotelRepo.findAllByOrderByOverAllRatingsDesc();
	}

	@Override
	public List<Hotels> getAllHotelByCityName(String cityName) {
		return hotelRepo.findAllByCityNameIgnoreCaseOrderByOverAllRatingsDesc(cityName);
	}

}
