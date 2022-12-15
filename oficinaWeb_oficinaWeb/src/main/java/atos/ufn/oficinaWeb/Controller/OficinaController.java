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

import atos.ufn.oficinaWeb.Model.ClienteJuridicoModel;
import atos.ufn.oficinaWeb.Model.MecanicoModel;
import atos.ufn.oficinaWeb.Model.OficinaModel;
import atos.ufn.oficinaWeb.Service.MecanicoService;
import atos.ufn.oficinaWeb.Service.OficinaService;

@Controller
@RequestMapping("/oficina")
public class OficinaController {

	final Logger ofilog = LoggerFactory.getLogger(OficinaController.class);

	@Autowired
	private OficinaService service;
	@Autowired
	private MecanicoService mecanic;

	@PostMapping("/addOficina")
	public String addOficina(Model model, OficinaModel oficina) {

		service.save(oficina);
		ofilog.info("Oficina {}, foi cadastrado com sucesso!", oficina.getNome());
		return "redirect:/oficina/list";

	}

	@GetMapping("/addOficina")
	public String getNewOficina(Model model) {
		model.addAttribute("oficinaModel", new OficinaModel());
		return "cadastro/newoficina";

	}
	
	@GetMapping("/list")
	public String listOficina(Model model) {
		List<OficinaModel> oficina = service.listAll();
		List<MecanicoModel> mecanico = mecanic.listAll();
		model.addAttribute("oficinaList", oficina);
		model.addAttribute("mecanico", mecanico);
		return "list/listoficina";

	}
	
	

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<OficinaModel> update(@PathVariable Integer id, @RequestBody OficinaModel oficina) {
		OficinaModel newOficina = service.update(id, oficina);
		ofilog.info("Oficina Atualizada com sucesso!");
		return ResponseEntity.ok().body(newOficina);

	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<OficinaModel> listAll() {
		ofilog.info("Listando todos as oficinas cadastradas");
		return service.listAll();

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		service.oficinaDel(id);
		ofilog.info("Oficina " + id + ", deletada com sucesso");

	}

}
