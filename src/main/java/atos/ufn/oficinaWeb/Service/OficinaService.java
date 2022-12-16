package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.OficinaModel;

public interface OficinaService {
	
	public OficinaModel save(OficinaModel ofi);
	
	public List<OficinaModel> listAll();
	
	public Optional<OficinaModel> listId(Integer id);
	
	public void oficinaDel(Integer id);
	
	public OficinaModel update(Integer id, OficinaModel newOficina);

}
