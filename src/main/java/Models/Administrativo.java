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
	private String departamento;

	public Administrativo(@NotBlank @Email String email, @NotBlank String cpf, @NotBlank String nome,
			@NotBlank @Past String datanasc, String departamento) {
		super(email,  cpf,  nome, datanasc);
		this.departamento = departamento;
	}
	
 
}
