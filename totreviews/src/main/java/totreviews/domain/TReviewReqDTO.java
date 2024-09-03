package totreviews.domain;

import org.springframework.web.multipart.MultipartFile;

import totreviews.exception.ErrorCode;
import totreviews.util.FileUtils;
import totreviews.util.ValidationUtils;

public class TReviewReqDTO {

	private int tripid; // 여행 아이디
	private String memid; // 회원 아이디
	private String trevtitle; // 후기 제목
	private String trevcourse; // 코스
	private String trevcontent; // 내용
	private String trevimgpath; // 이미지 경로
	private String trevAgree; // 개인정보 동의 여부

	public TReviewReqDTO() {
	}

	public TReviewReqDTO(int tripid, String memid, String trevtitle, String trevcourse, String trevcontent,
			String trevimgpath, String trevAgree) {
		super();
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
		ValidationUtils.validateNotEmpty(trevtitle, ErrorCode.NOT_FOUND_TREVTITLE);
		ValidationUtils.validateNotEmpty(trevcourse, ErrorCode.NOT_FOUND_TREVCOURSE);
		ValidationUtils.validateNotEmpty(trevcontent, ErrorCode.NOT_FOUND_TREVCONTENT);
		ValidationUtils.validateLength(trevtitle, 200, ErrorCode.TITLE_TOO_LONG);
		ValidationUtils.validateLength(trevcontent, 1000, ErrorCode.CONTENT_TOO_LONG);
		ValidationUtils.validateNotEmpty(trevAgree, ErrorCode.NOT_FOUND_TREVAGREE);
		ValidationUtils.validateCheck(trevAgree, ErrorCode.NOT_CHECK_TREVAGREE);
	}

	// 이미지 경로 설정 메소드
	public void processImageFile(MultipartFile imageFile) {
		if (imageFile != null && !imageFile.isEmpty()) {
			String imagePath = FileUtils.saveImage(imageFile);
			this.trevimgpath = imagePath;
		} else {
			this.trevimgpath = "";
		}
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
		return "TReviewReqDTO [tripid=" + tripid + ", memid=" + memid + ", trevtitle=" + trevtitle + ", trevcourse="
				+ trevcourse + ", trevcontent=" + trevcontent + ", trevimgpath=" + trevimgpath + ", trevAgree="
				+ trevAgree + "]";
	}

}
