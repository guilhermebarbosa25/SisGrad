package Controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Models.Curso;
import Models.CursoRepository;
import Models.Curso_Disciplina;
import Models.Curso_DisciplinaRepository;
import Models.Disciplina;
import Models.DisciplinaRepository;

@Controller
public class CursoController {
	@Autowired
	private CursoRepository repositorio;
	
	@Autowired
	private Curso_DisciplinaRepository c_dRepositorio;
	
	@Autowired
	private DisciplinaRepository disciplinarepository;
	
	@Transactional
	@PostMapping(path="/menuAdm/mngCursos/newCurso/post")
	public String newCurso(Curso curso, final RedirectAttributes redirectattributes) {
		Optional<Curso> mesmoNomeeTurno = repositorio.findByNomeAndTurnoIgnoreCase(curso.nome,curso.turno);

		if(mesmoNomeeTurno.isPresent() || !curso.isValid())	{
			return "redirect:/administrativo/mngCursos/newCursoDeny.html";
		}
		repositorio.save(curso);
		return "redirect:/administrativo/mngCursos/Result.html";
	}
	
	@GetMapping(path="/menuAdm/mngCursos/addDisciplina/{nome}&{turno}")
	public String addDisciplinaCurso(@PathVariable String nome,@PathVariable String turno, Model model){
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("qtdPeriodos").withIgnoreNullValues();
		Curso curso = new Curso();
		curso.nome=nome;
		curso.turno=turno;
		Example<Curso> example = Example.of(curso,matcher);
		Iterable<Curso> search = repositorio.findAll(example);
		model.addAttribute("cursos",search);
		Iterable<Disciplina> search2 = disciplinarepository.findAll();
		model.addAttribute("disciplinas",search2);
		return "addCursoDisciplina";
	}
	@Transactional
	@PostMapping(path="/menuAdm/mngCursos/Curso_Disc/post")
	public String addCurso_Disc(String Nomecurso, String Turno,String codigo, Integer periodo, final RedirectAttributes redirectattributes) {
		Optional<Curso> curso = repositorio.findByNomeAndTurnoIgnoreCase(Nomecurso,Turno);
		Optional<Disciplina> disc = disciplinarepository.findByCodigo(codigo);
		
		if(curso.isPresent()&&disc.isPresent()){
			
			Curso_Disciplina c_d = new Curso_Disciplina(curso.get(),disc.get());
			c_d.setPeriodo(periodo);
			curso.get().programa.add(c_d);
			disc.get().cursos.add(c_d);
			c_dRepositorio.save(c_d);
			curso.get().getPrograma();
		}
				
		return "redirect:/administrativo/mngCursos/Result.html";
	}
	
	@GetMapping(path="/menuAdm/mngCursos/viewCurso/try")
	public String viewCurso(String nome, String turno, Model model){
			Curso curso = new Curso();
			if(!nome.isBlank()) {
				curso.setNome(nome);
			}	
			if(turno!=null && !turno.isBlank()) {
				curso.setTurno(turno);
			}	

			ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("qtdPeriodos").withIgnoreNullValues();

			Example<Curso> example = Example.of(curso,matcher);
			Iterable<Curso> search = repositorio.findAll(example);
			model.addAttribute("cursos",search);
			return "viewCursoResult";
	}	
	
	@GetMapping(path="/menuAdm/mngCursos/viewPrograma/{nome}&{turno}")
	public String viewProgramaCurso(String nome, String turno, Model model){
			Curso curso = new Curso();
			if(nome!=null && !nome.isBlank()) {
				curso.setNome(nome);
			}	
			if(turno!=null && !turno.isBlank()) {
				curso.setTurno(turno);
			}	

			ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("qtdPeriodos").withIgnoreNullValues();
			Example<Curso> example = Example.of(curso,matcher);
			Iterable<Curso> search = repositorio.findAll(example);
			search.forEach(e->{e.getPrograma();model.addAttribute("disciplinas",e.programa);});
			return "viewProgramaCurso";
	}
	
	@Transactional
	@GetMapping(path="/menuAdm/mngCursos/delCurso/try/{nome}&{turno}")
	public String DelCurso(@PathVariable String nome,@PathVariable String turno,final RedirectAttributes redirectattributes,HttpServletRequest request)	{

		if(nome==null)
			nome="";
		if (turno==null)
			turno="";
		Optional<Curso> curso = repositorio.findByNomeAndTurno(nome,turno);
		try {
			repositorio.delete(curso.get());
		}catch(Exception e){
			return "redirect:/administrativo/mngCursos/viewCurso.html";}
		return "redirect:/administrativo/mngCurso/Result.html";
	}
	
	@GetMapping(path="/menuAdm/mngCursos/editCurso/{nome}&{turno}")
	public String EditCurso(@PathVariable String nome,@PathVariable String turno,final RedirectAttributes redirectattributes,HttpServletRequest request)	{

		if(nome==null)
			nome="";
		if (turno==null)
			turno="";
		Optional<Curso> curso = repositorio.findByNomeAndTurno(nome,turno);
		try {
			repositorio.delete(curso.get());
		}catch(Exception e){
			return "redirect:/administrativo/mngCursos/viewCurso.html";}
		return "redirect:/administrativo/mngCurso/Result.html";
	}
	
	@GetMapping(path="/menuAdm/mngCursos/newCurso/voltar")
	public  String VoltarNewCurso(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngCursos/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngCurso/voltar")
	public  String VoltarParaSubMenu(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngCursos/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngCursos/viewCurso/Lista/voltar")
	public  String VoltarViewCurso(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngCursos/viewCurso.html";
	}
}
