package tot.domain;

import java.sql.Timestamp;

public class MemberVO {
	private String memId; // 회원 아이디
	private String memNick; // 회원 닉네임
	private String memEmail; // 회원 이메일
	private String memberStatus; // 회원 상태 (참조 코드)
	private String memberMbti; // MBTI (참조 코드)
	private String memberTt; // TT (참조 코드)
	private Timestamp memRegDate; // 회원 등록일
	private Timestamp memUpdate; // 회원 수정일
	private String ttImg; // 프로필 이미지
	private Timestamp memberBanStart; // 정지 시작일
	private Timestamp memberBanEnd; // 정지 종료일

	public MemberVO() {
	}

	public MemberVO(String memId, String memNick, String memEmail, String memberStatus, String memberMbti,
			String memberTt, Timestamp memRegDate, Timestamp memUpdate, String ttImg, Timestamp memberBanStart,
			Timestamp memberBanEnd) {
		this.memId = memId;
		this.memNick = memNick;
		this.memEmail = memEmail;
		this.memberStatus = memberStatus;
		this.memberMbti = memberMbti;
		this.memberTt = memberTt;
		this.memRegDate = memRegDate;
		this.memUpdate = memUpdate;
		this.ttImg = ttImg;
		this.memberBanStart = memberBanStart;
		this.memberBanEnd = memberBanEnd;
	}

	public MemberVO(String memId, String memStatus) {
		this.memId = memId;
		this.memberStatus = memStatus;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemNick() {
		return memNick;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public String getMemberMbti() {
		return memberMbti;
	}

	public String getMemberTt() {
		return memberTt;
	}

	public Timestamp getMemRegDate() {
		return memRegDate;
	}

	public Timestamp getMemUpdate() {
		return memUpdate;
	}

	public String getTtImg() {
		return ttImg;
	}

	public Timestamp getMemberBanStart() {
		return memberBanStart;
	}

	public Timestamp getMemberBanEnd() {
		return memberBanEnd;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memNick=" + memNick + ", memEmail=" + memEmail + ", memberStatus="
				+ memberStatus + ", memberMbti=" + memberMbti + ", memberTt=" + memberTt + ", memRegDate=" + memRegDate
				+ ", memUpdate=" + memUpdate + ", ttImg=" + ttImg + ", memberBanStart=" + memberBanStart
				+ ", memberBanEnd=" + memberBanEnd + "]";
	}

}
