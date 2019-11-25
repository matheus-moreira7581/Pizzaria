package proj.pizza.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import proj.pizza.bean.Cliente;
import proj.pizza.bean.Produto;
import proj.pizza.service.ProdutoService;

@Controller
public class RestManterProdutoController {
	ProdutoService produtoService;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	public RestManterProdutoController(ProdutoService ps) {
		produtoService = ps;

	}

	@RequestMapping(method = RequestMethod.GET,value = "rest/produto")
	public @ResponseBody Produto restSelecionarProduto(@RequestParam int id) {
		Produto produto = null;
		try {
			produto = produtoService.selecionarProduto(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return produto;
	}

	@RequestMapping( method = RequestMethod.GET, value ="rest/listarProduto")
	public @ResponseBody List<Produto> restListaProdutos(@RequestParam String tipo) {
		List<Produto> produtos = null;
		try {
			produtos = produtoService.buscarProdutosAtivos(tipo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return produtos;
	}



	@RequestMapping(method = RequestMethod.POST, value ="rest/atualizarUmProduto", consumes = {"multipart/form-data"})
	public ResponseEntity<Produto> restAtualizarUmProduto(Produto produto, @RequestParam("foto") MultipartFile foto) {
		try {
			produtoService.atualizarProduto(produto);
			produtoService.gravarImagem(servletContext, produto, foto);
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Produto>(produto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "rest/excluirProduto")
	public ResponseEntity<Produto> restExcluirProduto(@RequestParam int id) {
		Produto produto = null;
		try {
			produto = produtoService.selecionarProduto(id);
			produtoService.removerProduto(id);
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Produto>(produto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(method = RequestMethod.POST, value = "rest/cadastrarProduto", consumes = {"multipart/form-data"})
	public ResponseEntity<Produto> cadastrarNovoProduto(@Valid Produto produto, @RequestParam("foto") MultipartFile foto) {
		try {
			produtoService.novoProduto(produto, foto);
			produtoService.gravarImagem(servletContext, produto, foto);
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);

		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Produto>(produto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
