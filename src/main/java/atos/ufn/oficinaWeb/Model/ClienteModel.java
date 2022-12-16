package atos.ufn.oficinaWeb.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientepf")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = false)
	private String cpf;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private Integer cel;

	@Column
	private Integer tel;

	@ManyToMany(mappedBy = "clientepf", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<CarroModel> carro = new HashSet<>();

	public ClienteModel(String cpf, String nome, String endereco, Integer cel, Integer tel) {
		super();

		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.cel = cel;
		this.tel = tel;

	}

	public Set<CarroModel> getCarro() {
		return carro;
	}

	public void setCarro(Set<CarroModel> carro) {
		this.carro = carro;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClienteModel() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getCel() {
		return cel;
	}

	public void setCel(Integer cel) {
		this.cel = cel;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

}
