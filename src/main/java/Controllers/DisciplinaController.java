package Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Models.Disciplina;
import Models.DisciplinaRepository;

@Controller
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository repositorio;
	
	@Transactional
	@PostMapping(path="/menuAdm/mngDisciplinas/newDisciplina/post")
	public String newCurso(Disciplina disc, final RedirectAttributes redirectattributes) {
		Optional<Disciplina> mesmoNome = repositorio.findByNome(disc.nome);
		if(mesmoNome.isPresent() || !disc.isValid())	{
			return "redirect:/administrativo/mngDisciplinas/newDisciplinaDeny.html";
		}
		repositorio.save(disc);
		return "redirect:/administrativo/mngDisciplinas/Result.html";
	}
	
	
	
	
	@GetMapping(path="/menuAdm/mngDisciplinas/newDisciplina/voltar")
	public  String VoltarNewCurso(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngDisciplinas/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngDisciplinas/voltar")
	public  String VoltarParaSubMenu(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngDisciplinas/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngDisciplinas/viewDisciplinas/Lista/voltar")
	public  String VoltarViewCurso(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngDisciplinas/viewDisciplina.html";
	}
	
}
