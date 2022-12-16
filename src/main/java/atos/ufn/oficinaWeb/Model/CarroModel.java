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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
public class CarroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String placa;

	@Column(nullable = false)
	private String modelo;

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false)
	private String cor;

	@Column(nullable = false)
	private String categoria;

	@JoinTable(name = "clientepf_carro", joinColumns = {
			@JoinColumn(name = "carro_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "clientepf_id", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<ClienteModel> clientepf = new HashSet<>();
	
	
	@JoinTable(name = "clientepj_carro", joinColumns = {
			@JoinColumn(name = "carro_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "clientepj_id", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<ClienteJuridicoModel> clientepj = new HashSet<>();

	public CarroModel(String placa, String modelo, String marca, String cor, String categoria) {
		super();

		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.categoria = categoria;
	}

	public CarroModel() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set<ClienteModel> getClientepf() {
		return clientepf;
	}

	public void setClientepf(Set<ClienteModel> clientepf) {
		this.clientepf = clientepf;
	}

	public Set<ClienteJuridicoModel> getClientepj() {
		return clientepj;
	}

	public void setClientepj(Set<ClienteJuridicoModel> clientepj) {
		this.clientepj = clientepj;
	}

}
