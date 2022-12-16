package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.OficinaModel;
import atos.ufn.oficinaWeb.Repository.OficinaRepository;
import atos.ufn.oficinaWeb.Service.OficinaService;

@Service
public class OficinaServiceImp implements OficinaService {

	@Autowired
	private OficinaRepository service;

	public OficinaModel save(OficinaModel ofi) {

		OficinaModel oficina = new OficinaModel();
		oficina = service.save(ofi);
		return oficina;
	}

	public List<OficinaModel> listAll() {

		return (List<OficinaModel>) service.findAll();

	}

	public Optional<OficinaModel> listId(Integer id) {

		return (Optional<OficinaModel>) service.findById(id);
	}

	public OficinaModel findById(Integer id) {
		Optional<OficinaModel> newOficina = service.findById(id);
		return newOficina.orElseThrow(() -> new ObjectNotFoundException(
				"Oficina não Encontrada! Id: " + id + ", Tipo: " + OficinaModel.class.getName(), null));

	}

	public void oficinaDel(Integer id) {
		service.deleteById(id);

	}

	public OficinaModel update(Integer id, OficinaModel oficina) {
		OficinaModel newOficina = findById(id);
		newOficina.setNome(oficina.getNome());
		newOficina.setCnpj(oficina.getCnpj());
		newOficina.setEndereco(oficina.getEndereco());
		return service.save(newOficina);

	}

}
