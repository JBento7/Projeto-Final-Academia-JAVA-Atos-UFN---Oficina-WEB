package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.OrcamentoModel;

public interface OrcamentoService {
	
	public OrcamentoModel save(OrcamentoModel orc);

	public List<OrcamentoModel> listAll();

	public Optional<OrcamentoModel> listId(Integer id);

	public void orcDel(Integer id);

	public OrcamentoModel update(Integer id, OrcamentoModel newOrc);

}
