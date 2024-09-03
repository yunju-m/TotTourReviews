package totreviews.domain;

import java.sql.Timestamp;

public class TReviewVO {

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

	public TReviewVO() {
	}

	public TReviewVO(int trevid, int tripid, String memid, String trevstatus, String trevtitle, String trevcourse,
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

	public static TReviewVO fromDTO(TReviewReqDTO dto) {
		// TODO 현재 임의의 사용자와 여행 번호 선언
		return new TReviewVO(0, 1, "user001", "CMT001", dto.getTrevtitle(), dto.getTrevcourse(),
				dto.getTrevcontent(), dto.getTrevimgpath(), "0", new Timestamp(System.currentTimeMillis()), null, 0);
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

	@Override
	public String toString() {
		return "TReviewDTO [trevid=" + trevid + ", tripid=" + tripid + ", memid=" + memid + ", trevstatus=" + trevstatus
				+ ", trevtitle=" + trevtitle + ", trevcourse=" + trevcourse + ", trevcontent=" + trevcontent
				+ ", trevimgpath=" + trevimgpath + ", trevrating=" + trevrating + ", trevregdate=" + trevregdate
				+ ", trevupdate=" + trevupdate + ", trevcount=" + trevcount + "]";
	}

}
