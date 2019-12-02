package proj.pizza.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;
	
	@NotNull
	@Column(name="cpf")
	private String cpf;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@NotNull
	@Column(name="sobrenome")
	private String sobrenome;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	
	@Column(name="bairro")
	private String bairro;
	
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numEndereco")
	private int numCasa;
	
	@NotNull
	@Column(name="senha")
	private String senha;
	
	@NotNull
	@Column(name="deletado")
	private String deletado;
	
	public static final String SIM = "sim";
	public static final String NAO = "nao";
	
//	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//	private List<Pedido> pedidos;
	
	public String getDeletado() {
		return deletado;
	}

	public void setDeletado(String deletado) {
		this.deletado = deletado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", email=" + email + ", bairro=" + bairro + ", endereco=" + endereco + ", numCasa=" + numCasa
				+ ", senha=" + senha + ", deletado=" + deletado + "]";
	}
}
