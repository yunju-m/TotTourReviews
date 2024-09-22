package totreviews.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.domain.CommentVO;

@Repository
public class AdminCommentDAOImpl implements AdminCommentDAO {

	private static final String NAMESPACE = "totreviews.mapper.AdminCommentMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CommentVO> getCommentsByReviewId(int trevId) {
		return sqlSession.selectList(NAMESPACE + ".getCommentsByReviewId", trevId);
	}
	
	@Override
	public List<String> findInactiveParentComments(List<Integer> trevcIds) {
	    return sqlSession.selectList(NAMESPACE + ".findInactiveParentComments", trevcIds);
	}

	@Override
	public void updateCommentStatus(String status, List<Integer> trevcIds) {
		Map<String, Object> params = new HashMap<>();
		params.put("status", status);
		params.put("trevcIds", trevcIds);

		sqlSession.update(NAMESPACE + ".updateCommentStatus", params);
	}

}
