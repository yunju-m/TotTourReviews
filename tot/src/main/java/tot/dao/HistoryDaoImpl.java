package tot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tot.domain.HistoryVO;

@Repository
public class HistoryDaoImpl implements HistoryDao {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "tot.dao.HistoryDao";

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
