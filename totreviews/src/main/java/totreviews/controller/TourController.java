package totreviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import totreviews.domain.TourDTO;
import totreviews.service.TourService;

@Controller
@RequestMapping("tour")
public class TourController {

	@Autowired
	private TourService tourService;

	@GetMapping("/{tourId}")
	@ResponseBody
	public TourDTO getTourById(@PathVariable("tourId") String tourId) {
		return tourService.getTourById(tourId);
	}

}
