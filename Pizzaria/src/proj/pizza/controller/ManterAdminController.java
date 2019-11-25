package proj.pizza.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proj.pizza.bean.Administrator;
import proj.pizza.bean.Cliente;
import proj.pizza.bean.Produto;
import proj.pizza.service.AdministratorService;
import proj.pizza.service.ClienteService;
import proj.pizza.service.ProdutoService;

@Controller
public class ManterAdminController {
	AdministratorService administratorService;
	ProdutoService produtoService;
	ClienteService clienteService;
	
	@Autowired
	public ManterAdminController(AdministratorService ads, ProdutoService ps, ClienteService cs) {
		administratorService = ads;
		produtoService = ps;
		clienteService = cs;
	}
	
	@RequestMapping("/loginAdmin")
	public String telaLoginAdmin(HttpSession session) {
		Administrator admin = (Administrator)session.getAttribute("adminLogado") ;
		if (admin != null) {
			return "redirect:/adminProduto";
		}
		return "loginAdmin";
	}
	
	private Administrator carregarAdmin(String user, String senha) throws IOException{
		return administratorService.carregarAdmin(user, senha);
	}
	
	@RequestMapping("/validar_login_admin")
	public String validarLoginAdmin(@RequestParam String user, @RequestParam String senha, Model model, HttpSession session) {
		try {
			System.out.println("User: " + user + " Senha: " + senha);
			session.setAttribute("adminLogado", carregarAdmin(user, senha));
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		return "redirect:/adminProduto";
	}
	
	@RequestMapping("/admin_logoff")
	public String adminLogoffSession(HttpSession session) {
		session.removeAttribute("adminLogado");
		return "redirect:/index";
	}
	
	@RequestMapping("/adminProduto")
	public String telaAdminProduto(Model model) {
		try {
			List<Produto> produtos = produtoService.buscarProdutosAtivos(Produto.ALL);
			model.addAttribute("listProdutos", produtos);
			return "adminProduto";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		
	}
	
	@RequestMapping("/adminCliente")
	public String telaAdminCliente(Model model) throws IOException {
		List<Cliente> cliente = clienteService.listarClientesAtivos();
		model.addAttribute("listCliente", cliente);
		return "adminCliente";
	}	
}
