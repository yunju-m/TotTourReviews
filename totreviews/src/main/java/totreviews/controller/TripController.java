package totreviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static totreviews.common.Constants.*;

@Controller
@RequestMapping("/trip")
public class TripController {

	// 여행 코스 추천 경로 화면 호출
	@GetMapping
	public String getTripMap() {
		return PAGE_TRIP;
	}

}
