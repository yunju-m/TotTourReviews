package tot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tot.dao.TourDAO;
import tot.domain.TourVO;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourDAO tourDAO;

	/**
	 * 주어진 투어 ID에 해당하는 관광지 정보를 조회합니다.
	 *
	 * @param tourId 조회할 투어 ID
	 * @return 해당 관광지 정보 객체
	 */
	@Override
	public TourVO getTourById(String tourId) {
		return tourDAO.getTourById(tourId);
	}

}
