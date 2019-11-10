package proj.pizza.controller;



import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import proj.pizza.bean.Cliente;
import proj.pizza.service.ClienteService;

@Controller
public class RestManterClienteController {
	ClienteService clienteService;


	@Autowired
	public RestManterClienteController(ClienteService cs) {
		clienteService = cs;
	}
	
	private Cliente carregarCliente(String email, String password) throws IOException{
		return clienteService.carregarCliente(email, password);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/validar_login")
	public @ResponseBody Cliente restValidarLogin(@RequestParam String email, @RequestParam String senha, HttpSession session) {
		Cliente cliente = null;
		try {
			cliente = carregarCliente(email, senha);
			session.setAttribute("clienteLogado", cliente);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/excluirCliente")
	public ResponseEntity<Cliente> restExcluirUmCliente(@RequestParam int id) {
		Cliente cliente = null;
		try {
			cliente = clienteService.selecionarCliente(id);
			clienteService.excluirCliente(cliente.getIdCliente());
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "rest/atualizarUmCliente")
	public ResponseEntity<Cliente> atualizarUmCliente(@RequestBody @Valid Cliente cliente, @RequestParam int idCliente) {
		try {
			clienteService.atualizarCliente(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "rest/cadastrarCliente")
	public ResponseEntity<Cliente> cadastrarNovoCliente(@RequestBody @Valid Cliente cliente) {
		try {
			clienteService.cadastrarCliente(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
