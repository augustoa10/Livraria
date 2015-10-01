package br.ifsp.livraria.pojo;

 import java.util.ArrayList;
 import java.util.List;
 
 public class Livro {
 
 	//Todos os usuários
 	private int isbn;
	private String titulo;
 	private String dataDePublicacao; 
 	private Editora editora; 
 	private String categoria; 
 	private double precoDeVenda;
 	private String resumo;
 	private String indice; 
 	
 	//Somente usuários internos
 	private double precoDeCusto;
 	private double margemDeLucro;
 	private int quantidadeEmEstoque;

 	private final List<Autor> autores = new ArrayList<Autor>();

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataDePublicacao() {
		return dataDePublicacao;
	}
	public void setDataDePublicacao(String dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getIndice() {
		return indice;
	}
	public void setIndice(String indice) {
		this.indice = indice;
	}
	public double getPrecoDeCusto() {
		return precoDeCusto;
	}
	public void setPrecoDeCusto(double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}
	public double getMargemDeLucro() {
		return margemDeLucro;
	}
	public void setMargemDeLucro(double margemDeLucro) {
		this.margemDeLucro = margemDeLucro;
	}
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public List<Autor> getAutores() {
		return autores;
	}
}
