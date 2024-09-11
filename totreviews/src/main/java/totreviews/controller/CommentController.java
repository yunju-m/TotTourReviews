package totreviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ResponseEntity<String> editComment(@PathVariable("commentId") int commentId,
			@RequestParam("content") String content) {
		commentService.editComment(commentId, content);

		return ResponseEntity.ok("댓글 수정이 완료되었습니다.");
	}

	@PostMapping(value = "/delete/{commentId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> deleteComment(@PathVariable("commentId") int commentId) {
		commentService.deleteComment(commentId);

		return ResponseEntity.ok("댓글이 삭제되었습니다.");
	}

}
