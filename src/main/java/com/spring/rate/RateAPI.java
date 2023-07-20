package com.spring.rate;
@RestController
@RequestMapping ("/ratings")
public class RateAPI {
	@Autowired
	private RatingService ratingService;
	
	@GetMapping
	public List<Ratings> findRatingByBookId(
			@RequestParam(required = false, defaultValue = "0") Long bookId) {
		if(bookId.equal(0L)) {
			return ratingService.findAllRatings();
		}
		return ratingService.findRatingsByBookId(bookId);
	}
	@PostMapping
	public Rating createRating(@RequestBody Rating rating) {
		return ratingService.createRating.(rating);
	}
	@DeleteMapping("/{ratingId}")
	public void deleteRating(@PathVariable Long ratingId) {
		ratingService.deleteRating(ratingId);
	}
	@PutMapping("/{ratingId}")
	public Rating updateRating(@RequestBody Rating rating, @PathVariable Long ratingId) {
		return ratingService.updateRating(rating, ratingId);
	}
	@PatchMapping("/{ratingId}")
	public Rating updateRating (
			@RequestBody Map<String, String> updates,
			@PathVariable Long ratingId) {
		return ratingService.updateRating(updates, ratingId);
	}
	
}
