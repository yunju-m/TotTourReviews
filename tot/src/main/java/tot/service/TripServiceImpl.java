package tot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tot.dao.TripDAO;
import tot.domain.TripVO;

@Service
public class TripServiceImpl implements TripService {

	private final TripDAO tripDAO;

	public TripServiceImpl(TripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}

	/**
	 * 주어진 회원 ID에 해당하는 여행 목록을 조회합니다.
	 *
	 * @param memId 조회할 회원 ID
	 * @return 해당 회원의 여행 정보 리스트
	 */
	@Override
	public List<TripVO> getTripByMemId(String memId) {
		return tripDAO.getTripByMemId(memId);
	}

}
