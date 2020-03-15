package jp.co.tc.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashController {
	@RequestMapping("/dashboard")
	public String getLogin(Model model) {
		return "/dashboard";
	}

	/*@PostMapping("/dashboard")
	public String postLogin(Model model) {
		return "redirect:/dashboard";
	}*/
}
