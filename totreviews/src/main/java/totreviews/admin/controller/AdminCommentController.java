package totreviews.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import totreviews.admin.service.AdminCommentService;
import totreviews.util.ResponseUtil;

@Controller
@RequestMapping("/admin/comment/{boardId}")
public class AdminCommentController {

	@Autowired
	private AdminCommentService adminCommentService;

	// 댓글 상태 업데이트 처리
	@PostMapping("/{status}")
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
