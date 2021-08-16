package Models;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import Models.Curso;

@Repository
public interface CursoRepository extends PagingAndSortingRepository<Curso,Integer>, QueryByExampleExecutor<Curso>{

	Optional<Curso> findByNomeAndTurnoIgnoreCase(String nome, String turno);

	Optional<Curso> findByNome(String nome);

	Optional<Curso> findByNomeAndTurno(String nome, String turno);
}
