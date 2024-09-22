package totreviews.admin.service;

import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.TReviewResDTO;

public interface AdminTReviewService {

	PageResDTO<TReviewResDTO> findTReviewListWithPaging(PageReqDTO dto, String boardId);

	void updateTReviewStatus(String status, int trevId);

}
