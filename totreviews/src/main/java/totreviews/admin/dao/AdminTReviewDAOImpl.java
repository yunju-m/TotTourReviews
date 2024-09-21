package totreviews.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import totreviews.common.page.PageDTO;
import totreviews.domain.TReviewResDTO;

@Repository
public class AdminTReviewDAOImpl implements AdminTReviewDAO {

	private static final String NAMESPACE = "totreviews.mapper.AdminTReviewMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectTotalTReviewCount(PageDTO pageDTO) {
		return sqlSession.selectOne(NAMESPACE + ".selectTotalTReviewCount", pageDTO);
	}

	@Override
	public List<TReviewResDTO> selectTReviewListWithPaging(PageDTO pageDTO) {
		return sqlSession.selectList(NAMESPACE + ".selectTReviewListWithPaging", pageDTO);
	}

	@Override
	public void updateTReviewStatus(int trevId) {
		sqlSession.update(NAMESPACE + ".updateTReviewStatus", trevId);
	}

}
