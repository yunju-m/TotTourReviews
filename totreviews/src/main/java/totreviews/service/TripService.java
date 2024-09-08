package totreviews.service;

import java.util.List;

import totreviews.domain.TripVO;

public interface TripService {

	List<TripVO> getTripByMemId(String memId);

}
