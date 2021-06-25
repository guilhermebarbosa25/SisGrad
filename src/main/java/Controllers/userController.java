package Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
		Optional<Usuario> other = repositorio.findByEmailIgnoreCase(usr.email);
		Optional<Usuario> another = repositorio.findByEmailIgnoreCase(usr.cpf);
		if(other.isPresent() || another.isPresent() || !usr.isValid())
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

}
