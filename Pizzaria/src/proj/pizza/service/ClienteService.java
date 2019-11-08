package proj.pizza.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.pizza.bean.Cliente;
import proj.pizza.dao.ClienteDAO;



@Service
public class ClienteService {
	
	private ClienteDAO dao;
	
	@Autowired
	public ClienteService(ClienteDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public int cadastrarCliente(Cliente cliente)throws IOException{
		return dao.criar(cliente);
	}
	
	@Transactional
	public void excluirCliente(int id) {
		dao.excluirCliente(id);
	}
	
	@Transactional
	public int atualizarCliente(Cliente cliente) {
		return dao.atualizar(cliente);
	}
	
	public Cliente selecionarCliente(int id) {
		return dao.selecionar(id);
	}
	
	public Cliente carregarCliente(String email, String senha) throws IOException {
		Cliente cliente = dao.carregar(email, senha);
		
		if (email.equals(cliente.getEmail()) && senha.equals(cliente.getSenha())) {
			System.out.println("O id do cliente logado é: " + cliente.getIdCliente());
			return cliente;
		}
		else {
			System.out.println("Banco de dados: " + cliente.getEmail() + " / " + cliente.getSenha());
			System.out.println("Interface: " + email + " / " + senha);
			System.out.println("As senhas são diferentes");
			return null;
		}
	}
	
	
	
	public List<Cliente> listarClientes() throws IOException{
		return dao.listarClientes();
	}
	
	
	
}
