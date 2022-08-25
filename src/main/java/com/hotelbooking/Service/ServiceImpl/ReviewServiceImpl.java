package com.hotelbooking.Service.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.Hotels;
import com.hotelbooking.Entity.ReviewRequestEntity;
import com.hotelbooking.Entity.Reviews;
import com.hotelbooking.Repository.HotelsRepository;
import com.hotelbooking.Repository.ReviewsRepository;
import com.hotelbooking.Service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewsRepository reviewsRepo;

	@Autowired
	HotelsRepository hotelRepo;

	@Override
	public boolean deleteRreview(int reviewId) {
		Optional<Reviews> deleteUser = reviewsRepo.findById(reviewId);
		if (deleteUser.isPresent()) {
			reviewsRepo.delete(deleteUser.get());
			return true;
		}
		return false;
	}

	@Override
	public Reviews updateReviews(int reviewId, ReviewRequestEntity review) {
		Optional<Reviews> reviewEntity = reviewsRepo.findById(reviewId);
		Hotels hotelEntity = hotelRepo.findByHotelName(review.getHotelName());
		// Check if the user exists
		if (reviewEntity.isPresent()) {
			Reviews updateReviewEntity = reviewEntity.get();
			if (review.getReviewerName().isEmpty()) {
				updateReviewEntity.setReviewerName(review.getReviewerName());
			}
			if (review.getHotelName().isEmpty()) {
				updateReviewEntity.setHotelId(hotelEntity.getHotelId());
			}
			if (review.getComment().isEmpty()) {
				updateReviewEntity.setComment(review.getComment());
			}

			if (review.getRating() != updateReviewEntity.getRating()) {
				updateReviewEntity.setRating(review.getRating());
			}

			Reviews savedReviewEntity = reviewsRepo.save(updateReviewEntity);

			Integer sumOfRatings = reviewsRepo.getRatingSumFindByHotelId(hotelEntity.getHotelId());
			Integer ratedCount = reviewsRepo.countByHotelId(hotelEntity.getHotelId());

			Integer overAllRatings = (sumOfRatings * 10) / (ratedCount * 10);

			hotelEntity.setOverAllRatings(overAllRatings);
			hotelRepo.save(hotelEntity);
			// Save and return updated review object
			return savedReviewEntity;
		}

		// returns null if the given Id doesn't exist
		return null;
	}

	@Override
	public Reviews createReview(ReviewRequestEntity review) {
		Hotels hotelEntity = hotelRepo.findByHotelName(review.getHotelName());

		if (hotelEntity != null) {
			Reviews reviewEntity = new Reviews();
			reviewEntity.setHotelId(hotelEntity.getHotelId());
			reviewEntity.setReviewerName(review.getReviewerName());
			reviewEntity.setRating(review.getRating());
			reviewEntity.setComment(review.getComment());

			Reviews savedReviewEntity = reviewsRepo.save(reviewEntity);

			Integer sumOfRatings = reviewsRepo.getRatingSumFindByHotelId(hotelEntity.getHotelId());
			Integer ratedCount = reviewsRepo.countByHotelId(hotelEntity.getHotelId());

			Integer overAllRatings = (sumOfRatings * 10) / (ratedCount * 10);

			hotelEntity.setOverAllRatings(overAllRatings);
			hotelRepo.save(hotelEntity);
			// Save and return updated review object
			return savedReviewEntity;
		}
		return null;
	}

}
