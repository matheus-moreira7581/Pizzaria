package proj.pizza.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import proj.pizza.bean.Administrator;

@Repository
public class AdministratorDAO {
	@PersistenceContext
	EntityManager manager;
	
	public void criar(Administrator administrator) throws IOException {
		manager.persist(administrator);
	}
	
	public void atualizar(Administrator administrator) throws IOException {
		manager.merge(administrator);
	}
	
	public Administrator selecionar(int codAdm) throws IOException {
		return manager.find(Administrator.class, codAdm);
	}
	
	public Administrator carregar(String user, String senha) throws IOException{
		String jpql = "select a from Administrator a where a.user=:user and a.senha=:senha";
		Query query = manager.createQuery(jpql);
		query.setParameter("user", user);
		query.setParameter("senha", senha);
		
		Administrator resultado = (Administrator)query.getSingleResult();
		return resultado;
		
	}
	
	
}
