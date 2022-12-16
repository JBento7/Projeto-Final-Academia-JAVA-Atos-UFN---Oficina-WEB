package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.OrdemServicoModel;
import atos.ufn.oficinaWeb.Repository.OrdemServicoRepository;
import atos.ufn.oficinaWeb.Service.OrdemServicoService;

@Service
public class OrdemServicoServiceImp implements OrdemServicoService {

	@Autowired
	private OrdemServicoRepository service;

	public OrdemServicoModel save(OrdemServicoModel ser) {

		OrdemServicoModel servico = new OrdemServicoModel();
		servico = service.save(ser);
		return servico;
	}

	public List<OrdemServicoModel> listAll() {

		return (List<OrdemServicoModel>) service.findAll();

	}

	public Optional<OrdemServicoModel> listId(Integer id) {

		return (Optional<OrdemServicoModel>) service.findById(id);
	}

	public OrdemServicoModel findById(Integer id) {
		Optional<OrdemServicoModel> newServico = service.findById(id);
		return newServico.orElseThrow(() -> new ObjectNotFoundException(
				"Servico não Encontrada! Id: " + id + ", Tipo: " + OrdemServicoModel.class.getName(), null));

	}

	public void servicoDel(Integer id) {
		service.deleteById(id);

	}

	public OrdemServicoModel update(Integer id, OrdemServicoModel servico) {
		OrdemServicoModel newServico = findById(id);
		newServico.setDataentrega(servico.getDataentrega());
		
		return service.save(newServico);

	}

}
