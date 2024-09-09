package totreviews.domain;

public class CommentReqDTO {
	private int parentId; // 부모 댓글 아이디
	private String content; // 내용

	public CommentReqDTO() {
	}

	public CommentReqDTO(int parentId, String content) {
		this.parentId = parentId;
		this.content = content;
	}

	public int getParentId() {
		return parentId;
	}

	public String getContent() {
		return content;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentReqDTO [parentId=" + parentId + ", content=" + content + "]";
	}

}
