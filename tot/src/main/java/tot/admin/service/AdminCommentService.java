package tot.admin.service;

import java.util.List;

import tot.common.page.PageReqDTO;
import tot.common.page.PageResDTO;
import tot.domain.CommentVO;

public interface AdminCommentService {

	List<CommentVO> getCommentsByReviewId(int trevid);

	void updateCommentStatus(String status, List<Integer> trevcIds);

	PageResDTO<CommentVO> findCommentListWithPaging(PageReqDTO dto, String boardId);
	
	PageResDTO<CommentVO> findCommentListWithPaging(PageReqDTO dto, String boardId, int postId);

}
