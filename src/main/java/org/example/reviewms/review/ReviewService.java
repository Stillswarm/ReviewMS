package org.example.reviewms.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsByCompanyId(Long companyId);
    Review getReviewById(Long id);
    boolean createReview(Long companyId, Review review);
    boolean updateReviewById(Long id, Review updatedReview);
    boolean deleteReview(Long id);
}
