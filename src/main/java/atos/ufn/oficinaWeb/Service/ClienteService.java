package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.ClienteModel;

public interface ClienteService {

	public ClienteModel save(ClienteModel cl);

	public List<ClienteModel> listAll();

	public Optional<ClienteModel> listId(Integer id);

	public ClienteModel clienteDel(Integer id);

		
}
