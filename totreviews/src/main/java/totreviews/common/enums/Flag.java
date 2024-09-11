package totreviews.common.enums;

public enum Flag {
	CMT001("완료"), CMT002("삭제"), CMT003("신고"), CMT004("제재");

	private final String description;

	Flag(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
