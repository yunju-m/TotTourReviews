package totreviews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import totreviews.dao.CommentDAO;
import totreviews.domain.CommentReqDTO;
import totreviews.domain.CommentVO;
import totreviews.exception.ServerException;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	public List<CommentVO> getCommentsByReviewId(int trevid) {
		try {
			return commentDAO.getCommentsByReviewId(trevid);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 목록 가져오던 중 오류 발생", e);
		}
	}

	@Override
	public void insertComment(String boardId, int postId, CommentReqDTO commentReqDTO) {
		try {
			CommentVO commentVO = new CommentVO(postId, commentReqDTO);
			
			// 댓글 정보 처리(최상위 댓글 ID, 댓글 depth 저장)
			handleSetCommentInfo(commentVO, postId);
			commentDAO.insertComment(commentVO);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 작성 등록 중 오류 발생", e);
		}
	}
	
	// 추가되는 댓글에 대한 최상위 부모 댓글 ID, depth 설정
	private void handleSetCommentInfo(CommentVO vo, int postId) {
		// 부모 댓글 ID가 있을 경우, 대댓글로 간주
	    if (vo.getParentId() != 0) {
	    	System.out.println("대댓글?");
	        CommentVO parentComment = commentDAO.getCommentById(vo.getParentId());
	        System.out.println(parentComment);

	        if (parentComment != null) {
	        	System.out.println("최상위 부모 등록!");
	            vo.setCommentInfo(parentComment.getTopParentId(), parentComment.getDepth() + 1);
	        }
	    } else {
	    	System.out.println("최상위댓글!");
	        vo.setCommentInfo(vo.getCommentId(), 0);
	    }
	}

}
