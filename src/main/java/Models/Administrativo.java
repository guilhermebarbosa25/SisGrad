package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

@Entity
public class Administrativo extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String matricula;
	private String curso;

	public Administrativo(@NotBlank @Email String email, @NotBlank String senha, @NotBlank String cpf, @NotBlank String nome,
			@NotBlank @Past String datanasc, String curso) {
		super(email,  senha,  cpf,  nome, datanasc);
		this.curso = curso;
	}
	
	
 
}
