package totreviews.dao;

import java.util.List;

import totreviews.domain.CommentVO;

public interface CommentDAO {

	List<CommentVO> getCommentsByReviewId(int trevid);

	CommentVO getCommentById(int commentId);

	void insertComment(CommentVO commentVO);

	void updateTopParentId(int commentId);

	void editComment(int commentId, String content);

}
