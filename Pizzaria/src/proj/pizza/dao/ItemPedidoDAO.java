package proj.pizza.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import proj.pizza.bean.Cliente;
import proj.pizza.bean.ItemPedido;

@Repository
public class ItemPedidoDAO {
	@PersistenceContext
	EntityManager manager;
	
	public void inserirItemPedido(ItemPedido itemPedido) throws IOException{
		manager.persist(itemPedido);
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemPedido> listaritensPedido() throws IOException {
		String jpql = "select i from ItemPedido i";
		Query query = manager.createQuery(jpql);
		
		List<ItemPedido> result = query.getResultList();
		return result;
	}
}
