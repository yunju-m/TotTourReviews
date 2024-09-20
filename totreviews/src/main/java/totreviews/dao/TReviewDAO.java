package totreviews.dao;

import java.util.List;

import totreviews.common.page.PageDTO;
import totreviews.domain.ReportVO;
import totreviews.domain.TReviewImageVO;
import totreviews.domain.TReviewResDTO;
import totreviews.domain.TReviewVO;

public interface TReviewDAO {

	void insertTReview(TReviewVO treviewVO);

	void insertTReviewImage(TReviewImageVO treviewImageVO);

	int selectTotalTReviewCount(PageDTO pageDTO);

	List<TReviewResDTO> selectTReviewListWithPaging(PageDTO pageDTO);

	void incrementTReviewCount(int trevId);

	TReviewResDTO getTReviewById(int trevId);

	void editTReview(TReviewVO treviewVO);

	void deleteTReviewImages(int trevId);

	void deleteTReview(int trevId);

	void insertReportTReview(ReportVO reportVO);

	void reportTReview(int trevId);

}
