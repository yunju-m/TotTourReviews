package totreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import totreviews.dao.CommentDAO;
import totreviews.domain.CommentVO;
import totreviews.exception.ServerException;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	public List<CommentVO> getCommentsByReviewId(int trevid) {
		try {
			return commentDAO.getCommentsByReviewId(trevid);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 목록 가져오던 중 오류 발생", e);
		}
	}

}
