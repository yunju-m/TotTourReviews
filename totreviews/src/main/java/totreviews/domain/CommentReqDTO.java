package totreviews.domain;

import java.sql.Timestamp;

import totreviews.common.enums.Flag;

public class CommentReqDTO {
	private int commentId; // 댓글 아이디
	private String boardId; // 게시판 아이디
	private int postId; // 게시물 아이디
	private int parentId; // 부모 댓글 아이디
	private String memnick; // 댓글 작성자
	private Flag status; // 게시여부코드
	private String content; // 내용
	private Timestamp regdate; // 작성일시
	private Timestamp update; // 수정일시

	public CommentReqDTO() {
	}

	public CommentReqDTO(int commentId, String boardId, int postId, int parentId, String memnick, Flag status,
			String content, Timestamp regdate, Timestamp update) {
		this.commentId = commentId;
		this.boardId = boardId;
		this.postId = postId;
		this.parentId = parentId;
		this.memnick = memnick;
		this.status = status;
		this.content = content;
		this.regdate = regdate;
		this.update = update;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getMemnick() {
		return memnick;
	}

	public void setMemnick(String memnick) {
		this.memnick = memnick;
	}

	public Flag getStatus() {
		return status;
	}

	public void setStatus(Flag status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdate() {
		return update;
	}

	public void setUpdate(Timestamp update) {
		this.update = update;
	}

	@Override
	public String toString() {
		return "CommentReqDTO [commentId=" + commentId + ", boardId=" + boardId + ", postId=" + postId + ", parentId="
				+ parentId + ", memnick=" + memnick + ", status=" + status + ", content=" + content + ", regdate="
				+ regdate + ", update=" + update + "]";
	}

}
