package totreviews.domain;

import java.sql.Timestamp;

import totreviews.common.enums.Flag;

public class CommentVO {
	private int commentId; // 댓글 아이디
	private int postId; // 게시물 아이디
	private String memnick; // 댓글 작성자
	private Flag status; // 게시여부코드
	private String content; // 내용
	private Timestamp regdate; // 작성일시
	private Timestamp update; // 수정일시

	public CommentVO() {
	}

	public CommentVO(int commentId, int postId, String memnick, Flag status, String content, Timestamp regdate,
			Timestamp update) {
		this.commentId = commentId;
		this.postId = postId;
		this.memnick = memnick;
		this.status = status;
		this.content = content;
		this.regdate = regdate;
		this.update = update;
	}

	public int getCommentId() {
		return commentId;
	}

	public int getPostId() {
		return postId;
	}

	public String getMemnick() {
		return memnick;
	}

	public Flag getStatus() {
		return status;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public Timestamp getUpdate() {
		return update;
	}

	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", postId=" + postId + ", memnick=" + memnick + ", status="
				+ status + ", content=" + content + ", regdate=" + regdate + ", update=" + update + "]";
	}

}
