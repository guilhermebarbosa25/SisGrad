package Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping(path="/goal")
	public void getAluno(@RequestParam(name="id") String nomeAluno){
		
	}
}
