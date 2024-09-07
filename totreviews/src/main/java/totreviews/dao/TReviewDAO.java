package totreviews.dao;

import java.util.List;

import totreviews.common.page.PageDTO;
import totreviews.domain.TReviewImageVO;
import totreviews.domain.TReviewResDTO;
import totreviews.domain.TReviewVO;

public interface TReviewDAO {

	void insertTReview(TReviewVO treviewVO);

	void insertTReviewImage(TReviewImageVO treviewImageVO);

	int selectTotalTReviewCount(PageDTO pageDTO);

	List<TReviewResDTO> selectTReviewListWithPaging(PageDTO pageDTO);

	TReviewResDTO getTReviewDetail(int trevid);

}
