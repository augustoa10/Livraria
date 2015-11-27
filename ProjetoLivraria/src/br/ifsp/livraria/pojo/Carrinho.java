package br.ifsp.livraria.pojo;

import java.util.ArrayList;

public class Carrinho {
	public static Carrinho carro = new Carrinho();
	

	private Cliente cliente;
	private int qtdeTotal;
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getQtdeTotal() {
		return qtdeTotal;
	}
	public void setQtdeTotal(int qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
}
