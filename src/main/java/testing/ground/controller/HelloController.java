package testing.ground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class HelloController {
	
	@RequestMapping
	public String printWelcome(Model model){
		model.addAttribute("message", "Spring 3 MVC Hello World Example");
		return "hello";
	}
}
