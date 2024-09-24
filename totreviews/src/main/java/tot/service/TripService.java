package tot.service;

import java.util.List;

import tot.domain.TripVO;

public interface TripService {

	List<TripVO> getTripByMemId(String memId);

}
