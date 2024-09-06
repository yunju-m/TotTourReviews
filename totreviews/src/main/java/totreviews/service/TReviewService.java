package totreviews.service;

import org.springframework.web.multipart.MultipartFile;

import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewResDTO;

public interface TReviewService {

	public void insertTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles);

	public PageResDTO<TReviewResDTO> findTReviewListWithPaging(PageReqDTO dto, String boardId);

}
