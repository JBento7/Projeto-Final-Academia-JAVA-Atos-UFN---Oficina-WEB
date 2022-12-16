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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicos")
public class ServicosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String servico;

	@JoinTable(name = "mecanico_servicos", joinColumns = {
			@JoinColumn(name = "servicos_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "mecanico_id", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<MecanicoModel> mecanico = new HashSet<>();

	@ManyToMany(mappedBy = "servicos", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<OrcamentoModel> orcamento = new HashSet<>();

	public ServicosModel() {

	}

	public ServicosModel(Integer id, String servico) {
		super();
		this.id = id;
		this.servico = servico;
	}

	public Set<OrcamentoModel> getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Set<OrcamentoModel> orcamento) {
		this.orcamento = orcamento;
	}

	public Set<MecanicoModel> getMecanico() {
		return mecanico;
	}

	public void setMecanico(Set<MecanicoModel> mecanico) {
		this.mecanico = mecanico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

}
