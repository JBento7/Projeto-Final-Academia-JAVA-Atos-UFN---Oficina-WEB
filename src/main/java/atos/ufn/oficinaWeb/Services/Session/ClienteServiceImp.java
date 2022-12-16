package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.ClienteModel;
import atos.ufn.oficinaWeb.Repository.ClienteRepository;
import atos.ufn.oficinaWeb.Service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	private ClienteRepository clientes;

	public ClienteModel save(ClienteModel cl) {

		ClienteModel cliente = clientes.save(cl);
		return cliente;
	}

	public List<ClienteModel> listAll() {

		return (List<ClienteModel>) clientes.findAll();

	}

	public Optional<ClienteModel> listId(Integer id) {

		return clientes.findById(id);
	}

	public ClienteModel clienteDel(Integer id) {
		clientes.deleteById(id);
		return null;

	}

}
