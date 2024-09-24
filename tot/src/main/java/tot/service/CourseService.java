package tot.service;

import java.util.List;

import tot.domain.CourseDTO;

public interface CourseService {

	CourseDTO getCourseById(String courseId);

	List<CourseDTO> getCourseDetailsByTripId(int tripId);

}
