package totreviews.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.domain.HistoryVO;

@Repository
public class HistoryDAOImpl implements HistoryDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "totreviews.mapper.HistoryMapper";

	@Override
	public void insertTReviewHistory(HistoryVO historyVO) {
		sqlSession.insert(NAMESPACE + ".insertTReviewHistory", historyVO);
	}

	@Override
	public void insertCommentHistory(HistoryVO historyVO) {
		sqlSession.insert(NAMESPACE + ".insertCommentHistory", historyVO);
	}

	@Override
	public List<HistoryVO> getTReviewHistorysById(int trevId) {
		return sqlSession.selectList(NAMESPACE + ".getTReviewHistorysById", trevId);
	}

}
