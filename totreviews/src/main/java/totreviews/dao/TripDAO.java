package totreviews.dao;

import java.util.List;

import totreviews.domain.TripVO;

public interface TripDAO {

	List<TripVO> getTripByMemId(String memId);

}
