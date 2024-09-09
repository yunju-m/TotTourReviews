package totreviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
