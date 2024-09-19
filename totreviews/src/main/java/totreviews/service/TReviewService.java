package totreviews.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewResDTO;

public interface TReviewService {

	void insertTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles);

	PageResDTO<TReviewResDTO> findTReviewListWithPaging(PageReqDTO dto, String boardId);

	TReviewResDTO getTReviewById(int trevId);

	void incrementTReviewCount(int trevId);

	void editTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles, List<String> existingImages);

}
