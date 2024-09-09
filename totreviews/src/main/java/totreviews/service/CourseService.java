package totreviews.service;

import java.util.List;

import totreviews.domain.CourseDTO;

public interface CourseService {

	CourseDTO getCourseById(String courseId);

	List<CourseDTO> getCourseDetailsByTripId(int tripId);

}
