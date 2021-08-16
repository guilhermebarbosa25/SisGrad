package Models;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import Models.Usuario;
@Repository
public interface UserRepository 
extends PagingAndSortingRepository<Usuario,Integer>, QueryByExampleExecutor<Usuario>{
		public Iterable<Usuario> findByNomeContainingIgnoreCase(String parteNome);
		public Iterable<Usuario> findByUsertype(String parteNome);
		public Optional<Usuario> findByCpf(String parteNome);
		public Optional<Usuario> findByEmailIgnoreCase(String email);
		public Optional<Usuario> findByEmailAndCpfAndUsertype(String email, String cpf, String usertype);
		public Optional<Usuario> findByEmailOrCpfOrUsertype(String email, String cpf,String usertype);
		public Optional<Usuario> findByEmailOrCpfOrMatricula(String email, String cpf, int matricula);
		public Optional<Usuario> findByMatricula(String matricula);
}
