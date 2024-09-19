package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import totreviews.dao.TourDAO;
import totreviews.domain.TourVO;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourDAO tourDAO;

	@Override
	public TourVO getTourById(String tourId) {
		return tourDAO.getTourById(tourId);
	}

}
