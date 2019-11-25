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
		cliente.setDeletado(Cliente.NAO);
		return dao.criar(cliente);
	}
	
	@Transactional
	public void excluirCliente(int id) throws IOException{
		Cliente cliente = selecionarCliente(id);
		cliente.setDeletado(Cliente.SIM);
		dao.excluirCliente(cliente);
		System.out.println("Cliente Deletado > " + cliente.toString());
	}
	
	@Transactional
	public int atualizarCliente(Cliente cliente) throws IOException {
		cliente.setDeletado(Cliente.NAO);
		return dao.atualizar(cliente);
	}
	
	public Cliente selecionarCliente(int id) throws  IOException {
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
	
	public List<Cliente> listarClientesAtivos() throws IOException{
		return dao.listarClientesAtivos();
	}
	
	
	
}
