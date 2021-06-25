package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class indexController {
	@GetMapping(path="/geral/index")
	public  String GoLogin(final RedirectAttributes redirectattributes){
		redirectattributes.addFlashAttribute("message","Sucesso");
		return "redirect:/geral/login.html";
	}
}
