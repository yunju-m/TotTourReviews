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
			List<CommentVO> comments = commentDAO.getCommentsByReviewId(trevid);

			return comments;
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 목록 가져오던 중 오류 발생", e);
		}
	}

	/*
	 * 댓글 정보 처리
	 * 최상위 댓글 ID, 댓글 depth 저장 최상위 댓글일 경우, 
	 * 자신의 commentId를 topParentId로 설정
	 */
	@Override
	public void insertComment(String boardId, int postId, CommentReqDTO commentReqDTO) {
		try {
			CommentVO commentVO = new CommentVO(postId, commentReqDTO);
			handleSetCommentInfo(commentVO, postId);

			commentDAO.insertComment(commentVO);

			int insertedCommentId = commentVO.getCommentId();
			if (commentVO.getParentId() == 0) {
				commentVO.setCommentInfo(insertedCommentId, 0);

				updateTopParentId(commentVO);
			}
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 작성 등록 중 오류 발생", e);
		}
	}
	
	/*
	 * 댓글 수정 처리
	 * 새로운 댓글 내용으로 업데이트
	 * */
	@Override
	public void editComment(int commentId, String content) {
		try {
			commentDAO.editComment(commentId, content);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 수정 중 오류 발생", e);
		}
	}
	
	/*
	 * 댓글 삭제 처리
	 * 해당 댓글 삭제 상태 업데이트
	 * */
	@Override
	public void deleteComment(int commentId) {
		try {
			commentDAO.deleteComment(commentId);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 삭제 중 오류 발생", e);
		}
	}
	
	/*
	 * 댓글 신고 처리
	 * 해당 댓글 신고 상태 업데이트 
	 * */
	@Override
	public void reportComment(int commentId) {
		try {
			commentDAO.reportComment(commentId);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 신고 중 오류 발생", e);
		}
		
	}
	
	/*
	 * 댓글 수정, 삭제에 대한 업데이트 시간 반환
	 * */
	@Override
	public String getUpdateDate(int commentId) {
		try {
			return commentDAO.getUpdateDate(commentId);
		} catch (DataAccessException e) {
			throw new ServerException("여행 후기 댓글 신고 중 오류 발생", e);
		}
	}

	/*
	 * 추가되는 댓글에 대한 최상위 부모 댓글 ID, depth 설정
	 * 부모 댓글 ID가 있을 경우, 대댓글로 간주
	 */
	private void handleSetCommentInfo(CommentVO vo, int postId) {
		// 부모 댓글 ID가 있을 경우, 대댓글로 간주
		if (vo.getParentId() != 0) {
			CommentVO parentComment = commentDAO.getCommentById(vo.getParentId());

			if (parentComment != null) {
				vo.setCommentInfo(parentComment.getTopParentId(), parentComment.getDepth() + 1);
			}
		} else {
			vo.setCommentInfo(vo.getCommentId(), 0);
		}
	}

	/*
	 * 최상위 댓글 topParentId 업데이트 처리
	 */
	private void updateTopParentId(CommentVO commentVO) {
		commentDAO.updateTopParentId(commentVO.getCommentId());
	}

}
