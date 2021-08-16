package SoftEng.SisGrad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Usuario;

class UnitarioUsuario {
	Usuario usr = new Usuario();
	
	@BeforeEach
	void precondicao() {
		usr.setCpf("123.456.678-09");
		usr.setEmail("a@a.a.a");
		usr.setNome("Teste Usuario Valido");
		usr.setUsertype("Administrativo");
	}
	
	@Test
	void testaUsuarioValido() {
		assertTrue(usr.isValid());
	}

	@Test
	void testaUsuarioInvalidoSemCPF() {
		usr.setCpf("");
		assertFalse(usr.isValid());
	}
	@Test
	void testaUsuarioInvalidoCPFerrado() {
		usr.setCpf("465645456456456456456456456456456465");
		assertFalse(usr.isValid());
	}
	@Test
	void testaUsuarioInvalidoSemNome() {
		usr.setNome("");
		assertFalse(usr.isValid());
	}
	@Test
	void testaUsuarioInvalidoSemEmail() {
		usr.setEmail("");
		assertFalse(usr.isValid());
	}
	@Test
	void testaUsuarioInvalidoEmailerrado() {
		usr.setEmail("sdaasdasdasdsdaasdsddasda@adsasdasdasdasd");
		assertFalse(usr.isValid());
	}
	@Test
	void testaSenha() {
		assertFalse(usr.senha.isBlank());
		assertTrue(usr.senha.length()==10);
	}
	void testamatricula() {
		assertFalse(usr.matricula.isBlank());
		assertTrue(usr.matricula.matches("U\\d{9}"));
	}
}
