package totreviews.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.domain.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "totreviews.mapper.CommentMapper";

	@Override
	public List<CommentVO> getCommentsByReviewId(int trevid) {
		return sqlSession.selectList(NAMESPACE + ".getCommentsByReviewId", trevid);
	}

	@Override
	public CommentVO getCommentById(int commentId) {
		return sqlSession.selectOne(NAMESPACE + ".getCommentById", commentId);
	}

	@Override
	public void insertComment(CommentVO commentVO) {
		sqlSession.insert(NAMESPACE + ".insertComment", commentVO);
	}

}
