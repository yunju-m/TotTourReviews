package totreviews.service;

import java.util.List;

import totreviews.domain.CommentVO;

public interface CommentService {

	List<CommentVO> getCommentsByReviewId(int trevid);

}
