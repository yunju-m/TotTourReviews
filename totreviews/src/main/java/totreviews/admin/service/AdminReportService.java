package totreviews.admin.service;

import java.util.List;

import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.ReportDTO;

public interface AdminReportService {

	void updateReportStatus(String status, List<Integer> trevcIds);

	PageResDTO<ReportDTO> findReportListWithPaging(PageReqDTO dto, String boardId);

}
