package proj.pizza.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="administrator")
public class Administrator implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="codAdm")
	private int codAdm;
	
	@Max(value=50, message="O nome nao pode ter mais de 50 caracteres")
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@Max(value=50, message="O usuario nao pode ter mais de 50 caracteres")
	@NotNull
	@Column(name="user")
	private String user;
	
	@Max(value=50, message="A senha nao pode ter mais de 50 caracteres")
	@NotNull
	@Column(name="senha")
	private String senha;
	
	@Max(value=100, message="O email nao pode ter mais de 100 caracteres")
	@NotNull
	@Column(name="email")
	private String email;

	public int getCodAdm() {
		return codAdm;
	}

	public void setCodAdm(int codAdm) {
		this.codAdm = codAdm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
