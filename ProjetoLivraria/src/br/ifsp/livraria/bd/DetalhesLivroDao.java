package br.ifsp.livraria.bd;

import br.ifsp.livraria.pojo.DetalhesLivro;
import br.ifsp.livraria.pojo.Livro;

public interface DetalhesLivroDao {
	public DetalhesLivro pesquisaDetalhesLivro(String titulo);
	public Livro pesquisaLivroPorTitulo(String titulo);
}
