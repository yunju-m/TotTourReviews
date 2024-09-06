package totreviews.controller;

import static totreviews.common.Constants.PAGE_TREVIEW;
import static totreviews.common.Constants.PAGE_WRITE_TREVIEW;
import static totreviews.common.Constants.URL_ALL_TREVIEW;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.CourseDTO;
import totreviews.domain.MemberVO;
import totreviews.domain.TReviewReqDTO;
import totreviews.domain.TReviewResDTO;
import totreviews.service.CourseService;
import totreviews.service.TReviewService;

@Controller
@RequestMapping("/review/{boardId}")
public class TReviewController {

	@Autowired
	private TReviewService treviewService;

	@Autowired
	private CourseService courseService;

	// 여행 후기 화면 이동
	@GetMapping("/{page}")
	public String showTourReview(@PathVariable String boardId, @ModelAttribute PageReqDTO pageReqDTO, Model model) {
		PageResDTO<TReviewResDTO> pagination = treviewService.findTReviewListWithPaging(pageReqDTO, boardId);

		model.addAttribute("boardId", boardId);
		model.addAttribute("pagination", pagination);

		return PAGE_TREVIEW;
	}

	// 여행 후기 작성 화면 이동
	@GetMapping("/write")
	public String showTourReviewWrite(HttpSession session, Model model) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<CourseDTO> courses = courseService.getCourseDetailsByMemId(member.getMemid());

		model.addAttribute("courses", courses);

		return PAGE_WRITE_TREVIEW;
	}

	// 여행 후기 작성 처리
	@PostMapping("/write")
	public String submitTourReviewWrite(@ModelAttribute TReviewReqDTO tReviewReqDTO,
			@RequestParam(value = "reviewImage", required = false) MultipartFile[] imageFiles) {
		treviewService.insertTReview(tReviewReqDTO, imageFiles);

		return "redirect:" + URL_ALL_TREVIEW;
	}

}
