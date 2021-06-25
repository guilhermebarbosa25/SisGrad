package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class subMenuAdmController {
	@GetMapping(path="/menuAdm/mngUsuarios/newUser")
	public  String GoNewUsuarios(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/newUser.html";
	}
	
	@GetMapping(path="/menuAdm/mngUsuarios/viewUser")
	public  String GoViewUsuarios(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/viewUser.html";
	}
	
	@GetMapping(path="/menuAdm/mngUsuarios/editUser")
	public  String GoEditUsuarios(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/editUser.html";
	}
	
	@GetMapping(path="/menuAdm/mngUsuarios/delUser")
	public  String GoDelUsuarios(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/delUser.html";
	}
	
	@GetMapping(path="/menuAdm/mngUsuarios/voltar")
	public  String GoBack(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/menu.html";
	}
}
