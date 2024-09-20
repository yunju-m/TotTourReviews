package totreviews.service;

import totreviews.domain.HistoryVO;

public interface HistoryService {

	void insertTReviewHistory(HistoryVO historyVO);

	void insertCommentHistory(HistoryVO historyVO);

}
