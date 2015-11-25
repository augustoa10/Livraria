package br.ifsp.livraria.bd;

import java.util.ArrayList;

import br.ifsp.livraria.pojo.Livro;

public interface CarrinhoDao {
	
	public void finalizarCompra(ArrayList<Livro> livros);

}
