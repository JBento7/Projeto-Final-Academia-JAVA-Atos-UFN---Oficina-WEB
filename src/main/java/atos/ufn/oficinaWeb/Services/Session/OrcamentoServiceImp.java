package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.CarroModel;
import atos.ufn.oficinaWeb.Model.OrcamentoModel;
import atos.ufn.oficinaWeb.Repository.OrcamentoRepository;
import atos.ufn.oficinaWeb.Service.OrcamentoService;

@Service
public class OrcamentoServiceImp implements OrcamentoService {

	@Autowired
	private OrcamentoRepository repository;

	public OrcamentoModel save(OrcamentoModel orc) {

		OrcamentoModel orcamento = new OrcamentoModel();
		orcamento = repository.save(orc);
		return orcamento;
	}

	public List<OrcamentoModel> listAll() {

		return (List<OrcamentoModel>) repository.findAll();

	}

	public Optional<OrcamentoModel> listId(Integer id) {

		return (Optional<OrcamentoModel>) repository.findById(id);
	}

	public OrcamentoModel findById(Integer id) {
		Optional<OrcamentoModel> newCar = repository.findById(id);
		return newCar.orElseThrow(() -> new ObjectNotFoundException(
				"Carro não Encontrado! Id: " + id + ", Tipo: " + CarroModel.class.getName(), null));

	}

	public void orcDel(Integer id) {
		repository.deleteById(id);

	}

	public OrcamentoModel update(Integer id, OrcamentoModel orc) {
		OrcamentoModel newOrc = findById(id);
		newOrc.setId(orc.getId());
		return repository.save(newOrc);

	}

}
