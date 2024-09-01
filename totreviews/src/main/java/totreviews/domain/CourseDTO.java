package totreviews.domain;

import java.sql.Timestamp;

public class CourseDTO {

	private String courseid; // 코스 아이디
	private int tripid; // 여행 아이디
	private String areacode; // 지역 코드
	private String dcourse; // 하루 여행 코스
	private Timestamp courregdate; // 등록일시
	private Timestamp courupdate; // 수정일시

	public CourseDTO() {
	}

	public CourseDTO(String courseid, int tripid, String areacode, String dcourse, Timestamp courregdate,
			Timestamp courupdate) {
		this.courseid = courseid;
		this.tripid = tripid;
		this.areacode = areacode;
		this.dcourse = dcourse;
		this.courregdate = courregdate;
		this.courupdate = courupdate;
	}

	public String getCourseid() {
		return courseid;
	}

	public int getTripid() {
		return tripid;
	}

	public String getAreacode() {
		return areacode;
	}

	public String getDcourse() {
		return dcourse;
	}

	public Timestamp getCourregdate() {
		return courregdate;
	}

	public Timestamp getCourupdate() {
		return courupdate;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public void setDcourse(String dcourse) {
		this.dcourse = dcourse;
	}

	public void setCourregdate(Timestamp courregdate) {
		this.courregdate = courregdate;
	}

	public void setCourupdate(Timestamp courupdate) {
		this.courupdate = courupdate;
	}

	@Override
	public String toString() {
		return "CourseDTO [courseid=" + courseid + ", tripid=" + tripid + ", areacode=" + areacode + ", dcourse="
				+ dcourse + ", courregdate=" + courregdate + ", courupdate=" + courupdate + "]";
	}

}
