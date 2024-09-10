package totreviews.domain;

import java.sql.Timestamp;

public class MemberVO {
	private String memid;
	private String member_001;
	private String member_002;
	private String memnick;
	private Timestamp memregdate;
	private String ttimg;

	public MemberVO() {
	}

	public MemberVO(String memid, String member_001, String member_002, String memnick, Timestamp memregdate,
			String ttimg) {
		this.memid = memid;
		this.member_001 = member_001;
		this.member_002 = member_002;
		this.memnick = memnick;
		this.memregdate = memregdate;
		this.ttimg = ttimg;
	}

	public String getMemid() {
		return memid;
	}

	public String getMember_001() {
		return member_001;
	}

	public String getMember_002() {
		return member_002;
	}

	public String getMemnick() {
		return memnick;
	}

	public Timestamp getMemregdate() {
		return memregdate;
	}

	public String getTtimg() {
		return ttimg;
	}

	@Override
	public String toString() {
		return "MemberVO [memid=" + memid + ", member_001=" + member_001 + ", member_002=" + member_002 + ", memnick="
				+ memnick + ", memregdate=" + memregdate + ", ttimg=" + ttimg + "]";
	}

}
