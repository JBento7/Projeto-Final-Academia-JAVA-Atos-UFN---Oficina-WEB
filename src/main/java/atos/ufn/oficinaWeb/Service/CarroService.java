package atos.ufn.oficinaWeb.Service;

import java.util.List;
import java.util.Optional;

import atos.ufn.oficinaWeb.Model.CarroModel;

public interface CarroService {

	public CarroModel save(CarroModel c);
	
	public List<CarroModel> listAll();
	
	public Optional<CarroModel> listId(Integer id);
	
	public 	CarroModel carroDel(Integer id);
	
	public CarroModel update(Integer id, CarroModel newCar);
}
