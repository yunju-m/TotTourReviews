package totreviews.admin.service;

import java.util.List;

import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.CommentVO;

public interface AdminCommentService {

	List<CommentVO> getCommentsByReviewId(int trevid);

	void updateCommentStatus(String status, List<Integer> trevcIds);

	PageResDTO<CommentVO> findCommentListWithPaging(PageReqDTO dto);

}
