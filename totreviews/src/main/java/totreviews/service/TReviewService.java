package totreviews.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewResDTO;

public interface TReviewService {

	public void insertTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles);

	public List<TReviewResDTO> getAllTReviews();

}
