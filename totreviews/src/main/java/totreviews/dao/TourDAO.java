package totreviews.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.domain.TourDTO;

@Repository
public class TourDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "totreviews.mapper.TourMapper";

	public TourDTO getTourById(String tourId) {
		return sqlSession.selectOne(NAMESPACE + ".getTourById", tourId);
	}

}
