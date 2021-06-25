package Models;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matricula;
	public String email;
	public String senha;
	public String cpf;
	public String nome;
	public String datanasc;
	public String usertype;
	
	public Usuario() {};
	public Usuario(String email, String cpf, String nome, String datanasc, String usertype) {
		this.email = email;
		this.usertype = usertype;
		PasswordGen();
		this.cpf = cpf;
		this.nome = nome;
		this.datanasc = datanasc;
	}

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
		return !cpf.isBlank() && !nome.isBlank() && !email.isBlank();
	}
	
	
	
	
}
