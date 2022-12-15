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

import atos.ufn.oficinaWeb.Model.ClienteModel;
import atos.ufn.oficinaWeb.Model.MecanicoModel;
import atos.ufn.oficinaWeb.Model.OficinaModel;
import atos.ufn.oficinaWeb.Model.ServicosModel;
import atos.ufn.oficinaWeb.Service.MecanicoService;
import atos.ufn.oficinaWeb.Service.OficinaService;
import atos.ufn.oficinaWeb.Service.ServicoService;

@Controller
@RequestMapping("/mecanico")
public class MecanicoController {

	final Logger meclog = LoggerFactory.getLogger(MecanicoController.class);

	@Autowired
	private MecanicoService service;
	@Autowired
	private OficinaService servoficina;
	@Autowired
	private ServicoService serv;

	@PostMapping("/addMecanico")
	public String addMecanico(MecanicoModel mecanico, Model model) {

		service.save(mecanico);
		return "redirect:/mecanico/list";

	}

	@GetMapping("/addMecanico")
	public String newMecanico(Model model) {

		List<OficinaModel> oficina = servoficina.listAll();
		model.addAttribute("mecanicoModel", new MecanicoModel());
		model.addAttribute("oficina", oficina);
		return "cadastro/newmecanico";

	}

	@GetMapping("/list")
	public String listMecanico(Model model) {
		List<MecanicoModel> mecanico = service.listAll();
		model.addAttribute("mecanicoList", mecanico);
		meclog.info("Listando todos os mecanicos cadastrados");
		return "list/listmecanico";

	}

	@GetMapping("/update/{id}")
	public String formUpdatePFisica(@PathVariable(value = "id") Integer id, Model model) {
		Optional<MecanicoModel> mecanico = service.listId(id);
		model.addAttribute("mecanico", mecanico);
		return "/update/updatemecanico";
	}

	@PostMapping("/update")
	public String updatePFisica(@RequestParam Integer id, @RequestParam String cpf, @RequestParam String nome,
			@RequestParam String idoficina, @RequestParam String cargo) {

		MecanicoModel mecanico = new MecanicoModel();

		mecanico = service.listId(id).get();

		mecanico.setNome(nome);
		mecanico.setCpf(cpf);
		mecanico.setCargo(cargo);
		mecanico.setIdOficina(idoficina);
		

		service.save(mecanico);
		return "redirect:/mecanico/list";
	}

	@GetMapping("/delete/{id}")
	public String delPFisica(@PathVariable(value = "id") Integer id, Model model) {
		MecanicoModel mecanico = service.mecanicoDel(id);
		model.addAttribute("mecanico", mecanico);
		return "redirect:/mecanico/list";
	}

}
