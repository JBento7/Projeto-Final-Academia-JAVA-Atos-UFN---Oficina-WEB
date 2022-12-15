package atos.ufn.oficinaWeb.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ordemservico")
public class OrdemServicoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataentrega;

	@OneToOne
	private OrcamentoModel orcamento;
	
	@ManyToOne
	private ServicosModel servico;

	public OrdemServicoModel() {
	}

	public OrdemServicoModel(Integer id, Date dataentrega) {
		super();
		this.id = id;
		this.dataentrega = dataentrega;
	}
	
	
	
	public ServicosModel getServico() {
		return servico;
	}

	public void setServico(ServicosModel servico) {
		this.servico = servico;
	}

	public OrcamentoModel getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(OrcamentoModel orcamento) {
		this.orcamento = orcamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataentrega() {
		return dataentrega;
	}

	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}

}