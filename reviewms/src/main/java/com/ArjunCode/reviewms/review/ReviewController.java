package com.ArjunCode.reviewms.review;

import com.ArjunCode.reviewms.review.messaging.ReviewMessageProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    //need service object
    private ReviewService reviewService;
    private ReviewMessageProducer reviewMessageProducer;

    public ReviewController(ReviewService reviewService, ReviewMessageProducer reviewMessageProducer) {
        this.reviewService = reviewService;
        this.reviewMessageProducer = reviewMessageProducer;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review){
        boolean isAdded = reviewService.addReview(companyId,review);
        if(isAdded){
            reviewMessageProducer.sendMessage(review);
            return new ResponseEntity<>("Review has successfully added", HttpStatus.OK);
        }
        return new ResponseEntity<>("Company with the given id doesn't exist so failed to add review", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId){
        Review review = reviewService.getReviewById(reviewId);
        if(review != null){
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        return new ResponseEntity<>(review,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview){
        boolean isReviewUpdated = reviewService.updateReview(reviewId,updatedReview);
        if(isReviewUpdated){
            return new ResponseEntity<>("Review successfully updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Failed to update for the given Company",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(reviewId);
        if(isReviewDeleted){
            return new ResponseEntity<>("The review of the particular company has been deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to delete the Review", HttpStatus.NOT_FOUND);
    }
}
