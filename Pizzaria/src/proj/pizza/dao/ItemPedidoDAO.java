package proj.pizza.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import proj.pizza.bean.ItemPedido;

@Repository
public class ItemPedidoDAO {
	@PersistenceContext
	EntityManager manager;
	
	public void inserirItemPedido(ItemPedido itemPedido) throws IOException{
		manager.persist(itemPedido);
	}
}
