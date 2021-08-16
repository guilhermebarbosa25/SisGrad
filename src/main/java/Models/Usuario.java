package Models;


import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @GenericGenerator(
        name = "user_seq", 
        strategy = "Models.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "U"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") 
            })
	public String matricula;
	public String email;
	public String senha;
	public String cpf;
	public String nome;
	public String datanasc;
	public String usertype;
	
	public void copyFrom(Usuario usr) {
		this.email= usr.email;
		this.cpf= usr.cpf;
		this.nome= usr.nome;
		this.datanasc= usr.datanasc;
		this.usertype= usr.usertype;
	}
	public Usuario() {
		PasswordGen();
	};
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public void setMatricula(String matricula) {
		this.matricula=matricula;
	}
	public String getMatricula() {
		return this.matricula;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	private void PasswordGen() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    this.senha = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	}
	
	public String toString() {
		return "\n email:"+email+
				"\n senha:"+senha+
				"\n nome:"+nome+
				"\n cpf:"+cpf+
				"\n datanasc:"+datanasc+
				"\n matricula:"+ matricula+
				"\n tipo:"+usertype;
	}
	public boolean isValid() {
		if(cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$"))
			if(!nome.isBlank())
				if(email.matches("^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$"))
					if(!usertype.isBlank())
						return true;
		return false;
	}


	
	
	
}
