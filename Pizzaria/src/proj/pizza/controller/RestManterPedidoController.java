package proj.pizza.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import proj.pizza.bean.Cliente;
import proj.pizza.bean.ItemPedido;
import proj.pizza.bean.Pedido;
import proj.pizza.bean.Produto;
import proj.pizza.service.AdministratorService;
import proj.pizza.service.ClienteService;
import proj.pizza.service.ItemPedidoService;
import proj.pizza.service.PedidoService;
import proj.pizza.service.ProdutoService;

@Controller
public class RestManterPedidoController {
	ProdutoService produtoService;
	PedidoService pedidoService;
	ItemPedidoService itemPedidoService;
	ClienteService clienteService;


	@Autowired
	public RestManterPedidoController(ProdutoService ps, PedidoService pds, ItemPedidoService ips, ClienteService cs) {
		produtoService = ps;
		pedidoService = pds;
		itemPedidoService = ips;
		clienteService = cs;
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="rest/listaItemPedido")
	public @ResponseBody List<ItemPedido> restListaItemPedido() {
		List<ItemPedido> itensPedido = null;
		try {
			itensPedido = itemPedidoService.buscarItensPedido();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return itensPedido;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/listarPedido")
	public @ResponseBody List<Pedido> restLitarPedido() {
		List<Pedido> pedidos = null;
		try {
			pedidos = pedidoService.buscarPedido();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pedidos;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "rest/gerarPedido")
	public ResponseEntity<Pedido> restGerarPedido(@RequestBody Pedido pedido) {
		try {
			pedidoService.criarPedido(pedido);
			return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
			
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Pedido>(pedido, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "rest/criarItemPedido")
	public ResponseEntity<ItemPedido> resetCriarItemPedido(@RequestBody ItemPedido itemPedido) {
		try {
			itemPedidoService.criarItemPedido(itemPedido);
			return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
