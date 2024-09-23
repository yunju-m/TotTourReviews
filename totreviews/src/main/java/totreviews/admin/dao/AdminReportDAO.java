package totreviews.admin.dao;

import java.util.List;

import totreviews.common.page.PageDTO;
import totreviews.domain.ReportDTO;

public interface AdminReportDAO {

	int selectTotalReportCount(PageDTO pageDTO);

	List<ReportDTO> findReportListWithPaging(PageDTO pageDTO);

	void updateReportStatus(String status, List<Integer> trevcIds);

}
