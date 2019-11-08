package proj.pizza.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.pizza.bean.Administrator;
import proj.pizza.dao.AdministratorDAO;

@Service
public class AdministratorService {
	
	private AdministratorDAO dao;
	
	@Autowired
	public AdministratorService(AdministratorDAO dao) {
		this.dao = dao;
	}
	
	public Administrator carregarAdmin(String user, String senha) throws IOException {
		Administrator admin = dao.carregar(user, senha);
		
		if(user.equals(admin.getUser()) && senha.equals(admin.getSenha())) {
			System.out.println("Admin logado com sucesso, ID do admin: " + admin.getCodAdm());
			return admin;
		}
		else {
			System.out.println("Banco de dados: " + admin.getUser() + " / " + admin.getSenha());
			System.out.println("Interface: " + user + " / " + senha);
			System.out.println("As senhas são diferentes");
			return null;
		}
	}
}
