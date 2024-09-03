package totreviews.service;

import org.springframework.web.multipart.MultipartFile;

import totreviews.domain.TReviewReqDTO;

public interface TReviewService {

	public void insertTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles);

}
