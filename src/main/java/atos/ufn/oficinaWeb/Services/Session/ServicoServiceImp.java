package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.ServicosModel;
import atos.ufn.oficinaWeb.Repository.ServicoRepository;
import atos.ufn.oficinaWeb.Service.ServicoService;

@Service
public class ServicoServiceImp implements ServicoService {

	@Autowired
	private ServicoRepository service;

	public ServicosModel save(ServicosModel serv) {

		ServicosModel servico = new ServicosModel();
		servico = service.save(serv);
		return servico;
	}

	public List<ServicosModel> listAll() {

		return (List<ServicosModel>) service.findAll();

	}

	public Optional<ServicosModel> listId(Integer id) {

		return (Optional<ServicosModel>) service.findById(id);
	}

	public ServicosModel findById(Integer id) {
		Optional<ServicosModel> newOficina = service.findById(id);
		return newOficina.orElseThrow(() -> new ObjectNotFoundException(
				"Oficina não Encontrada! Id: " + id + ", Tipo: " + ServicosModel.class.getName(), null));

	}

	public void oficinaDel(Integer id) {
		service.deleteById(id);

	}

	public ServicosModel update(Integer id, ServicosModel serv) {
		ServicosModel newServ = findById(id);
		newServ.setServico(serv.getServico());
		return service.save(newServ);

	}

	@Override
	public void servDel(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
