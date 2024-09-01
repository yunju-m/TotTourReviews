package totreviews.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.domain.CourseDTO;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "totreviews.mapper.CourseMapper";

	@Override
	public CourseDTO getCourseById(String courseId) {
		return sqlSession.selectOne(NAMESPACE + ".getCourseById", courseId);
	}

}
