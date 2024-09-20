package totreviews.dao;

import totreviews.domain.HistoryVO;

public interface HistoryDAO {

	void insertTReviewHistory(HistoryVO historyVO);

	void insertCommentHistory(HistoryVO historyVO);

}
