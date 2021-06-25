package Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Models.UserRepository;
import Models.Usuario;

@Controller
public class loginController {
	
	@Autowired
	private UserRepository repositorio;
	

	@PostMapping(path="/geral/login/try")
	public  String TryLogin(String email, String senha, final RedirectAttributes redirectattributes){
		Optional<Usuario> usr = repositorio.findByEmailIgnoreCase(email);
		if((usr.get().senha.equals(new String(senha)))  && (usr.get().email.equals(new String(email)))) {
			redirectattributes.addFlashAttribute("message","Sucesso");
			return "redirect:/administrativo/menu.html";
		}
		redirectattributes.addFlashAttribute("message","Sucesso");
		return "redirect:/geral/login.html";
	}
	
	@GetMapping(path="/geral/login/back")
	public  String VoltarNewUser(final RedirectAttributes redirectattributes){
		return "redirect:/geral/index.html";
	}

}
