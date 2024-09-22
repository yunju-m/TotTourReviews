package totreviews.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import totreviews.admin.dao.AdminTReviewDAO;
import totreviews.common.page.PageDTO;
import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.TReviewResDTO;
import totreviews.exception.ServerException;

@Service
public class AdminTReviewServiceImpl implements AdminTReviewService {

	@Autowired
	private AdminTReviewDAO adminTReviewDAO;

	@Override
	public PageResDTO<TReviewResDTO> findTReviewListWithPaging(PageReqDTO pageReqDTO, String boardId) {
		try {
			PageDTO pageDTO = new PageDTO(pageReqDTO, boardId);

			int totalTReviewCount = adminTReviewDAO.selectTotalTReviewCount(pageDTO);
			System.out.println(totalTReviewCount);

			List<TReviewResDTO> postList = adminTReviewDAO.selectTReviewListWithPaging(pageDTO);
			return new PageResDTO<>(totalTReviewCount, pageReqDTO.getPage(), postList);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 목록 데이터 가져오던 중 데이터베이스 오류 발생", e);
		}
	}

	@Override
	public void updateTReviewStatus(String status, int trevId) {
		try {
			adminTReviewDAO.updateTReviewStatus(status, trevId);
		} catch (DataAccessException e) {
			throw new ServerException("여행 게시물 상태 업데이트 중 오류 발생", e);
		}
	}

}
