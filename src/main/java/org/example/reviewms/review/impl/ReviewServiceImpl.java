package org.example.reviewms.review.impl;

import org.example.reviewms.review.Review;
import org.example.reviewms.review.ReviewRepository;
import org.example.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviewsByCompanyId(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReviewById(Long id, Review updatedReview) {
        var reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            // copy all fields
            reviewRepository.save(updatedReview);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteReview(Long id) {
        try {
            reviewRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
