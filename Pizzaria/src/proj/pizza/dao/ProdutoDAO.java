package proj.pizza.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import proj.pizza.bean.Produto;

@Repository
public class ProdutoDAO {
	@PersistenceContext
	EntityManager manager;
	
	
	public int criar(Produto produto) throws IOException{
		manager.persist(produto);
		return produto.getCodigo();
	}
	
	public int atualizar(Produto produto) throws IOException{
//		Produto produto2 = manager.merge(produto);
//		produto2.setCodigo(produto.getCodigo());
//		produto2.setDesconto(produto.getDesconto());
//		produto2.setDescricao(produto.getDescricao());
//		produto2.setImgSource(produto.getImgSource());
//		produto2.setNome(produto.getNome());
//		produto2.setPreco(produto.getPreco());
//		produto2.setTipo(produto.getTipo());
		manager.merge(produto);
		return produto.getCodigo();
	}
	
	public int remover(Produto produto) throws IOException {
		manager.merge(produto);
		return produto.getCodigo();
	}
	
	public Produto selecionar(int codigo) throws IOException {
		return manager.find(Produto.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProduto(String tipo) throws IOException{
		System.out.println("O tipo é: "+tipo);
		String jpql;
		Query query;
		if(tipo.equals("all")) {
			jpql = "select p from Produto p";
			query = manager.createQuery(jpql);
		}
		else {
			jpql = "select p from Produto p where p.tipo = :tipo";
			query = manager.createQuery(jpql);
			query.setParameter("tipo", tipo);
		}
		
		List<Produto> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutoAtivo(String tipo) throws IOException{
		System.out.println("O tipo é: "+tipo);
		String jpql;
		Query query;
		if(tipo.equals("all")) {
			jpql = "select p from Produto p where p.deletado = :deletado";
			query = manager.createQuery(jpql);
			query.setParameter("deletado", Produto.NAO);
		}
		else {
			jpql = "select p from Produto p where p.tipo = :tipo and p.deletado = :deletado";
			query = manager.createQuery(jpql);
			query.setParameter("tipo", tipo);
			query.setParameter("deletado", Produto.NAO);
		}
		
		List<Produto> result = query.getResultList();
		return result;
	}
}
