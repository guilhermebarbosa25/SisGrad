package Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/newUser")
public class Controller {
	@PostMapping
	public String PostUser(){
		return "Postado";
	}
}
