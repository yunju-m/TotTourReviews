package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import totreviews.dao.TourDAOImpl;
import totreviews.domain.TourResDTO;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourDAOImpl tourDAO;

	@Override
	public TourResDTO getTourById(String tourId) {
		return tourDAO.getTourById(tourId);
	}

}
