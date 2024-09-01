package totreviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import totreviews.domain.CourseDTO;
import totreviews.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/{courseId}")
	@ResponseBody
	public CourseDTO getCourseById(@PathVariable("courseId") String courseId) {
		return courseService.getCourseById(courseId);
	}

}
