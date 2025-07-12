package it.epicode.cinemeet.controller;

import it.epicode.cinemeet.model.Review;
import it.epicode.cinemeet.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewRepository reviewRepo;

    public ReviewController(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewRepo.save(review);
    }

    @GetMapping("/event/{eventId}")
    public List<Review> getReviewsForEvent(@PathVariable Long eventId) {
        return reviewRepo.findByEventId(eventId);
    }
}
