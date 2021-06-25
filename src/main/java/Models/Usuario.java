package Models;
import java.nio.charset.Charset;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

@Entity
public class Usuario {
	@NotBlank
	@Email
	public String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String matricula;
	public String senha;
	@NotBlank
	public String cpf;
	@NotBlank
	public String nome;
	@NotBlank
	@Past
	public String datanasc;
	
	
	public Usuario(@NotBlank @Email String email, @NotBlank String cpf, @NotBlank String nome,
			@NotBlank @Past String datanasc) {
		super();
		this.email = email;
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
		byte[] array = new byte[7];
		new Random().nextBytes(array);
		this.senha =  new String(array,Charset.forName("UTF-8"));
	}
	
	
	
	
}
