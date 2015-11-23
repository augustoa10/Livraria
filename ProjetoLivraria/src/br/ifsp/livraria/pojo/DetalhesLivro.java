package br.ifsp.livraria.pojo;

public class DetalhesLivro {
	private String livroTitulo;
	private String resumo;
	private String sumario;
	private String autorNome;
	private String nomeEditora;
	private double preco;
	
	public String getLivroTitulo() {
		return livroTitulo;
	}
	public void setLivroTitulo(String livroTitulo) {
		this.livroTitulo = livroTitulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public String getAutorNome() {
		return autorNome;
	}
	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}
	public String getNomeEditora() {
		return nomeEditora;
	}
	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
	//Titulo - Resumo - Sumario - Info autor - Info Editora - pre�o 
}
