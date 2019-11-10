package proj.pizza.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import proj.pizza.bean.Administrator;
import proj.pizza.bean.Cliente;
import proj.pizza.bean.Produto;
import proj.pizza.service.AdministratorService;
import proj.pizza.service.ClienteService;
import proj.pizza.service.ProdutoService;

@RestController
public class RestManterAdminController {
	AdministratorService administratorService;
	ProdutoService produtoService;
	ClienteService clienteService;
	
	@Autowired
	public RestManterAdminController(AdministratorService ads, ProdutoService ps, ClienteService cs) {
		administratorService = ads;
		produtoService = ps;
		clienteService = cs;
	}
	
	private Administrator carregarAdmin(String user, String senha) throws IOException{
		return administratorService.carregarAdmin(user, senha);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="rest/validar_login_admin")
	public @ResponseBody Administrator validarLoginAdmin(@RequestParam String user, @RequestParam String senha, HttpSession session) {
		Administrator admin = null;
		try {
			admin = carregarAdmin(user, senha);
			session.setAttribute("adminLogado", admin);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/adminProduto")
	public @ResponseBody List<Produto> adminProduto() {
		List<Produto> produtos = null;
		try {
			produtos = produtoService.buscarProdutos(Produto.ALL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/adminCliente")
	public @ResponseBody List<Cliente> adminCliente() {
		List<Cliente> clientes = null;
		try {
			clientes = clienteService.listarClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientes;
	}	
}
