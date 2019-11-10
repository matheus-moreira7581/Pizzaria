package proj.pizza.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.pizza.bean.ItemPedido;
import proj.pizza.bean.Pedido;
import proj.pizza.bean.Produto;
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
	
	@Transactional
	public void criarItemPedido(Pedido pedido, List<Produto> produtos) throws IOException{
		for (Produto produto : produtos) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setDesconto(produto.getDesconto());
			itemPedido.setNome(produto.getNome());
			itemPedido.setPedido(pedido);
			itemPedido.setProduto(produto);
			itemPedido.setPreco(produto.getPreco());
			itemPedido.setQtdItem(produto.getQtdProduto());
			dao.inserirItemPedido(itemPedido);
		}
		
	}
	
	public List<ItemPedido> buscarItensPedido() throws IOException {
		return dao.listaritensPedido();
	}
}
