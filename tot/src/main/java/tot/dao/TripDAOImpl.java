package tot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tot.domain.TripVO;

@Repository
public class TripDAOImpl implements TripDAO {

	private static final String NAMESPACE = "tot.mapper.TripMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<TripVO> getTripByMemId(String memId) {
		return sqlSession.selectList(NAMESPACE + ".getTripByMemId", memId);
	}

}
