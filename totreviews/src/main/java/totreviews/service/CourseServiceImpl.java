package totreviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import totreviews.dao.CourseDAO;
import totreviews.domain.CourseDTO;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	@Override
	public CourseDTO getCourseById(String courseId) {
		return courseDAO.getCourseById(courseId);
	}

}
