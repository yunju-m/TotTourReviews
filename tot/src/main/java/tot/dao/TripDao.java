package tot.dao;

import java.util.List;

import tot.domain.TripVO;

public interface TripDao {

	List<TripVO> getTripByMemId(String memId);

}
