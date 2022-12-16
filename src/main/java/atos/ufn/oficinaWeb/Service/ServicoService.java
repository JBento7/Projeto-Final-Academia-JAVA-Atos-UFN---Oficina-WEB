package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.ServicosModel;

public interface ServicoService {
	
	public ServicosModel save(ServicosModel serv);

	public List<ServicosModel> listAll();

	public Optional<ServicosModel> listId(Integer id);

	public void servDel(Integer id);

	public ServicosModel update(Integer id, ServicosModel newServ);

}
