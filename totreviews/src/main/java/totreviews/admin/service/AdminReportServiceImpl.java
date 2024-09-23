package totreviews.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import totreviews.admin.dao.AdminReportDAO;
import totreviews.common.page.PageDTO;
import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.ReportDTO;
import totreviews.exception.ServerException;

@Service
public class AdminReportServiceImpl implements AdminReportService {

	@Autowired
	private AdminReportDAO adminReportDAO;

	@Override
	public PageResDTO<ReportDTO> findReportListWithPaging(PageReqDTO pageReqDTO, String boardId) {
		try {
			PageDTO pageDTO = new PageDTO(pageReqDTO, boardId);
			int totalTReviewCount = adminReportDAO.selectTotalReportCount(pageDTO);

			List<ReportDTO> reportList = adminReportDAO.findReportListWithPaging(pageDTO);

			return new PageResDTO<>(totalTReviewCount, pageReqDTO.getPage(), reportList);
		} catch (DataAccessException e) {
			throw new ServerException("여행 게시물 신고 목록 정보 가져오던 중 데이터베이스 오류 발생", e);
		}
	}

	@Override
	public void updateReportStatus(String status, List<Integer> reportIds) {
		try {
			adminReportDAO.updateReportStatus(status, reportIds);
		} catch (DataAccessException e) {
			throw new ServerException("여행 신고 상태 업데이트 중 오류 발생", e);
		}

	}

}
