package jp.co.tc.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String getLogin(Model model) {
		return "login";
	}

	@PostMapping("/login")
	public String postLogin(Model model) {
		return "redirect:/dashboard";
	}

}
