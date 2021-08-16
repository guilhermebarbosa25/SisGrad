package Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;




@Entity
public class Curso_Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cd_seq")
    @GenericGenerator(
        name = "cd_seq", 
        strategy = "Models.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "01"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CD"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d") 
            })
	public String id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="curso_id", insertable=true, updatable=false)
	private Curso curso;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="disciplina_id",insertable=true, updatable=false)
	private Disciplina disciplina;
	
	private int periodo;

	public Curso_Disciplina(Curso c, Disciplina d) {
		this.curso = c;
		this.disciplina = d;
	}
	public Curso_Disciplina() {
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
	
}
