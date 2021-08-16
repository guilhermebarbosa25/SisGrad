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
	
	
	
	@GetMapping(path="/menuAdm/mngCursos/newCurso")
	public String GoNewCursos(final RedirectAttributes redirectattributes) {
		return "redirect:/administrativo/mngCursos/newCurso.html";
	}
	@GetMapping(path="/menuAdm/mngCursos/viewCurso")
	public String GoViewCursos(final RedirectAttributes redirectattributes) {
		return "redirect:/administrativo/mngCursos/viewCurso.html";
	}
	
	
	
	@GetMapping(path="/menuAdm/mngDisciplinas/newDisciplina")
	public String GoNewDisciplinas(final RedirectAttributes redirectattributes) {
		return "redirect:/administrativo/mngDisciplinas/newDisciplina.html";
	}
	@GetMapping(path="/menuAdm/mngDisciplinas/viewCurso")
	public String GoViewDisciplinas(final RedirectAttributes redirectattributes) {
		return "redirect:/administrativo/mngDisciplinas/viewDisciplina.html";
	}
}
