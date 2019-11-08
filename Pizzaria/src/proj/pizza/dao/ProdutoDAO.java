package proj.pizza.dao;

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
	
	
	public int criar(Produto produto) {
		manager.persist(produto);
		return produto.getCodigo();
	}
	
	public int atualizar(Produto produto) {
		Produto produto2 = manager.merge(produto);
		produto2.setCodigo(produto.getCodigo());
		produto2.setDesconto(produto.getDesconto());
		produto2.setDescricao(produto.getDescricao());
		produto2.setImgSource(produto.getImgSource());
		produto2.setNome(produto.getNome());
		produto2.setPreco(produto.getPreco());
		produto2.setTipo(produto.getTipo());
		
		return produto2.getCodigo();
	}
	
	public int remover(int id) {
		Produto produto = manager.find(Produto.class, id);
		manager.remove(produto);
		return produto.getCodigo();
	}
	
	public Produto selecionar(int codigo) {
		return manager.find(Produto.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProduto(String tipo) {
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
}
