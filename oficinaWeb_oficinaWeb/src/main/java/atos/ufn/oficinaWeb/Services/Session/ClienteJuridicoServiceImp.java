package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.ClienteJuridicoModel;
import atos.ufn.oficinaWeb.Repository.ClienteJuridicoRepository;
import atos.ufn.oficinaWeb.Service.ClienteJuridicoService;


@Service
public class ClienteJuridicoServiceImp implements ClienteJuridicoService {

	@Autowired
	private ClienteJuridicoRepository repository;
	
	public ClienteJuridicoModel save(ClienteJuridicoModel pj) {

		ClienteJuridicoModel cpj = new ClienteJuridicoModel();
		cpj = repository.save(pj);
		return cpj;
	}

	public List<ClienteJuridicoModel> listAll() {

		return (List<ClienteJuridicoModel>) repository.findAll();

	}

	public Optional<ClienteJuridicoModel> listId(Integer id) {

		return (Optional<ClienteJuridicoModel>) repository.findById(id);
	}

	public ClienteJuridicoModel findById(Integer id) {
		Optional<ClienteJuridicoModel> newCar = repository.findById(id);
		return newCar.orElseThrow(() -> new ObjectNotFoundException(
				"ClientePJ não Encontrado! Id: " + id + ", Tipo: " + ClienteJuridicoModel.class.getName(), null));

	}

	public ClienteJuridicoModel clientepjDel(Integer id) {
		repository.deleteById(id);
		return null;

	}

	public ClienteJuridicoModel update(Integer id, ClienteJuridicoModel cpj) {
		ClienteJuridicoModel newPj = findById(id);
		newPj.setCnpj(cpj.getCnpj());
		newPj.setInscestadual(cpj.getInscestadual());
		newPj.setRazaosocial(cpj.getRazaosocial());
		newPj.setEndereco(cpj.getEndereco());
		newPj.setEmail(cpj.getEmail());
		newPj.setTel(cpj.getTel());		
		return repository.save(newPj);

	}

}
