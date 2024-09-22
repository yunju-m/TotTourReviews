package totreviews.admin.controller;

import static totreviews.common.Constants.PAGE_ADMIN_TREVIEW;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import totreviews.admin.service.AdminTReviewService;
import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.TReviewResDTO;
import totreviews.util.ResponseUtil;

@Controller
@RequestMapping("/admin/review/{boardId}")
public class AdminTReviewController {

	@Autowired
	private AdminTReviewService adminTreviewService;

	@GetMapping("/{page}")
	public String showAdminTReview(@PathVariable String boardId, @ModelAttribute PageReqDTO pageReqDTO, Model model) {
		PageResDTO<TReviewResDTO> pagination = adminTreviewService.findTReviewListWithPaging(pageReqDTO, boardId);

		model.addAttribute("boardId", boardId);
		model.addAttribute("pagination", pagination);

		return PAGE_ADMIN_TREVIEW;
	}

	@PostMapping("/{status}")
	public ResponseEntity<Map<String, String>> updateTReviewStatus(@PathVariable String status,
			@RequestBody List<Integer> trevIds) {
		adminTreviewService.updateTReviewStatus(status, trevIds);

		return ResponseUtil.createTReviewResponse("게시물 상태가 업데이트되었습니다.");
	}

}
