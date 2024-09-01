package totreviews.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import totreviews.domain.TReviewDTO;

@Repository
public class TReviewDAO {

	private static final String NAMESPACE = "totreviews.mapper.TReviewMapper";

	@Autowired
	private SqlSession sqlSession;

	public void insertTReview(TReviewDTO treview) {
		if (treview.equals(null)) {
			throw new IllegalArgumentException("여행 후기 데이터 목록이 null입니다.");
		}
		try {
			sqlSession.insert(NAMESPACE + ".insertTReview", treview);
		} catch (DataAccessException e) {
			throw new RuntimeException("투어 데이터를 삽입하는 도중 오류 발생", e);
		}

	}

}
