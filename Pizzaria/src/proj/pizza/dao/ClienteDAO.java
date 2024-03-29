package proj.pizza.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import proj.pizza.bean.Cliente;



@Repository
public class ClienteDAO {
	@PersistenceContext
	EntityManager manager;
	
	
	public int criar(Cliente cliente) throws IOException {
		manager.persist(cliente);
		return cliente.getIdCliente();
	}
	
	
	public void excluirCliente(Cliente cliente) throws IOException {
		manager.merge(cliente);
	}
	
	public Cliente selecionar(int id) throws IOException {
		return manager.find(Cliente.class, id);
	}
	
	public Cliente carregar(String email, String senha) throws IOException{
		String jpql = "select c from Cliente c where c.email=:email and c.senha=:senha and c.deletado=:deletado";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		query.setParameter("deletado", Cliente.NAO);
		
		Cliente resultado = (Cliente)query.getSingleResult();
		System.out.println("retornado: " + resultado.getEmail());
		return resultado;
		
	}
	
	
	
	public int atualizar(Cliente cliente) throws IOException {
//		Cliente cliente2 = manager.merge(cliente);
//		cliente2.setIdCliente(cliente.getIdCliente());
//		cliente2.setCpf(cliente.getCpf());
//		cliente2.setEmail(cliente.getEmail());
//		cliente2.setEndereco(cliente.getEndereco());
//		cliente2.setNome(cliente.getNome());
//		cliente2.setSobrenome(cliente.getSobrenome());
//		cliente2.setNumCasa(cliente.getNumCasa());
//		cliente2.setSenha(cliente.getSenha());
		manager.merge(cliente);
		return cliente.getIdCliente();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes() throws IOException {
		String jpql = "select c from Cliente c";
		Query query = manager.createQuery(jpql);
		
		List<Cliente> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientesAtivos() throws IOException {
		String jpql = "select c from Cliente c where c.deletado=:deletado";
		Query query = manager.createQuery(jpql);
		query.setParameter("deletado", Cliente.NAO);
		
		List<Cliente> result = query.getResultList();
		return result;
	}
	

}
