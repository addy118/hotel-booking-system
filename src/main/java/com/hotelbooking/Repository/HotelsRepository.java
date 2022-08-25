package com.hotelbooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbooking.Entity.Hotels;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels, Integer>{

	List<Hotels> findAllByCityNameIgnoreCaseOrderByOverAllRatingsDesc(String cityName);

	Hotels findByHotelName(String hotelName);

	List<Hotels> findAllOrderByOverAllRatingsDesc();

}