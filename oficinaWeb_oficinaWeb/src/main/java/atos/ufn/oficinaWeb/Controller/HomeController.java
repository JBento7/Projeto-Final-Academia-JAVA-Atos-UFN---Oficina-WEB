package atos.ufn.oficinaWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import atos.ufn.oficinaWeb.Model.CarroModel;
import atos.ufn.oficinaWeb.Model.ClienteJuridicoModel;
import atos.ufn.oficinaWeb.Model.ClienteModel;
import atos.ufn.oficinaWeb.Model.MecanicoModel;
import atos.ufn.oficinaWeb.Model.OrcamentoModel;
import atos.ufn.oficinaWeb.Model.OrdemServicoModel;
import atos.ufn.oficinaWeb.Model.ServicosModel;
import atos.ufn.oficinaWeb.Service.CarroService;
import atos.ufn.oficinaWeb.Service.ClienteJuridicoService;
import atos.ufn.oficinaWeb.Service.ClienteService;
import atos.ufn.oficinaWeb.Service.MecanicoService;
import atos.ufn.oficinaWeb.Service.OrcamentoService;
import atos.ufn.oficinaWeb.Service.OrdemServicoService;
import atos.ufn.oficinaWeb.Service.ServicoService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private OrdemServicoService os;
	@Autowired
	private OrcamentoService service;
	@Autowired
	private ServicoService servico;
	@Autowired
	private CarroService carro;
	@Autowired
	private MecanicoService mecanico;
	@Autowired
	private ClienteService clientepf;
	@Autowired
	private ClienteJuridicoService clientepj;

//	@GetMapping("/index")
//	public String home(Model model) {
//		return "/home";
//	}
	
	@ModelAttribute("OrdemServicoModel")
	public OrdemServicoModel toOrdemServicoModel() {
		return new OrdemServicoModel();
		
	}
	@GetMapping("/index")
	
	public ModelAndView listOrc(Model model) {
		ModelAndView mv = new ModelAndView("home");
		
		
		List<OrdemServicoModel> ordemos = os.listAll();
		List<OrcamentoModel> orcamento = service.listAll();
		List<CarroModel> car = carro.listAll();
		List<ServicosModel> serv = servico.listAll();
		List<MecanicoModel> mecanic = mecanico.listAll();
		List<ClienteModel> cliente = clientepf.listAll();
		List<ClienteJuridicoModel> clientep = clientepj.listAll();
		model.addAttribute("os", ordemos);
		model.addAttribute("orcamento", orcamento);
		model.addAttribute("carro", car);
		model.addAttribute("servico", serv);
		model.addAttribute("mecanico", mecanic);
		model.addAttribute("clientepf", cliente);
		model.addAttribute("clientepj", clientep);
		mv.addObject(ordemos);
		return mv;
	}
}
