package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import totreviews.dao.TReviewDAO;
import totreviews.domain.TReviewImageVO;
import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewVO;
import totreviews.exception.ServerException;
import totreviews.util.FileUtils;

@Service
public class TReviewServiceImpl implements TReviewService {

	@Autowired
	private TReviewDAO treviewDAO;

	@Override
	public void insertTReview(TReviewReqDTO treviewReqDTO, MultipartFile[] imageFiles) {
		try {
			// DTO 검증
			treviewReqDTO.validate();

			TReviewVO tReviewVO = TReviewVO.fromDTO(treviewReqDTO);
			treviewDAO.insertTReview(tReviewVO);

			// 이미지 파일 처리
			TReviewImageVO tReviewImageVO = new TReviewImageVO();
			treviewReqDTO.setTrevid(tReviewVO.getTrevid());
			if (imageFiles != null && imageFiles.length > 0) {
				for (MultipartFile imageFile : imageFiles) {
					if (!imageFile.isEmpty()) {
						String imagePath = FileUtils.saveImage(imageFile);
						treviewReqDTO.setTrevimgpath(imagePath);
						tReviewImageVO = TReviewImageVO.fromDTO(treviewReqDTO);

						treviewDAO.insertTReviewImage(tReviewImageVO);
					}
				}
			}
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 데이터 삽입 중 데이터베이스 오류 발생", e);
		}
	}

}
