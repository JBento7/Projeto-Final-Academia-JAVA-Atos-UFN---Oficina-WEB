package atos.ufn.oficinaWeb.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import atos.ufn.oficinaWeb.Model.CarroModel;
import atos.ufn.oficinaWeb.Model.ClienteJuridicoModel;
import atos.ufn.oficinaWeb.Model.ClienteModel;
import atos.ufn.oficinaWeb.Service.CarroService;
import atos.ufn.oficinaWeb.Service.ClienteJuridicoService;
import atos.ufn.oficinaWeb.Service.ClienteService;

@Controller
@RequestMapping("/carro")
public class CarroController {

	final Logger carrolog = LoggerFactory.getLogger(CarroController.class);

	@Autowired
	private CarroService service;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteJuridicoService pjservice;

	@PostMapping("/addCarro")
	public String addCarro(CarroModel carro, Model model) {

		service.save(carro);
		return "redirect:/carro/list";

	}

	@GetMapping("/addCarro")
	public String getNewCarro(Model model) {
		model.addAttribute("carroModel", new CarroModel());
		model.addAttribute("clientepf", clienteService.listAll());
		model.addAttribute("clientepj", pjservice.listAll());
		return "cadastro/newcarro";

	}

	@GetMapping("/list")
	public String listCarro(Model model) {
		List<CarroModel> carro = service.listAll();
		model.addAttribute("carroList", carro);
		return "list/listcarro";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdateCarro(@PathVariable(value = "id") Integer id, Model model) {
		Optional<CarroModel> carro = service.listId(id);
		model.addAttribute("carro", carro);
		return "/update/updatecarro";
	}
	
	@PostMapping("/update")
	public String updateCarro(@RequestParam Integer id, @RequestParam String placa, @RequestParam String marca,
			@RequestParam String modelo, @RequestParam String cor, @RequestParam String categoria) {

		CarroModel carro = new CarroModel();

		carro = service.listId(id).get();

		carro.setPlaca(placa);
		carro.setMarca(marca);
		carro.setModelo(modelo);
		carro.setCor(cor);
		carro.setCategoria(categoria);

		service.save(carro);
		return "redirect:/carro/list";
	}

	@GetMapping("/delete/{id}")
	public String delcarro(@PathVariable(value = "id") Integer id, Model model) {
		CarroModel carro = service.carroDel(id);
		model.addAttribute("clientepf", carro);
		return "redirect:/carro/list";
	}
	
	

	
}
