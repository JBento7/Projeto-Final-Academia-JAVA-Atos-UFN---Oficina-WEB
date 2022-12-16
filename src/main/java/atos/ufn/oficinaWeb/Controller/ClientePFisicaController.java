package atos.ufn.oficinaWeb.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import atos.ufn.oficinaWeb.Model.CarroModel;
import atos.ufn.oficinaWeb.Model.ClienteModel;
import atos.ufn.oficinaWeb.Service.CarroService;
import atos.ufn.oficinaWeb.Service.ClienteJuridicoService;
import atos.ufn.oficinaWeb.Service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClientePFisicaController {

	final Logger clientelog = LoggerFactory.getLogger(ClientePFisicaController.class);

	@Autowired
	private ClienteService service;
	@Autowired
	private CarroService carroservice;
	@Autowired
	private ClienteJuridicoService pjservice;

	@PostMapping("/addClientepf")
	public String addClientepf(ClienteModel cliente, Model model) {

		service.save(cliente);
		clientelog.info("Cliente cadastrado com sucesso!");
		return "redirect:/cliente/list";
		
	}

	@GetMapping("/addClientepf")
	public String getNewClientepf(Model model) {
		model.addAttribute("clienteModel", new ClienteModel());
		return "/cadastro/newclientepf";

	}

	@GetMapping("/list")
	public String listClientepf(Model model) {
		List<ClienteModel> clientepf = service.listAll();
		List<CarroModel> carro = carroservice.listAll();
		model.addAttribute("clientepfList", clientepf);
		model.addAttribute("carro", carro);
		return "list/listclientepf";
	}

	@GetMapping("/update/{id}")
	public String formUpdatePFisica(@PathVariable(value = "id") Integer id, Model model) {
		Optional<ClienteModel> cliente = service.listId(id);
		model.addAttribute("clientepf", cliente);
		return "/update/updateclientepf";
	}

	@PostMapping("/update")
	public String updatePFisica(@RequestParam Integer id, @RequestParam String cpf, @RequestParam String nome,
			@RequestParam String endereco, @RequestParam Integer tel, @RequestParam Integer cel) {

		ClienteModel cliente = new ClienteModel();

		cliente = service.listId(id).get();

		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setTel(tel);
		cliente.setCel(cel);

		service.save(cliente);
		return "redirect:/cliente/list";
	}

	@GetMapping("/delete/{id}")
	public String delPFisica(@PathVariable(value = "id") Integer id, Model model) {
		ClienteModel cliente = service.clienteDel(id);
		model.addAttribute("clientepf", cliente);
		return "redirect:/cliente/list";
	}

//	@PutMapping(path = "/updateCliente/{id}")
//	public ResponseEntity<ClienteModel> update(@PathVariable Integer id, @RequestBody ClienteModel client) {
//		ClienteModel newCliente = service.update(id, client);
//		clientelog.info("Cliente Atualizado com sucesso!");
//		return ResponseEntity.ok().body(newCliente);
//
//	}
//
//	@GetMapping(path = "/find/{id}")
//	public @ResponseBody Optional<ClienteModel> listId(@PathVariable Integer id) {
//
//		clientelog.info("Buscando Cliente");
//		return service.listId(id);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public void delete(@PathVariable Integer id) throws NotFoundException {
//		service.clienteDel(id);
//		clientelog.info("Cliente " + id + ", deletado com sucesso");
//
//	}
}
