package totreviews.domain;

import java.sql.Timestamp;

import totreviews.common.enums.Flag;
import totreviews.util.MemberUtil;

public class CommentVO {
	private int commentId; // 댓글 아이디
	private int postId; // 게시물 아이디
	private int topParentId; // 최상위 부모 댓글 아이디
	private int parentId; // 부모 댓글 아이디
	private String memId; // 댓글 작성자 아이디
	private String memnick; // 댓글 작성자 이름
	private String content; // 내용
	private int depth; // 댓글 깊이
	private Flag status; // 활성화 코드
	private Timestamp regdate; // 작성일시
	private Timestamp update; // 수정일시

	public CommentVO() {
	}

	public CommentVO(int postId, CommentReqDTO commentReqDTO) {
		this.postId = postId;
		this.parentId = commentReqDTO.getParentId();
		this.memId = MemberUtil.getAuthenticatedMember().getMemid();
		this.memnick = MemberUtil.getAuthenticatedMember().getMemnick();
		this.content = commentReqDTO.getContent();
	}

	public CommentVO(int commentId, int postId, int topParentId, int parentId, String memId, String memnick,
			String content, int depth, Flag status, Timestamp regdate, Timestamp update) {
		this.commentId = commentId;
		this.postId = postId;
		this.topParentId = topParentId;
		this.parentId = parentId;
		this.memId = memId;
		this.memnick = memnick;
		this.content = content;
		this.depth = depth;
		this.status = status;
		this.regdate = regdate;
		this.update = update;
	}

	public int getCommentId() {
		return commentId;
	}

	public int getPostId() {
		return postId;
	}

	public int getTopParentId() {
		return topParentId;
	}

	public int getParentId() {
		return parentId;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemnick() {
		return memnick;
	}

	public String getContent() {
		return content;
	}

	public int getDepth() {
		return depth;
	}

	public Flag getStatus() {
		return status;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public Timestamp getUpdate() {
		return update;
	}

	// 최상위 댓글 ID, 댓글 depth 설정
	public void setCommentInfo(int topParentId, int depth) {
		this.topParentId = topParentId;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", postId=" + postId + ", topParentId=" + topParentId
				+ ", parentId=" + parentId + ", memId=" + memId + ", memnick=" + memnick + ", content=" + content
				+ ", depth=" + depth + ", status=" + status + ", regdate=" + regdate + ", update=" + update + "]";
	}

}
