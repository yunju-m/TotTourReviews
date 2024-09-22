package totreviews.admin.service;

import java.util.List;

import totreviews.domain.CommentVO;

public interface AdminCommentService {

	List<CommentVO> getCommentsByReviewId(int trevid);

	void updateCommentStatus(String status, List<Integer> trevcIds);

}
