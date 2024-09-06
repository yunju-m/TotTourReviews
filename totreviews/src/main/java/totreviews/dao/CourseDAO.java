package totreviews.dao;

import java.util.List;

import totreviews.domain.CourseDTO;
import totreviews.domain.CourseResDTO;

public interface CourseDAO {

	CourseDTO getCourseById(String courseId);

	List<CourseDTO> getCourseByMemId(String memId);

	CourseResDTO getCourseDetailsById(String dcourseType, int dcourseId);

}
