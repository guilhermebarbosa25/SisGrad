package Controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Models.UserRepository;
import Models.Usuario;

@Controller
public class userController {
	
	@Autowired
	private UserRepository repositorio;
	
	@Transactional
	@PostMapping(path="/menuAdm/mngUsuarios/newUser/post")
	public  String PostUser(Usuario usr, final RedirectAttributes redirectattributes){
		Optional<Usuario> mesmoEmail = repositorio.findByEmailIgnoreCase(usr.email);
		Optional<Usuario> mesmoCpf = repositorio.findByCpf(usr.cpf);
		if(mesmoEmail.isPresent() || mesmoCpf.isPresent() || !usr.isValid())
		{
			return "redirect:/administrativo/mngUsuarios/newUserDeny.html";
		}
		repositorio.save(usr);
		redirectattributes.addFlashAttribute("message","Sucesso");
		return "redirect:/administrativo/mngUsuarios/Result.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/newUser/voltar")
	public  String VoltarNewUser(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/newUserResult/voltar")
	public  String VoltarSucessoNewUser(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/viewUser/try")
	public String viewUser(String nome, String matricula, String cpf, String email, String usertype, Model model){
		
			Usuario usr = new Usuario();

			if(!matricula.isBlank()) {
				usr.setMatricula(matricula);
			}
			if(!cpf.isBlank()) {
				usr.setCpf(cpf);
			}
			if(!email.isBlank()) {
				usr.setEmail(email);
			}
			if(usertype!=null && !usertype.isBlank()) {
				usr.setUsertype(usertype);
			}
			if(!nome.isBlank()) {
				usr.setNome(nome);
			}		
			usr.senha=null;
			Example<Usuario> example = Example.of(usr);
			Iterable<Usuario> search = repositorio.findAll(example);
			model.addAttribute("usuarios",search);
			return "viewUserResult";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/editUser/{matricula}")
	public String editUser(@PathVariable String matricula, Model model) {
		Optional<Usuario> search = repositorio.findByMatricula(matricula);
		model.addAttribute("usuario",search);
		return "editUser";
	}
	@Transactional
	@PostMapping(path="/menuAdm/mngUsuarios/editUser/try")
	public String editUserGo(Usuario usr, final RedirectAttributes redirectattributes) {
		Usuario search = repositorio.findByMatricula(usr.matricula).get();
		search.copyFrom(usr);
		repositorio.save(search);
		return "redirect:/administrativo/mngUsuarios/Result.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/delUser/try/{matricula}")
	public String DelUser(@PathVariable String matricula,final RedirectAttributes redirectattributes,HttpServletRequest request)	{
		Optional<Usuario> usr = repositorio.findByMatricula(matricula);
		try {
			repositorio.delete(usr.get());
		}catch(Exception e){return "redirect:/administrativo/mngUsuarios/viewUser.html";}
		return "redirect:/administrativo/mngUsuarios/Result.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/viewUser/voltar")
	public String VoltarViewUser(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/viewUser/Lista/voltar")
	public String VoltarViewUserLista(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/viewUser.html";
	}
}
