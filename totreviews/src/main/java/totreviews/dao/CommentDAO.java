package totreviews.dao;

import java.util.List;

import totreviews.domain.CommentReqDTO;
import totreviews.domain.CommentVO;

public interface CommentDAO {

	List<CommentVO> getCommentsByReviewId(int trevid);

	void insertComment(CommentReqDTO commentReqDTO);

}
