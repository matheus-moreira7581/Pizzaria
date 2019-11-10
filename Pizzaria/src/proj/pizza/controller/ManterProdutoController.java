package proj.pizza.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import proj.pizza.bean.Produto;
import proj.pizza.service.ProdutoService;

@Controller
public class ManterProdutoController {
	ProdutoService produtoService;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	public ManterProdutoController(ProdutoService ps) {
		produtoService = ps;

	}
	
	@RequestMapping("/novoProduto")
	public String telaNovoProduto() {
		return "cadastroProduto";
	}

	@RequestMapping("/produto")
	public String selecionarProduto(@RequestParam int id,@Valid Produto produto, BindingResult result, Model model) {
		try {
			produto = produtoService.selecionarProduto(id);
			model.addAttribute("produtos", produto);
			return "produto";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping(value ="/listarProduto", method = RequestMethod.GET)
	public String telaListaProdutos(@RequestParam String tipo,Model model) {
		try {
			List<Produto> produtos = produtoService.buscarProdutos(tipo);
			model.addAttribute("listProdutos", produtos);
			return "listaProduto";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		
	}

	@RequestMapping("/atualizarProduto")
	public String telaAtualizarProduto(@RequestParam int id,@Valid Produto produto, BindingResult result, Model model) {
		try {
			produto = produtoService.selecionarProduto(id);
			model.addAttribute("produtos", produto);
			return "atualizarProduto";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping(value ="/atualizarUmProduto", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public String atualizarUmProduto(@Valid Produto produto, Model model, @RequestParam("foto") MultipartFile foto) {
		try {
			produtoService.atualizarProduto(produto);
			produtoService.gravarImagem(servletContext, produto, foto);
			return "redirect:/adminProduto";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("/excluirProduto")
	public String excluirProduto(@RequestParam int id) {
		try {
			produtoService.removerProduto(id);
			return "redirect:/adminProduto";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}


	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public String cadastrarNovoProduto(@Valid Produto produto, @RequestParam("foto") MultipartFile foto) {
		try {
			produtoService.novoProduto(produto, foto);
			produtoService.gravarImagem(servletContext, produto, foto);
			return "redirect:/adminProduto";

		}catch (IOException e) {
			e.printStackTrace();
			return "redirect:/Pizzaria/index";
		}

	}
}
