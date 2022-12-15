package atos.ufn.oficinaWeb.Model;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orcamento")
public class OrcamentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataentrada;

	@Column(nullable = false, unique = true)
	private Double valor;

	@OneToOne
	private OrdemServicoModel ordemservico;

	@ManyToOne
	private CarroModel carro;

	@JoinTable(name = "orcamento_servicos", joinColumns = {
			@JoinColumn(name = "orcamento_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "servicos_id", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<ServicosModel> servicos = new HashSet<>();

	public OrcamentoModel(Integer id, Date dataentrada, Double valor) {
		super();
		this.id = id;
		this.dataentrada = dataentrada;
		this.valor = valor;
	}

	public OrcamentoModel() {

	}

	public OrdemServicoModel getOrdemservico() {
		return ordemservico;
	}

	public void setOrdemservico(OrdemServicoModel ordemservico) {
		this.ordemservico = ordemservico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataentrada() {
		return dataentrada;
	}

	public void setDataentrada(Date dataentrada) {
		this.dataentrada = dataentrada;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public CarroModel getCarro() {
		return carro;
	}

	public void setCarro(CarroModel carro) {
		this.carro = carro;
	}

	public Set<ServicosModel> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicosModel> servicos) {
		this.servicos = servicos;
	}

}
