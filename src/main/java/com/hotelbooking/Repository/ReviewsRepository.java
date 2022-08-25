package com.hotelbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelbooking.Entity.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Integer>{

	@Query(value = "SELECT SUM(r.rating) FROM reviews r WHERE r.hotel_id= ?", nativeQuery = true)
	Integer getRatingSumFindByHotelId(Integer hotelId);

	Integer countByHotelId(Integer hotelId);

}