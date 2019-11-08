package proj.pizza.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class ManterPedidoController {
	ProdutoService produtoService;
	ClienteService clienteService;
	PedidoService pedidoService;
	ItemPedidoService itemPedidoService;
	AdministratorService administratorService;


	@Autowired
	public ManterPedidoController(ProdutoService ps, PedidoService pds, ItemPedidoService ips) {
		produtoService = ps;
		pedidoService = pds;
		itemPedidoService = ips;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/addCarrinho")
	public String addCarrinho(@RequestParam int codigoProduto,@RequestParam int qtdProduto,HttpSession session, Model model) {
		List<Produto> listaProduto = new ArrayList<>();
		if(null != session.getAttribute("Carrinho")) {
			listaProduto = (List<Produto>)session.getAttribute("Carrinho");
		}
		Produto produto = produtoService.selecionarProduto(codigoProduto);
		produto.setQtdProduto(qtdProduto);
		listaProduto.add(produto);
		float desconto = 0;
		float subTotal = 0;
		float total = 0;
		for (Produto produtos : listaProduto) {
			desconto += produtos.getDesconto();
			subTotal += (produtos.getPreco() * produto.getQtdProduto());
		}
		total = subTotal - desconto;
		model.addAttribute("Total", total);
		model.addAttribute("Desconto", desconto);
		model.addAttribute("SubTotal", subTotal);
		session.setAttribute("Carrinho", listaProduto);
		return "redirect:/carrinho";
	}

	@RequestMapping("/confirmacao")
	public String gerarPedido(Pedido pedido, HttpSession session, Model model, @RequestParam String bairro, 
			@RequestParam String endereco, @RequestParam int numCasa, @RequestParam String formaPagamento) {

		try {
			Cliente cliente = (Cliente)session.getAttribute("clienteLogado");
			criarPedido(pedido, bairro, endereco, numCasa, formaPagamento, cliente);
			model.addAttribute(pedido);
			@SuppressWarnings("unchecked")
			List<Produto> carrinho = (List<Produto>)session.getAttribute("Carrinho");
			criarItemPedido(pedido, carrinho);
			session.removeAttribute("Carrinho");
		} catch (IOException e) {
			return "error";
		}
		return "confirmacao";
	}

	private void criarItemPedido(Pedido pedido, List<Produto> carrinho) throws IOException {
		for (Produto produto : carrinho) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setDesconto(produto.getDesconto());
			itemPedido.setNome(produto.getNome());
			itemPedido.setPedido(pedido);
			itemPedido.setProduto(produto);
			itemPedido.setPreco(produto.getPreco());
			itemPedido.setQtdItem(produto.getQtdProduto());
			itemPedidoService.criarItemPedido(itemPedido);
		}
	}

	private void criarPedido(Pedido pedido, String bairro, String endereco, int numCasa, String formaPagamento,
			Cliente cliente) throws IOException {
		pedido.setCliente(cliente);
		pedido.setBairro(bairro);
		pedido.setEndereco(endereco);
		pedido.setNumEndereco(numCasa);
		pedido.setNome(cliente.getNome());
		pedido.setFormaPagamento(formaPagamento);
		pedido.setDataEmissao(new Date());
		pedidoService.criarPedido(pedido);
	}	
}
