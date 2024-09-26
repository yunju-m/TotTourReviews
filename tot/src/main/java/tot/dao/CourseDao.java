package tot.dao;

import java.util.List;

import tot.domain.CourseDTO;
import tot.domain.CourseResDTO;

public interface CourseDao {

	CourseDTO getCourseById(String courseId);

	List<CourseDTO> getCourseByTripId(int tripId);

	CourseResDTO getCourseDetailsById(String dcourseType, int dcourseId);

}
