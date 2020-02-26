package curso.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javassist.SerialVersionUID;

@Entity
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "O Nome nao pode ser nulo...")
	@NotEmpty(message = "O nome nao pode ficar em branco...")
	private String nome;
	
	@NotNull(message = "O Sobrenome nao pode ser nulo...")
	@NotEmpty(message = "Sobrenome nao pode ficar vazio...")
	private String sobrenome;
	
	@Min(value = 18, message = "Idade insuficiente...")
	private int idade;
	
	@OneToMany(mappedBy="pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Telefone> telefoens;
	
	
	public void setTelefoens(List<Telefone> telefoens) {
		this.telefoens = telefoens;
	}
	
	public List<Telefone> getTelefoens() {
		return telefoens;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getIdade() {
		return idade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	

}
