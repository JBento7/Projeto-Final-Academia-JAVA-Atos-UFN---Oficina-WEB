package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.ClienteJuridicoModel;

public interface ClienteJuridicoService {
	
	public ClienteJuridicoModel save(ClienteJuridicoModel pj);
	
	public List<ClienteJuridicoModel> listAll();
	
	public Optional<ClienteJuridicoModel> listId(Integer id);
	
	public 	ClienteJuridicoModel clientepjDel(Integer id);
	
	

}
