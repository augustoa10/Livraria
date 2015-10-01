package br.ifsp.livraria.pojo;

 import java.util.ArrayList;
 import java.util.List;
 
 public class Livro {
 
 	//Todos os usu�rios
 	private int isbn;
 	private String titulo;
 	private String dataDePublicacao; 
 	private Editora editora; 
 	private String categoria; //Originalmente String
 	private double precoDeVenda;
 	private String resumo;
 	private String indice; //cap�tulos todos numerados
 	
 	private final List<Autor> autores = new ArrayList<Autor>(); 

 	//Somente usu�rios internos
 	private double precoDeCusto;
 	private double margemDeLucro;
 	private int quantidadeEmEstoque;
 	
 	//Construtor - todos os atributos exceto autores 
 	public Livro(int isbn, String titulo, String dataDePublicacao,
 			Editora editora, String categoria, double precoDeVenda,
 			String resumo, String indice, double precoDeCusto,
 			double margemDeLucro, int quantidadeEmEstoque) {
 		
 		this.isbn = isbn;
 		this.titulo = titulo;
 		this.dataDePublicacao = dataDePublicacao;
 		this.editora = editora;
 		this.categoria = categoria;
 		this.precoDeVenda = precoDeVenda;
 		this.resumo = resumo;
 		this.indice = indice;
 		this.precoDeCusto = precoDeCusto;
 		this.margemDeLucro = margemDeLucro;
 		this.quantidadeEmEstoque = quantidadeEmEstoque;
 		
 	}
 
 	public Integer getIsbn() {
 		return isbn;
 	}
 
 	public String getTitulo() {
 		return titulo;
 	}
 
 	public String getDataDePublicacao() {
 		return dataDePublicacao;
 	}
 
 	public Editora getEditora() {
 		return editora;
 	}
 
 	public String getCategoria() {
 		return categoria;
 	}
 
 	public double getPrecoDeVenda() {
 		return precoDeVenda;
 	}
 
 	public String getResumo() {
 		return resumo;
 	}
 
 	public String getIndice() {
 		return indice;
 	}
 
 	public List<Autor> getAutores() {
 		return autores;
 	}
 
 	public double getPrecoDeCusto() {
 		return precoDeCusto;
 	}
 
 	public double getMargemDeLucro() {
 		return margemDeLucro;
 	}
 	
 	public int getQuantidadeEmEstoque() {
 		return quantidadeEmEstoque;
	}	
}