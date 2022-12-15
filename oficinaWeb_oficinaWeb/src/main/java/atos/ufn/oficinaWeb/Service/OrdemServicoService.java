package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.OrdemServicoModel;

public interface OrdemServicoService {

	public OrdemServicoModel save(OrdemServicoModel ser);

	public List<OrdemServicoModel> listAll();

	public Optional<OrdemServicoModel> listId(Integer id);

	public void servicoDel(Integer id);

	public OrdemServicoModel update(Integer id, OrdemServicoModel newServico);

}
