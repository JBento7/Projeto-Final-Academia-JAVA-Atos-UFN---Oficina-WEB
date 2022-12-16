package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.MecanicoModel;
import atos.ufn.oficinaWeb.Repository.MecanicoRepository;
import atos.ufn.oficinaWeb.Service.MecanicoService;

@Service
public class MecanicoServiceImp implements MecanicoService {

	@Autowired
	private MecanicoRepository mecanic;

	public MecanicoModel save(MecanicoModel mec) {

		MecanicoModel mecanico = new MecanicoModel();
		mecanico = mecanic.save(mec);
		return mecanico;
	}

	public List<MecanicoModel> listAll() {
		return (List<MecanicoModel>) mecanic.findAll();

	}

	public Optional<MecanicoModel> listId(Integer id) {
		return (Optional<MecanicoModel>) mecanic.findById(id);

	}
	
	public MecanicoModel findById(Integer id) {
		Optional<MecanicoModel> newMecanico = mecanic.findById(id);
		return newMecanico.orElseThrow(() -> new ObjectNotFoundException(
				"Mecanico não Encontrado! Id: " + id + ", Tipo: " + MecanicoModel.class.getName(), null));
	
	}


	public MecanicoModel mecanicoDel(Integer id) {
		mecanic.deleteById(id);
		return null;

	}
	
	public MecanicoModel update(Integer id, MecanicoModel mecanico) {
		MecanicoModel newMecanico = findById(id);
		newMecanico.setNome(mecanico.getNome());
		newMecanico.setCpf(mecanico.getCpf());
		newMecanico.setCargo(mecanico.getCargo());
		newMecanico.setIdOficina(mecanico.getIdOfInteger());
		return mecanic.save(newMecanico);
	}
}
