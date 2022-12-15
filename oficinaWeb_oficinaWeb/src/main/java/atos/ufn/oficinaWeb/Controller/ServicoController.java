package atos.ufn.oficinaWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import atos.ufn.oficinaWeb.Model.ServicosModel;
import atos.ufn.oficinaWeb.Service.MecanicoService;
import atos.ufn.oficinaWeb.Service.ServicoService;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoService servico;
	@Autowired
	private MecanicoService mecanico;

	@PostMapping("/addServico")
	public String addSer(ServicosModel service, Model model) {

		servico.save(service);
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
		List<ServicosModel> service = servico.listAll();
		model.addAttribute("servico", service);
		model.addAttribute("mecanico", mecanico.listAll());
		return "list/listservico";

	}
}
