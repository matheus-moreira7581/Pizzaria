package proj.pizza.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import proj.pizza.service.AdministratorService;
import proj.pizza.service.ClienteService;
import proj.pizza.service.ItemPedidoService;
import proj.pizza.service.PedidoService;
import proj.pizza.service.ProdutoService;

@Controller
public class ManterPizzariaController {
	ProdutoService produtoService;
	ClienteService clienteService;
	PedidoService pedidoService;
	ItemPedidoService itemPedidoService;
	AdministratorService administratorService;
	
	
	@Autowired
	public ManterPizzariaController(ProdutoService ps, ClienteService cs, PedidoService pds, ItemPedidoService ips, AdministratorService ads) {
		produtoService = ps;
		clienteService = cs;
		pedidoService = pds;
		itemPedidoService = ips;
		administratorService = ads;
	}
	
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("/cadastro")
	public String telaCadastro() {
		return "cadastro";
	}
	
	@RequestMapping("/login")
	public String telaLogin( ) {
		return "login";
	}
	
	@RequestMapping("/pagamento")
	public String telaPagamento(HttpSession session) {
		return "pagamento";
	}
	
	@RequestMapping("/carrinho")
	public String telaCarrinho() {
		return "carrinho";
	}
	

}
