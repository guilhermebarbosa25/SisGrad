package Models;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface Curso_DisciplinaRepository extends PagingAndSortingRepository<Curso_Disciplina,Integer>, QueryByExampleExecutor<Curso_Disciplina> {

}
