package totreviews.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.domain.CourseDTO;
import totreviews.domain.CourseResDTO;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "totreviews.mapper.CourseMapper";

	@Override
	public CourseDTO getCourseById(String courseId) {
		return sqlSession.selectOne(NAMESPACE + ".getCourseById", courseId);
	}

	@Override
	public List<CourseDTO> getCourseByTripId(int tripId) {
		return sqlSession.selectList(NAMESPACE + ".getCourseByTripId", tripId);
	}

	@Override
	public CourseResDTO getCourseDetailsById(String dcourseType, int dcourseId) {
		Map<String, Object> params = new HashMap<>();
		params.put("dcourseType", dcourseType);
		params.put("dcourseId", dcourseId);

		return sqlSession.selectOne(NAMESPACE + ".getCourseDetailsById", params);
	}

}
