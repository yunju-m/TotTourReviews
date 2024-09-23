package totreviews.admin.dao;

import java.util.List;

import totreviews.common.page.PageDTO;
import totreviews.domain.CommentVO;

public interface AdminCommentDAO {

	List<CommentVO> getCommentsByReviewId(int trevid);

	List<String> findInactiveParentComments(List<Integer> trevcIds);

	void updateCommentStatus(String status, List<Integer> trevcIds);

	int selectTotalCommentCount(PageDTO pageDTO);

	List<CommentVO> selectCommentListWithPaging(PageDTO pageDTO);

}
