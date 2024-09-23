package totreviews.admin.controller;

import static totreviews.common.Constants.PAGE_ADMIN_TREVIEW_COMMENT;

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

import totreviews.admin.service.AdminCommentService;
import totreviews.common.page.PageReqDTO;
import totreviews.common.page.PageResDTO;
import totreviews.domain.CommentVO;
import totreviews.util.ResponseUtil;

@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {

	@Autowired
	private AdminCommentService adminCommentService;

	// 게시물 관리 화면 이동
	@GetMapping("/{page}")
	public String showAdminComment(@ModelAttribute PageReqDTO pageReqDTO, Model model) {
		PageResDTO<CommentVO> pagination = adminCommentService.findCommentListWithPaging(pageReqDTO);

		model.addAttribute("pagination", pagination);

		return PAGE_ADMIN_TREVIEW_COMMENT;
	}

	// 댓글 상태 업데이트 처리
	@PostMapping("/{boardId}/{status}")
	public ResponseEntity<Map<String, String>> updateCommentStatus(@PathVariable String status,
			@RequestBody List<Integer> trevcIds) {
		try {
			adminCommentService.updateCommentStatus(status, trevcIds);

			return ResponseUtil.createTReviewResponse("댓글 상태가 업데이트되었습니다.");
		} catch (IllegalStateException e) {
			return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
		}

	}

}
