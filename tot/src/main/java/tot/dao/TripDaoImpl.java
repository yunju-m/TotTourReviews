package tot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tot.domain.TripVO;

@Repository
public class TripDaoImpl implements TripDao {

	private static final String NAMESPACE = "tot.dao.TripDao";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<TripVO> getTripByMemId(String memId) {
		return sqlSession.selectList(NAMESPACE + ".getTripByMemId", memId);
	}

}
