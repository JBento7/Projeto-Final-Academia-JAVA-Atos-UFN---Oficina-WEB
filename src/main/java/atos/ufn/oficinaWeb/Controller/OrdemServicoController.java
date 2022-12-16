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
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/os")
public class OrdemServicoController {

	final Logger servicolog = LoggerFactory.getLogger(OrdemServicoController.class);

	@Autowired
	private OrdemServicoService ordem;
	@Autowired
	private OrcamentoService serorcamento;
	@Autowired
	private ClienteService clientepf;
	@Autowired
	private ClienteJuridicoService clientepj;
	@Autowired
	private ServicoService servico;
	@Autowired
	private CarroService carro;
	@Autowired
	private MecanicoService mecanico;

	@PostMapping("/addOs")
	public String addOs(OrdemServicoModel os, Model model) {
		ordem.save(os);
		servicolog.info("Carro {}, foi cadastrado com sucesso!", os.getId());
		return "redirect:/os/list";

	}

	@GetMapping("/addOs")
	public String getNewOS(Model model) {
		model.addAttribute("osModel", new OrdemServicoModel());
		model.addAttribute("orcamento", serorcamento.listAll());
		model.addAttribute("carro", carro.listAll());
		model.addAttribute("servico", servico.listAll());
		return "cadastro/newordemservico";

	}

	@GetMapping("/list")

	public String listOs(Model model) {
		List<OrdemServicoModel> ordemos = ordem.listAll();
		List<OrcamentoModel> orcamento = serorcamento.listAll();
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
		return "list/listos";
	}

//	@PutMapping(path = "/update/{id}")
//	public ResponseEntity<OrdemServicoModel> update(@PathVariable Integer id, @RequestBody OrdemServicoModel servico) {
//		OrdemServicoModel newServico = service.update(id, servico);
//		servicolog.info("Servico Atualizado com sucesso!");
//		return ResponseEntity.ok().body(newServico);
//
//	}
//
//	@GetMapping(path = "/all")
//	public @ResponseBody Iterable<OrdemServicoModel> listAll() {
//		servicolog.info("Listando todos os servicos cadastrados");
//		return service.listAll();
//
//	}
//
//	@GetMapping(path = "/find/{id}")
//	public @ResponseBody Optional<OrdemServicoModel> listId(@PathVariable Integer id) {
//
//		servicolog.info("Buscando Servico");
//		return service.listId(id);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public void delete(@PathVariable Integer id) throws NotFoundException {
//		service.servicoDel(id);
//		servicolog.info("Servico " + id + ", deletado com sucesso");
//
//	}

}
