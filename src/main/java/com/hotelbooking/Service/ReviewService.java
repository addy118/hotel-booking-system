package com.hotelbooking.Service;

import org.springframework.stereotype.Service;

import com.hotelbooking.Entity.ReviewRequestEntity;
import com.hotelbooking.Entity.Reviews;

@Service
public interface ReviewService {

	public boolean deleteRreview(int reviewId);

	public Reviews updateReviews(int reviewId, ReviewRequestEntity review);

	public Reviews createReview(ReviewRequestEntity review);

}
