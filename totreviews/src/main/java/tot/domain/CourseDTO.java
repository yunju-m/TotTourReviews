package tot.domain;

import java.sql.Timestamp;
import java.util.List;

public class CourseDTO {

	private int courId; // 코스 아이디
	private int tripId; // 여행 아이디
	private String areaCode; // 지역 코드
	private String dCourse; // 하루 코스 설명
	private List<CourseResDTO> courseDetail; // 하루 여행 상세 코스
	private Timestamp courRegdate; // 등록 일시
	private Timestamp courUpdate; // 수정 일시

	public CourseDTO() {
	}

	public CourseDTO(int courId, int tripId, String areaCode, String dCourse, List<CourseResDTO> courseDetail,
			Timestamp courRegdate, Timestamp courUpdate) {
		this.courId = courId;
		this.tripId = tripId;
		this.areaCode = areaCode;
		this.dCourse = dCourse;
		this.courseDetail = courseDetail;
		this.courRegdate = courRegdate;
		this.courUpdate = courUpdate;
	}

	public int getCourId() {
		return courId;
	}

	public int getTripId() {
		return tripId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getdCourse() {
		return dCourse;
	}

	public List<CourseResDTO> getCourseDetail() {
		return courseDetail;
	}

	public Timestamp getCourRegdate() {
		return courRegdate;
	}

	public Timestamp getCourUpdate() {
		return courUpdate;
	}

	public void setCourId(int courId) {
		this.courId = courId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setdCourse(String dCourse) {
		this.dCourse = dCourse;
	}

	public void setCourseDetail(List<CourseResDTO> courseDetail) {
		this.courseDetail = courseDetail;
	}

	public void setCourRegdate(Timestamp courRegdate) {
		this.courRegdate = courRegdate;
	}

	public void setCourUpdate(Timestamp courUpdate) {
		this.courUpdate = courUpdate;
	}

	@Override
	public String toString() {
		return "CourseDTO [courId=" + courId + ", tripId=" + tripId + ", areaCode=" + areaCode + ", dCourse=" + dCourse
				+ ", courseDetail=" + courseDetail + ", courRegdate=" + courRegdate + ", courUpdate=" + courUpdate
				+ "]";
	}

}
