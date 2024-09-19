package totreviews.domain;

import totreviews.exception.ErrorCode;
import totreviews.util.ValidationUtil;

public class TReviewReqDTO {

	private int trevId; // 여행후기 게시글 아이디
	private int tripId; // 여행 아이디
	private String memId; // 회원 아이디
	private String trevTitle; // 후기 제목
	private String trevCourse; // 코스
	private String trevContent; // 내용
	private String trevImgpath; // 이미지 경로
	private String trevAgree; // 개인정보 동의 여부

	public TReviewReqDTO() {
	}

	public TReviewReqDTO(int trevId, int tripId, String memId, String trevTitle, String trevCourse, String trevContent,
			String trevImgpath, String trevAgree) {
		this.trevId = trevId;
		this.tripId = tripId;
		this.memId = memId;
		this.trevTitle = trevTitle;
		this.trevCourse = trevCourse;
		this.trevContent = trevContent;
		this.trevImgpath = trevImgpath;
		this.trevAgree = trevAgree;
	}

	// DTO 검증 메소드
	public void validate() {
		ValidationUtil.validateNotEmpty(trevTitle, ErrorCode.NOT_FOUND_TREVTITLE);
		ValidationUtil.validateNotEmpty(String.valueOf(trevId), ErrorCode.NOT_FOUND_TRIPID);
		ValidationUtil.validateNotEmpty(trevContent, ErrorCode.NOT_FOUND_TREVCONTENT);
		ValidationUtil.validateLength(trevTitle, 200, ErrorCode.TITLE_TOO_LONG);
		ValidationUtil.validateLength(trevContent, 1000, ErrorCode.CONTENT_TOO_LONG);
		ValidationUtil.validateNotEmpty(trevAgree, ErrorCode.NOT_FOUND_TREVAGREE);
		ValidationUtil.validateCheck(trevAgree, ErrorCode.NOT_CHECK_TREVAGREE);
	}

	public int getTrevId() {
		return trevId;
	}

	public int getTripId() {
		return tripId;
	}

	public String getMemId() {
		return memId;
	}

	public String getTrevTitle() {
		return trevTitle;
	}

	public String getTrevCourse() {
		return trevCourse;
	}

	public String getTrevContent() {
		return trevContent;
	}

	public String getTrevImgpath() {
		return trevImgpath;
	}

	public String getTrevAgree() {
		return trevAgree;
	}

	public void setTrevId(int trevId) {
		this.trevId = trevId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setTrevTitle(String trevTitle) {
		this.trevTitle = trevTitle;
	}

	public void setTrevCourse(String trevCourse) {
		this.trevCourse = trevCourse;
	}

	public void setTrevContent(String trevContent) {
		this.trevContent = trevContent;
	}

	public void setTrevImgpath(String trevImgpath) {
		this.trevImgpath = trevImgpath;
	}

	public void setTrevAgree(String trevAgree) {
		this.trevAgree = trevAgree;
	}

	@Override
	public String toString() {
		return "TReviewReqDTO [trevId=" + trevId + ", tripId=" + tripId + ", memId=" + memId + ", trevTitle="
				+ trevTitle + ", trevCourse=" + trevCourse + ", trevContent=" + trevContent + ", trevImgpath="
				+ trevImgpath + ", trevAgree=" + trevAgree + "]";
	}

}
