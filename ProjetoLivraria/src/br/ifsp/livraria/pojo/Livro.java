package br.ifsp.livraria.pojo;

public class Livro {

	//Todos os usuários
	private int isbn;
	private String titulo;
	private String dataDePublicacao; 
	private String editora; 
	private String categoria; //Originalmente String
	private double precoDeVenda;
	private String resumo;
	private String indice; //capítulos todos numerados
	
	private String autores;
	
	//Somente usuários internos
	private double precoDeCusto;
	private double margemDeLucro;
	private int quantidadeEmEstoque;
	
	public Integer getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDataDePublicacao() {
		return dataDePublicacao;
	}

	public String getEditora() {
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

	public double getPrecoDeCusto() {
		return precoDeCusto;
	}

	public double getMargemDeLucro() {
		return margemDeLucro;
	}
	
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDataDePublicacao(String dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPrecoDeVenda(double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public void setPrecoDeCusto(double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}

	public void setMargemDeLucro(double margemDeLucro) {
		this.margemDeLucro = margemDeLucro;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	public void setAutoresInc(String autores) {
		this.autores += autores;
	}
	
}
