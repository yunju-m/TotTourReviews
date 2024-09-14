package totreviews.dao;

import java.util.List;

import totreviews.domain.CommentVO;
import totreviews.domain.ReportVO;

public interface CommentDAO {

	List<CommentVO> getCommentsByReviewId(int trevid);

	CommentVO getCommentById(int commentId);

	void insertComment(CommentVO commentVO);

	void updateTopParentId(int commentId);

	void editComment(int commentId, String content);

	void deleteComment(int commentId);

	void updateCommentStatus(int commentId);

	void insertReportComment(ReportVO reportVO);

	String getUpdateDate(int commentId);

}
