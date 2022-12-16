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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mecanico")
public class MecanicoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String idoficina;

	@Column(nullable = false, unique = true)
	private String cpf;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cargo;

	@ManyToOne
	private OficinaModel oficina;

	@ManyToMany(mappedBy = "mecanico", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<ServicosModel> servico = new HashSet<>();

	public MecanicoModel(String idoficina, String cpf, String nome, String cargo) {
		super();
		this.idoficina = idoficina;
		this.cpf = cpf;
		this.nome = nome;
		this.cargo = cargo;
	}

	public MecanicoModel() {

	}

	public OficinaModel getOficina() {
		return oficina;
	}

	public void setOficina(OficinaModel oficina) {
		this.oficina = oficina;
	}

	public Set<ServicosModel> getServico() {
		return servico;
	}

	public void setServico(Set<ServicosModel> servico) {
		this.servico = servico;
	}

	public Set<ServicosModel> getservico() {
		return servico;
	}

	public void setservico(Set<ServicosModel> servico) {
		this.servico = servico;
	}

	public String getIdoficina() {
		return idoficina;
	}

	public void setIdoficina(String idoficina) {
		this.idoficina = idoficina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdOficina() {
		return idoficina;
	}

	public String getIdOfInteger() {
		return idoficina;
	}

	public void setIdOficina(String idOficina) {
		this.idoficina = idOficina;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
