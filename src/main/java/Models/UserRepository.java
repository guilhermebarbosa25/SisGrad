package Models;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import Models.Usuario;
@Repository
public interface UserRepository extends PagingAndSortingRepository<Usuario,Integer>{
		public Iterable<Usuario> findByNomeContainingIgnoreCase(String parteNome);
		public Optional<Usuario> findByEmailIgnoreCase(String email);
}
