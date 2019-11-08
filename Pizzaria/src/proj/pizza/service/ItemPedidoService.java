package proj.pizza.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.pizza.bean.ItemPedido;
import proj.pizza.dao.ItemPedidoDAO;

@Service
public class ItemPedidoService {
	ItemPedidoDAO dao;
	
	@Autowired
	public ItemPedidoService(ItemPedidoDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public void criarItemPedido(ItemPedido itemPedido) throws IOException{
		dao.inserirItemPedido(itemPedido);
	}
}
