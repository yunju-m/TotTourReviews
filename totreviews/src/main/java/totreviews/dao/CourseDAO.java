package totreviews.dao;

import java.util.List;

import totreviews.domain.CourseDTO;
import totreviews.domain.CourseResDTO;

public interface CourseDAO {

	CourseDTO getCourseById(String courseId);

	List<CourseDTO> getCourseByTripId(int tripId);

	CourseResDTO getCourseDetailsById(String dcourseType, int dcourseId);

}
