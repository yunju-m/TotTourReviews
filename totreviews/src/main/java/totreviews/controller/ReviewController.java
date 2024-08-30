package totreviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

	// 여행 후기 화면 
	@GetMapping
	public String showTourReview() {
		return "review";
	}
	
}
