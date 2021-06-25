package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class menuAdmController {
	@GetMapping(path="/menuAdm/GerenciarUsuarios")
	public  String GoMngUsuarios(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/submenu.html";
	}
	@GetMapping(path="/menuAdm/GerenciarCursos")
	public  String GoMngCursos(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngCursos/submenu.html";
	}
	@GetMapping(path="/menuAdm/GerenciarDisciplinas")
	public  String GoMngDisciplinas(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngDisciplinas/submenu.html";
	}
	@GetMapping(path="/menuAdm/GerenciarTurmas")
	public  String GoMngTurmas(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngTurmas/submenu.html";
	}
	@GetMapping(path="/menuAdm/GerenciarAlunos")
	public  String GoMngAlunos(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngAlunos/submenu.html";
	}
	@GetMapping(path="/menuAdm/GerarRelatorios")
	public  String GerarRelatorios(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/gerarRelatorios/submenu.html";
	}
	@GetMapping(path="/menuAdm/logoff")
	public  String logoff(final RedirectAttributes redirectattributes){
		return "redirect:/geral/index.html";
	}	

}
