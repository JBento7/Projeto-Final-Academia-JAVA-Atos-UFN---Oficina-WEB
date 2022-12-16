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
@Table(name = "clientepj")
public class ClienteJuridicoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String cnpj;
	private String inscestadual;

	@Column(nullable = false)
	private String razaosocial;
	private String endereco;
	private String email;
	private String tel;
	
	@ManyToMany(mappedBy = "clientepj", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<CarroModel> carro = new HashSet<>();

	public ClienteJuridicoModel() {

	}

	public ClienteJuridicoModel(Integer id, String cnpj, String inscestadual, String razaosocial, String endereco,
			String email, String tel) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.inscestadual = inscestadual;
		this.razaosocial = razaosocial;
		this.endereco = endereco;
		this.email = email;
		this.tel = tel;
	}
	
	

	public Set<CarroModel> getCarro() {
		return carro;
	}

	public void setCarro(Set<CarroModel> carro) {
		this.carro = carro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscestadual() {
		return inscestadual;
	}

	public void setInscestadual(String inscestadual) {
		this.inscestadual = inscestadual;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
