package totreviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import totreviews.domain.TourDTO;
import totreviews.service.TourService;

@RestController
@RequestMapping("tour")
public class TourRestController {

	@Autowired
	private TourService tourService;

	@GetMapping("/{tourId}")
	public TourDTO getTourById(@PathVariable("tourId") String tourId) {
		return tourService.getTourById(tourId);
	}

}
