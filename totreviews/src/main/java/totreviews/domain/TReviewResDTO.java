package totreviews.domain;

import java.sql.Timestamp;

public class TReviewResDTO {
	private int trevid; // 여행후기 게시글 아이디
	private int tripid; // 여행 아이디
	private String memid; // 회원 아이디
	private String trevstatus; // 게시여부코드
	private String trevtitle; // 후기 제목
	private String trevcourse; // 코스
	private String trevcontent; // 내용
	private String trevimgpath; // 이미지 경로
	private String trevrating; // 평점
	private Timestamp trevregdate; // 작성일시
	private Timestamp trevupdate; // 수정일시
	private Integer trevcount; // 조회수

	public TReviewResDTO() {
	}

	public TReviewResDTO(int trevid, int tripid, String memid, String trevstatus, String trevtitle, String trevcourse,
			String trevcontent, String trevimgpath, String trevrating, Timestamp trevregdate, Timestamp trevupdate,
			Integer trevcount) {
		this.trevid = trevid;
		this.tripid = tripid;
		this.memid = memid;
		this.trevstatus = trevstatus;
		this.trevtitle = trevtitle;
		this.trevcourse = trevcourse;
		this.trevcontent = trevcontent;
		this.trevimgpath = trevimgpath;
		this.trevrating = trevrating;
		this.trevregdate = trevregdate;
		this.trevupdate = trevupdate;
		this.trevcount = trevcount;
	}

	public int getTrevid() {
		return trevid;
	}

	public int getTripid() {
		return tripid;
	}

	public String getMemid() {
		return memid;
	}

	public String getTrevstatus() {
		return trevstatus;
	}

	public String getTrevtitle() {
		return trevtitle;
	}

	public String getTrevcourse() {
		return trevcourse;
	}

	public String getTrevcontent() {
		return trevcontent;
	}

	public String getTrevimgpath() {
		return trevimgpath;
	}

	public String getTrevrating() {
		return trevrating;
	}

	public Timestamp getTrevregdate() {
		return trevregdate;
	}

	public Timestamp getTrevupdate() {
		return trevupdate;
	}

	public Integer getTrevcount() {
		return trevcount;
	}

	public void setTrevid(int trevid) {
		this.trevid = trevid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public void setTrevstatus(String trevstatus) {
		this.trevstatus = trevstatus;
	}

	public void setTrevtitle(String trevtitle) {
		this.trevtitle = trevtitle;
	}

	public void setTrevcourse(String trevcourse) {
		this.trevcourse = trevcourse;
	}

	public void setTrevcontent(String trevcontent) {
		this.trevcontent = trevcontent;
	}

	public void setTrevimgpath(String trevimgpath) {
		this.trevimgpath = trevimgpath;
	}

	public void setTrevrating(String trevrating) {
		this.trevrating = trevrating;
	}

	public void setTrevregdate(Timestamp trevregdate) {
		this.trevregdate = trevregdate;
	}

	public void setTrevupdate(Timestamp trevupdate) {
		this.trevupdate = trevupdate;
	}

	public void setTrevcount(Integer trevcount) {
		this.trevcount = trevcount;
	}

	@Override
	public String toString() {
		return "TReviewDTO [trevid=" + trevid + ", tripid=" + tripid + ", memid=" + memid + ", trevstatus=" + trevstatus
				+ ", trevtitle=" + trevtitle + ", trevcourse=" + trevcourse + ", trevcontent=" + trevcontent
				+ ", trevimgpath=" + trevimgpath + ", trevrating=" + trevrating + ", trevregdate=" + trevregdate
				+ ", trevupdate=" + trevupdate + ", trevcount=" + trevcount + "]";
	}

}
