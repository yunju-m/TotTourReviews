package totreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import totreviews.dao.TripDAO;
import totreviews.domain.TripVO;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripDAO tripDAO;
	
	@Override
	public List<TripVO> getTripByMemId(String memId) {
		return tripDAO.getTripByMemId(memId);
	}

}
