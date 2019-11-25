package proj.pizza.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import proj.pizza.bean.Produto;
import proj.pizza.dao.ProdutoDAO;

@Service
public class ProdutoService {
	ProdutoDAO dao;
	
	@Autowired
	public ProdutoService(ProdutoDAO dao) {
		this.dao = dao;
	}
	
	@Transactional
	public int novoProduto(Produto produto, MultipartFile img) throws IOException {
		produto.setDeletado(Produto.NAO);
		return dao.criar(produto);
	}
	
	@Transactional
	public void gravarImagem(ServletContext servletContext, Produto produto, MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			String path = servletContext.getRealPath(servletContext.getContextPath());
			System.out.println(path);
			path = path.substring(0, path.lastIndexOf(File.separatorChar));
			String nomeArquivo = "img"+produto.getCodigo()+".jpg";
			produto.setImgSource(nomeArquivo);
			atualizarProduto(produto);
			File destination = new File(path + File.separatorChar + "img" + File.separatorChar + nomeArquivo);
			if(destination.exists()) {
				destination.delete();
			}
			ImageIO.write(src, "jpg", destination);
		}
		
	}
	
	@Transactional
	public int atualizarProduto(Produto produto) throws IOException{
		produto.setDeletado(Produto.NAO);
		return dao.atualizar(produto);
	}
	
	@Transactional
	public int removerProduto(int id) throws IOException{
		Produto produto = selecionarProduto(id);
		produto.setDeletado(Produto.SIM);
		return dao.remover(produto);
	}
	
	public Produto selecionarProduto(int codigo) throws IOException{
		return dao.selecionar(codigo);
	}
	
	public List<Produto> buscarProdutos(String tipo) throws IOException{
		return dao.listarProduto(tipo);
	}
	
public List<Produto> buscarProdutosAtivos(String tipo) throws IOException{
		return dao.listarProdutoAtivo(tipo);
	}
	
}
