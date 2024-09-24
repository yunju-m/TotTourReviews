package tot.dao;

import java.util.List;

import tot.domain.TripVO;

public interface TripDAO {

	List<TripVO> getTripByMemId(String memId);

}
