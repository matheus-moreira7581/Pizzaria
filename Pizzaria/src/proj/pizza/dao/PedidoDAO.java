package proj.pizza.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import proj.pizza.bean.Cliente;
import proj.pizza.bean.Pedido;

@Repository
public class PedidoDAO {
	@PersistenceContext
	EntityManager manager;
	
	public int inserirPedido(Pedido pedido) throws IOException {
		Cliente cliente = manager.find(Cliente.class, pedido.getCliente().getIdCliente());
		pedido.setCliente(cliente);
		manager.persist(pedido);
		return pedido.getIdPed();
	}
	
	
}
