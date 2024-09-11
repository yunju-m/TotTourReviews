package totreviews.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import totreviews.domain.CommentReqDTO;
import totreviews.service.CommentService;

@Controller
@RequestMapping("{boardId}/{postId}/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/add")
	public String addComment(@PathVariable("boardId") String boardId, @PathVariable("postId") int postId,
			@ModelAttribute CommentReqDTO commentReqDTO, Model model) {
		commentService.insertComment(boardId, postId, commentReqDTO);

		// 원래 페이지로 리다이렉트
		return "redirect:/review/" + boardId + "/detail/" + postId;
	}

	@PostMapping(value = "/edit/{commentId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, String>> editComment(@PathVariable("commentId") int commentId,
			@RequestParam("content") String content) {
		commentService.editComment(commentId, content);

		return createCommentResponse("댓글 수정이 완료되었습니다.", commentId);
	}

	@GetMapping(value = "/delete/{commentId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, String>> deleteComment(@PathVariable("commentId") int commentId) {
		commentService.deleteComment(commentId);

		return createCommentResponse("댓글이 삭제되었습니다.", commentId);
	}

	@GetMapping(value = "/report/{commentId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, String>> reportComment(@PathVariable("commentId") int commentId) {
		commentService.reportComment(commentId);
		Map<String, String> response = new HashMap<>();
		response.put("message", "신고가 접수되었습니다.");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// 댓글 공통 응답 메소드
	private ResponseEntity<Map<String, String>> createCommentResponse(String message, int commentId) {
		String updatedDate = commentService.getUpdateDate(commentId);

		Map<String, String> response = new HashMap<>();
		response.put("message", message);
		response.put("updatedDate", updatedDate);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
