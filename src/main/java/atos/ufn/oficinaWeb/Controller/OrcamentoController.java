package atos.ufn.oficinaWeb.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import atos.ufn.oficinaWeb.Model.OrcamentoModel;
import atos.ufn.oficinaWeb.Service.CarroService;
import atos.ufn.oficinaWeb.Service.OrcamentoService;
import atos.ufn.oficinaWeb.Service.ServicoService;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {

	final Logger orclog = LoggerFactory.getLogger(OrcamentoController.class);

	@Autowired
	private OrcamentoService orc;
	
	@Autowired
	private ServicoService servico;
	
	@Autowired
	private CarroService carro;

	@PostMapping("/addOrc")
	public String addOrc(OrcamentoModel orcamento, Model model) {
		orc.save(orcamento);
		orclog.info("Carro {}, foi cadastrado com sucesso!", orcamento.getId());
		return "redirect:/orcamento/list";

	}

//	@PutMapping(path = "/update/{id}")
//	public ResponseEntity<OrcamentoModel> update(@PathVariable Integer id, @RequestBody OrcamentoModel orc) {
//		//OrcamentoModel newOrc = orc.update(id, orc);
//		orclog.info("Carro Atualizado com sucesso!");
//		//return ResponseEntity.ok().body(newOrc);
//
//	}

	@GetMapping("/addOrc")
	public String getNewOrc(Model model) {
		
		model.addAttribute("orcamentoModel", new OrcamentoModel());
		model.addAttribute("servicos", servico.listAll());
		model.addAttribute("carro", carro.listAll());
		orclog.info("Listando todos os carros cadastrados");
		return "cadastro/neworcamento";

	}
	
	@GetMapping("/list")
	public String listOrc(Model model) {
		
		model.addAttribute("orcamento", orc.listAll());
		model.addAttribute("servicos", servico.listAll());
		model.addAttribute("carro", carro.listAll());
		orclog.info("Listando todos os carros cadastrados");
		return "list/listorcamento";
	}
	
	

//	@GetMapping(path = "/find/{id}")
//	public @ResponseBody Optional<OrcamentoModel> listId(@PathVariable Integer id) {
//
//		orclog.info("Buscando Carro");
//		return service.listId(id);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public void delete(@PathVariable Integer id) throws NotFoundException {
//		service.orcDel(id);
//		orclog.info("Carro " + id + ", deletado com sucesso");
//
//	}

}
