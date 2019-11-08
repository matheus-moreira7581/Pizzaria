package proj.pizza.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private int codigo;
	
	//@Max(value=50, message="O nome só pode conter até 50 caracteres")
	@NotNull
	@Column(name="nome")
	private String nome;
	
	//@Max(value=5, message="O preço só poder ter até no maximo 5 caracteres")
	@NotNull
	@Column(name="preco")
	private float preco;
	
	@NotNull
	@Column(name="desconto")
	private float desconto;
	
	//@Max(value=250, message="A descrição só pode conter até 250 caracteres")
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="image_source")
	private String imgSource;
	
	@NotNull
	@Column(name="tipo")
	private String tipo;
	
	private int qtdProduto;
	
	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public static final String HAMBURGUER = "Hamburguer";
	public static final String PIZZA = "Pizza";
	public static final String ALL = "all";
	


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public String getImgSource() {
		return imgSource;
	}

	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	
	
}
