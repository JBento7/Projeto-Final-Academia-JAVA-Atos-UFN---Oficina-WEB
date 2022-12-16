package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.MecanicoModel;

public interface MecanicoService {

	public MecanicoModel save(MecanicoModel mec);

	public List<MecanicoModel> listAll();

	public Optional<MecanicoModel> listId(Integer id);

	public MecanicoModel mecanicoDel(Integer id);

	public MecanicoModel update(Integer id, MecanicoModel NewMecanico);
}
