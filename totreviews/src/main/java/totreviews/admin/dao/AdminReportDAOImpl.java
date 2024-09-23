package totreviews.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.common.page.PageDTO;
import totreviews.domain.ReportDTO;

@Repository
public class AdminReportDAOImpl implements AdminReportDAO {

	private static final String NAMESPACE = "totreviews.mapper.AdminReportMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectTotalReportCount(PageDTO pageDTO) {
		return sqlSession.selectOne(NAMESPACE + ".selectTotalReportCount", pageDTO);
	}

	@Override
	public List<ReportDTO> findReportListWithPaging(PageDTO pageDTO) {
		return sqlSession.selectList(NAMESPACE + ".findReportListWithPaging", pageDTO);
	}

	@Override
	public void updateReportStatus(String status, List<Integer> trevcIds) {
		Map<String, Object> params = new HashMap<>();
		params.put("status", status);
		params.put("trevcIds", trevcIds);

		sqlSession.update(NAMESPACE + ".updateReportStatus", params);
	}

}
