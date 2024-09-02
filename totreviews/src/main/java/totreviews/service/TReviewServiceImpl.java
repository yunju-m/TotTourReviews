package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import totreviews.dao.TReviewDAO;
import totreviews.domain.TReviewReqDTO;

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
			// TODO 임시 회원 정보 입력
			treviewReqDTO.setMemid("user001");
			treviewReqDTO.setTripid(1);
			treviewDAO.insertTReview(treviewReqDTO);
		} catch (Exception e) {
			throw new RuntimeException("여행 후기 데이터 삽입 중 오류 발생", e);
		}
	}

}
