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

import atos.ufn.oficinaWeb.Model.CarroModel;
import atos.ufn.oficinaWeb.Model.ClienteJuridicoModel;
import atos.ufn.oficinaWeb.Model.ClienteModel;
import atos.ufn.oficinaWeb.Service.CarroService;
import atos.ufn.oficinaWeb.Service.ClienteJuridicoService;

@Controller
@RequestMapping("/clientepj")
public class ClienteJuridicoController {

	final Logger clientepjlog = LoggerFactory.getLogger(ClienteJuridicoController.class);

	@Autowired
	private ClienteJuridicoService service;
	@Autowired
	private CarroService carroservice;
	

	@PostMapping("/addPj")
	public String addPj(ClienteJuridicoModel pj, Model model) {
		service.save(pj);
		clientepjlog.info("Carro {}, foi cadastrado com sucesso!", pj.getRazaosocial());
		return "redirect:/clientepj/list";

	}

	@GetMapping("/addPj")
	public String getNewPj(Model model) {
		model.addAttribute("clientepjModel", new ClienteJuridicoModel());
		return "cadastro/newclientepj";

	}

	@GetMapping("/list")
	public String ListPj(Model model) {
		List<ClienteJuridicoModel> clientepj = service.listAll();
		List<CarroModel> carro = carroservice.listAll();
		model.addAttribute("pjList", clientepj);
		model.addAttribute("carro", carro);
		return "list/listclientepj";
	}

	@GetMapping("/update/{id}")
	public String formUpdatePJ(@PathVariable(value = "id") Integer id, Model model) {
		Optional<ClienteJuridicoModel> clientepj = service.listId(id);
		model.addAttribute("clientepj", clientepj);
		return "/update/updateclientepj";
	}

	@PostMapping("/update")
	public String updatePFisica(@RequestParam Integer id, @RequestParam String cnpj, @RequestParam String razaosocial,
			@RequestParam String inscestadual, @RequestParam String endereco, @RequestParam String email,
			@RequestParam String tel) {

		ClienteJuridicoModel clientepj = new ClienteJuridicoModel();

		clientepj = service.listId(id).get();

		clientepj.setCnpj(cnpj);
		clientepj.setRazaosocial(razaosocial);
		clientepj.setEndereco(endereco);
		clientepj.setTel(tel);
		clientepj.setInscestadual(inscestadual);
		clientepj.setEmail(email);

		service.save(clientepj);
		return "redirect:/clientepj/list";
	}

	@GetMapping("/delete/{id}")
	public String delPj(@PathVariable(value = "id") Integer id, Model model) {
		ClienteJuridicoModel clientepj = service.clientepjDel(id);
		model.addAttribute("clientepj", clientepj);
		return "redirect:/clientepj/list";
	}

}
