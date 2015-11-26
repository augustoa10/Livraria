package br.ifsp.livraria.bd;

import java.util.ArrayList;

import br.ifsp.livraria.pojo.Livro;

public interface LivroDao {
	public void cadastrarLivro(Livro livro);
	public ArrayList<Livro> obterLivro();
}
