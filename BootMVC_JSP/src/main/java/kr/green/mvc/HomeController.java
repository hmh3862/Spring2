package kr.green.mvc;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("serverTime", LocalDateTime.now().toString());
		return "home";
	}
}
