package atos.ufn.oficinaWeb.Services.Session;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.ufn.oficinaWeb.Model.CarroModel;
import atos.ufn.oficinaWeb.Repository.CarroRepository;
import atos.ufn.oficinaWeb.Service.CarroService;

@Service
public class CarroServiceImp implements CarroService {

	@Autowired
	private CarroRepository data;

	public CarroModel save(CarroModel c) {

		CarroModel carro = new CarroModel();
		carro = data.save(c);
		return carro;
	}

	public List<CarroModel> listAll() {

		return (List<CarroModel>) data.findAll();

	}

	public Optional<CarroModel> listId(Integer id) {

		return (Optional<CarroModel>) data.findById(id);
	}

	public CarroModel findById(Integer id) {
		Optional<CarroModel> newCar = data.findById(id);
		return newCar.orElseThrow(() -> new ObjectNotFoundException(
				"Carro não Encontrado! Id: " + id + ", Tipo: " + CarroModel.class.getName(), null));

	}

	public CarroModel carroDel(Integer id) {
		data.deleteById(id);
		return null;

	}

	public CarroModel update(Integer id, CarroModel car) {
		CarroModel newCar = findById(id);
		newCar.setPlaca(car.getPlaca());
		newCar.setMarca(car.getMarca());
		newCar.setModelo(car.getModelo());
		newCar.setCor(car.getCor());
		newCar.setCategoria(car.getCategoria());
		return data.save(newCar);

	}

}
