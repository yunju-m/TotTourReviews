package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import totreviews.dao.TReviewDAO;
import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewVO;
import totreviews.exception.ServerException;

@Service
public class TReviewServiceImpl implements TReviewService {

	@Autowired
	private TReviewDAO treviewDAO;

	@Override
	public void insertTReview(TReviewReqDTO treviewReqDTO) {
		try {
			TReviewVO tReviewVO = TReviewVO.fromDTO(treviewReqDTO);
			treviewDAO.insertTReview(tReviewVO);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 데이터 삽입 중 데이터베이스 오류 발생", e);
		}
	}

}
