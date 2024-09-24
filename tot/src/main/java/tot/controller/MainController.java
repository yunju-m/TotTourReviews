package tot.controller;

import static tot.common.Constants.MAIN;
import static tot.common.Constants.PAGE_LOGIN;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String main() {
		return MAIN;
	}

	@GetMapping("/login")
	public String login() {
		return PAGE_LOGIN;
	}

}
