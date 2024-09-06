package totreviews.domain;

import java.sql.Timestamp;

public class TReviewImageVO {

	private int trevimgid; // 여행후기 이미지 번호
	private int trevid; // 여행 후기 게시글 아이디
	private String memid; // 회원 아이디
	private String trevimgpath; // 이미지 경로
	private Timestamp trevimgregdate; // 업로드 일시
	private Timestamp trevimgupdate; // 수정 일시

	public TReviewImageVO() {
	}

	public TReviewImageVO(int trevimgid, int trevid, String memid, String trevimgpath, Timestamp trevimgregdate,
			Timestamp trevimgupdate) {
		this.trevimgid = trevimgid;
		this.trevid = trevid;
		this.memid = memid;
		this.trevimgpath = trevimgpath;
		this.trevimgregdate = trevimgregdate;
		this.trevimgupdate = trevimgupdate;
	}

	public static TReviewImageVO fromDTO(TReviewReqDTO dto) {
		return new TReviewImageVO(0, dto.getTrevid(), dto.getMemid(), dto.getTrevimgpath(),
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
	}

	public int getTrevimgid() {
		return trevimgid;
	}

	public int getTrevid() {
		return trevid;
	}

	public String getMemid() {
		return memid;
	}

	public String getTrevimgpath() {
		return trevimgpath;
	}

	public Timestamp getTrevimgregdate() {
		return trevimgregdate;
	}

	public Timestamp getTrevimgupdate() {
		return trevimgupdate;
	}

	@Override
	public String toString() {
		return "TReviewImageVO [trevimgid=" + trevimgid + ", trevid=" + trevid + ", memid=" + memid + ", trevimgpath="
				+ trevimgpath + ", trevimgregdate=" + trevimgregdate + ", trevimgupdate=" + trevimgupdate + "]";
	}

}
