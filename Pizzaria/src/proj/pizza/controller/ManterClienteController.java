package proj.pizza.controller;



import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import proj.pizza.bean.Cliente;
import proj.pizza.service.ClienteService;

@Controller
public class ManterClienteController {
	ClienteService clienteService;


	@Autowired
	public ManterClienteController(ClienteService cs) {
		clienteService = cs;
	}
	
	private Cliente carregarCliente(String email, String password) throws IOException{
		return clienteService.carregarCliente(email, password);
	}
	
	
	@RequestMapping("/validar_login")
	public String validarLogin(@RequestParam String email, @RequestParam String senha, Model model, HttpSession session) {
		try {
			System.out.println("email: " + email + " Senha: " + senha);
			session.setAttribute("clienteLogado", carregarCliente(email, senha));
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		
		return "index";
	}
	
	@RequestMapping("/logoff")
	public String logoffSession(HttpSession session) {
		session.removeAttribute("clienteLogado");
		return "redirect:/index";
	}

	@RequestMapping("/excluirCliente")
	public ModelAndView excluirUmCliente(@RequestParam int id) {
		clienteService.excluirCliente(id);
		return new ModelAndView("redirect:/adminCliente");
	}

	@RequestMapping("/atualizarCliente")
	public String telaAtualizarCliente(@RequestParam int idCliente, @Valid Cliente cliente, BindingResult result, Model model) {
		cliente = clienteService.selecionarCliente(idCliente);
		model.addAttribute("clientes", cliente);
		return "atualizarCliente";
	}

	@RequestMapping("/atualizarUmCliente")
	public ModelAndView atualizarUmCliente(@Valid Cliente cliente, @RequestParam int idCliente, BindingResult result) {
		clienteService.atualizarCliente(cliente);
		return new ModelAndView("redirect:/adminCliente");
	}

	@RequestMapping("/cadastrarCliente")
	public String cadastrarNovoCliente(@Valid Cliente cliente) {
		try {
			clienteService.cadastrarCliente(cliente);
			return "index";
		}catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

}
