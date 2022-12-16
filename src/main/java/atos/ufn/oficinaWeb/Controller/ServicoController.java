package atos.ufn.oficinaWeb.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import atos.ufn.oficinaWeb.Model.ClienteModel;
import atos.ufn.oficinaWeb.Model.ServicosModel;
import atos.ufn.oficinaWeb.Service.MecanicoService;
import atos.ufn.oficinaWeb.Service.ServicoService;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoService serv;
	@Autowired
	private MecanicoService mecanico;

	@PostMapping("/addServico")
	public String addSer(ServicosModel service, Model model) {

		serv.save(service);
		return "redirect:/servico/list";

	}

	@GetMapping("/addServico")
	public String getNewServ(Model model) {
		model.addAttribute("servicoModel", new ServicosModel());
		model.addAttribute("mecanico", mecanico.listAll());
		return "cadastro/newservico";

	}

	@GetMapping("/list")
	public String listServ(Model model) {
		List<ServicosModel> service = serv.listAll();
		model.addAttribute("servico", service);
		model.addAttribute("mecanico", mecanico.listAll());
		return "list/listservico";

	}
	
	@GetMapping("/update/{id}")
	public String formUpdateServico(@PathVariable(value = "id") Integer id, Model model) {
		Optional<ServicosModel> servicos = serv.listId(id);
		model.addAttribute("servico", servicos);
		model.addAttribute("mecanico", mecanico.listAll());
		return "/update/updateservico";
	}
	
	@PostMapping("/update")
	public String updateServico(@RequestParam Integer id, @RequestParam String servico) {

		ServicosModel servicos = new ServicosModel();

		servicos = serv.listId(id).get();

		servicos.setServico(servico);
		

		serv.save(servicos);
		return "redirect:/servico/list";
	}

	
}
