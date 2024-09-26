package tot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tot.domain.TourVO;

@Repository
public class TourDaoImpl implements TourDao {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "tot.dao.TourDao";

	@Override
	public TourVO getTourById(String tourId) {
		return sqlSession.selectOne(NAMESPACE + ".getTourById", tourId);
	}

}
