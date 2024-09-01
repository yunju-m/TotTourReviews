package totreviews.domain;

import java.sql.Timestamp;

public class TripVO {

	private int tripid; // 여행 아이디
	private String memid; // 회원 아이디
	private String areacode; // 지역코드
	private int tramt; // 여행 예상 비용
	private Timestamp trstadate; // 여행 시작일
	private Timestamp trenddate; // 예상 도착일
	private String trperiod; // 여행기간
	private int trpeople; // 여행 인원수
	private String trimgpath; // 여행 이미지 경로

	public TripVO() {
	}

	public TripVO(int tripid, String memid, String areacode, int tramt, Timestamp trstadate, Timestamp trenddate,
			String trperiod, int trpeople, String trimgpath) {
		this.tripid = tripid;
		this.memid = memid;
		this.areacode = areacode;
		this.tramt = tramt;
		this.trstadate = trstadate;
		this.trenddate = trenddate;
		this.trperiod = trperiod;
		this.trpeople = trpeople;
		this.trimgpath = trimgpath;
	}

	public int getTripid() {
		return tripid;
	}

	public String getMemid() {
		return memid;
	}

	public String getAreacode() {
		return areacode;
	}

	public int getTramt() {
		return tramt;
	}

	public Timestamp getTrstadate() {
		return trstadate;
	}

	public Timestamp getTrenddate() {
		return trenddate;
	}

	public String getTrperiod() {
		return trperiod;
	}

	public int getTrpeople() {
		return trpeople;
	}

	public String getTrimgpath() {
		return trimgpath;
	}

	@Override
	public String toString() {
		return "TripVO [tripid=" + tripid + ", memid=" + memid + ", areacode=" + areacode + ", tramt=" + tramt
				+ ", trstadate=" + trstadate + ", trenddate=" + trenddate + ", trperiod=" + trperiod + ", trpeople="
				+ trpeople + ", trimgpath=" + trimgpath + "]";
	}

}
