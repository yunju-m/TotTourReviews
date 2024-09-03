package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import totreviews.dao.TReviewDAO;
import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewVO;

@Service
public class TReviewServiceImpl implements TReviewService {

	@Autowired
	private TReviewDAO treviewDAO;

	@Override
	public void insertTReview(TReviewReqDTO treviewReqDTO) {
		if (treviewReqDTO == null) {
			throw new IllegalArgumentException("여행 후기 데이터가 null입니다.");
		}
		try {
			TReviewVO tReviewVO = TReviewVO.fromDTO(treviewReqDTO);
			treviewDAO.insertTReview(tReviewVO);
		} catch (Exception e) {
			throw new RuntimeException("여행 후기 데이터 삽입 중 오류 발생", e);
		}
	}

}
