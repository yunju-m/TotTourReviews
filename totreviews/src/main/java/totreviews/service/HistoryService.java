package totreviews.service;

import java.util.List;

import totreviews.domain.HistoryVO;

public interface HistoryService {

	void insertTReviewHistory(HistoryVO historyVO);

	void insertCommentHistory(HistoryVO historyVO);

	List<HistoryVO> getTReviewHistorysById(int trevId);

}
