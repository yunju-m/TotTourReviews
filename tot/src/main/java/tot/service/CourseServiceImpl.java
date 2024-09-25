package tot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tot.dao.CourseDAO;
import tot.domain.CourseDTO;
import tot.domain.CourseResDTO;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseDAO courseDAO;

	public CourseServiceImpl(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public CourseDTO getCourseById(String courseId) {
		return courseDAO.getCourseById(courseId);
	}

	@Override
	public List<CourseDTO> getCourseDetailsByTripId(int tripId) {
		List<CourseDTO> courseList = courseDAO.getCourseByTripId(tripId);
		courseList.forEach(this::setCourseDetails);
		return courseList;
	}

	/**
	 * 주어진 코스에 대한 세부 정보를 설정합니다.
	 *
	 * @param course 세부 정보를 설정할 코스
	 */
	private void setCourseDetails(CourseDTO course) {
		List<CourseResDTO> courseDetails = new ArrayList<>();
		String[] courseTypes = course.getdCourse().split(",");

		for (String courseType : courseTypes) {
			CourseResDTO courseDetail = getCourseDetail(courseType);
			courseDetails.add(courseDetail);
		}

		course.setCourseDetail(courseDetails);
	}

	/**
	 * 유형과 ID에 따라 코스 세부 정보를 조회합니다.
	 *
	 * @param courseType 코스 유형과 ID를 포함하는 문자열
	 * @return 해당 코스의 세부 정보
	 */
	private CourseResDTO getCourseDetail(String courseType) {
		String[] typeAndId = courseType.split(":");
		String type = typeAndId[0];
		int id = Integer.parseInt(typeAndId[1]);
		return courseDAO.getCourseDetailsById(type, id);
	}
}
