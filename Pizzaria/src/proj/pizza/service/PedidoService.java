package proj.pizza.service;

import java.io.IOException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.pizza.bean.Pedido;
import proj.pizza.dao.PedidoDAO;

@Service
public class PedidoService {
	PedidoDAO dao;
	
	@Autowired
	public PedidoService(PedidoDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public int criarPedido(Pedido pedido) throws IOException{
		return dao.inserirPedido(pedido);
	}
}
