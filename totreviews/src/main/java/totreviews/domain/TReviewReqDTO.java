package totreviews.domain;

import totreviews.exception.ErrorCode;
import totreviews.util.ValidationUtil;

public class TReviewReqDTO {

	private int trevid; // 여행후기 게시글 아이디
	private int tripid; // 여행 아이디
	private String memid; // 회원 아이디
	private String trevtitle; // 후기 제목
	private String trevcourse; // 코스
	private String trevcontent; // 내용
	private String trevimgpath; // 이미지 경로
	private String trevAgree; // 개인정보 동의 여부

	public TReviewReqDTO() {
	}

	public TReviewReqDTO(int trevid, int tripid, String memid, String trevtitle, String trevcourse, String trevcontent,
			String trevimgpath, String trevAgree) {
		this.trevid = trevid;
		this.tripid = tripid;
		this.memid = memid;
		this.trevtitle = trevtitle;
		this.trevcourse = trevcourse;
		this.trevcontent = trevcontent;
		this.trevimgpath = trevimgpath;
		this.trevAgree = trevAgree;
	}

	// DTO 검증 메소드
	public void validate() {
		ValidationUtil.validateNotEmpty(trevtitle, ErrorCode.NOT_FOUND_TREVTITLE);
		ValidationUtil.validateNotEmpty(trevcourse, ErrorCode.NOT_FOUND_TREVCOURSE);
		ValidationUtil.validateNotEmpty(trevcontent, ErrorCode.NOT_FOUND_TREVCONTENT);
		ValidationUtil.validateLength(trevtitle, 200, ErrorCode.TITLE_TOO_LONG);
		ValidationUtil.validateLength(trevcontent, 1000, ErrorCode.CONTENT_TOO_LONG);
		ValidationUtil.validateNotEmpty(trevAgree, ErrorCode.NOT_FOUND_TREVAGREE);
		ValidationUtil.validateCheck(trevAgree, ErrorCode.NOT_CHECK_TREVAGREE);
	}

	public int getTrevid() {
		return trevid;
	}

	public void setTrevid(int trevid) {
		this.trevid = trevid;
	}

	public int getTripid() {
		return tripid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getTrevtitle() {
		return trevtitle;
	}

	public void setTrevtitle(String trevtitle) {
		this.trevtitle = trevtitle;
	}

	public String getTrevcourse() {
		return trevcourse;
	}

	public void setTrevcourse(String trevcourse) {
		this.trevcourse = trevcourse;
	}

	public String getTrevcontent() {
		return trevcontent;
	}

	public void setTrevcontent(String trevcontent) {
		this.trevcontent = trevcontent;
	}

	public String getTrevimgpath() {
		return trevimgpath;
	}

	public void setTrevimgpath(String trevimgpath) {
		this.trevimgpath = trevimgpath;
	}

	public String getTrevAgree() {
		return trevAgree;
	}

	public void setTrevAgree(String trevAgree) {
		this.trevAgree = trevAgree;
	}

	@Override
	public String toString() {
		return "TReviewReqDTO [trevid=" + trevid + ", tripid=" + tripid + ", memid=" + memid + ", trevtitle="
				+ trevtitle + ", trevcourse=" + trevcourse + ", trevcontent=" + trevcontent + ", trevimgpath="
				+ trevimgpath + ", trevAgree=" + trevAgree + "]";
	}

}
