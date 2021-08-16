package Models;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @GenericGenerator(
        name = "curso_seq", 
        strategy = "Models.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "01"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "C"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") 
            })
	public String id;
	public String nome;
	public int qtdPeriodos;
	public String turno;
	
	@OneToMany(mappedBy="curso")
	public List<Curso_Disciplina> programa; 
	
	public void addDisciplina(Disciplina disc,int periodo) {
		Curso_Disciplina c_d = new Curso_Disciplina(this,disc);
		c_d.setPeriodo(periodo);
		programa.add(c_d);
	}
	
	public void removeDisciplina(Curso_Disciplina c_d) {
		programa.remove(c_d);
	}
	public void addPrerequisitoDisciplina(Curso_Disciplina c_d) {
		
	}
	public void removePrerequisitoDisciplina(Curso_Disciplina c_d) {
		
	}
	public List<Curso_Disciplina> getPrograma() {
		Collections.sort(programa,new Comparator<Curso_Disciplina>() {
			@Override
			public int compare(Curso_Disciplina a, Curso_Disciplina b) {
				if(a.getPeriodo()==b.getPeriodo())
					return 0;
				if(a.getPeriodo()>b.getPeriodo())
					return 1;
				else return -1;
			}
		});
		return programa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public int getQtdPeriodos() {
		return qtdPeriodos;
	}
	public void setQtdPeriodos(int qtdPeriodos) {
		this.qtdPeriodos = qtdPeriodos;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean isValid() {
		if(!nome.isBlank())
			if(!turno.isBlank())
				if(!(qtdPeriodos<6))
					if(!(qtdPeriodos>12))
						return true;
		return false;
	}
}
