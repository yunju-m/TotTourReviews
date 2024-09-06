package totreviews.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.domain.TourResDTO;

@Repository
public class TourDAOImpl implements TourDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "totreviews.mapper.TourMapper";

	@Override
	public TourResDTO getTourById(String tourId) {
		return sqlSession.selectOne(NAMESPACE + ".getTourById", tourId);
	}

}
