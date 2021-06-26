package Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "redirect:/administrativo/mngUsuarios/newUserResult.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/newUser/voltar")
	public  String VoltarNewUser(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/submenu.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/newUserResult/voltar")
	public  String VoltarSucessoNewUser(final RedirectAttributes redirectattributes){
		return "redirect:/administrativo/mngUsuarios/newUser.html";
	}
	@GetMapping(path="/menuAdm/mngUsuarios/viewUser/try")
	public String viewUser(String matricula, String cpf, String email, String usertype, Model model){
		
			Usuario usr = new Usuario();
			if(matricula.isBlank()&&cpf.isBlank()&&email.isBlank())
				return "redirect:/administrativo/mngUsuarios/viewUser.html";
						
			if(!matricula.isBlank()) {
				usr.setMatricula(matricula);
			}
			if(!cpf.isBlank()) {
				usr.setCpf(cpf);
			}
			if(!email.isBlank()) {
				usr.setEmail(email);
			}
			if(!usertype.isBlank()) {
				usr.setUsertype(usertype);
			}
			
			Example<Usuario> example = Example.of(usr);
			Optional<Usuario> search = repositorio.findOne(example);
			model.addAttribute("usuario",search.get());
			return "viewUserResult";
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
