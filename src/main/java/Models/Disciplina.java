package Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq")
    @GenericGenerator(
        name = "disciplina_seq", 
        strategy = "Models.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "01"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "D"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") 
            })
	public String id;
	public String nome;
	public String descricao;
	public String codigo;
	public int cargaHoraria;

	@OneToMany(mappedBy="disciplina")
	public List<Curso_Disciplina> cursos;

	//@OneToMany(mappedBy="turma")
	//public List<Disciplina_Turmas> turmas;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getId() {
		return id;
	}
	
	public boolean isValid() {
		if(!nome.isBlank())
			if(!descricao.isBlank())
				if(cargaHoraria!=0)
					if(codigo.matches("([a-zA-Z]{3})+(-)+([0-9]{3})")) 
						return true;
		return false;	
					
	}

	
	
	
	
}
