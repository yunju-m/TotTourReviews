package totreviews.admin.dao;

import java.util.List;

import totreviews.common.page.PageDTO;
import totreviews.domain.TReviewResDTO;

public interface AdminTReviewDAO {

	int selectTotalTReviewCount(PageDTO pageDTO);

	List<TReviewResDTO> selectTReviewListWithPaging(PageDTO pageDTO);

	void updateTReviewStatus(String status, int trevId);

}
