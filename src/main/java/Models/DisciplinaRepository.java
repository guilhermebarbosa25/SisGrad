package Models;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import Models.Disciplina;

@Repository
public interface DisciplinaRepository extends PagingAndSortingRepository<Disciplina,Integer>, QueryByExampleExecutor<Disciplina>{

	Optional<Disciplina> findByNome(String nome);

	Optional<Disciplina> findByCodigo(String codigo);

}
