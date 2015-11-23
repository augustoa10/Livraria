package br.ifsp.livraria.bd;

import br.ifsp.livraria.pojo.DetalhesLivro;

public interface DetalhesLivroDao {
	public DetalhesLivro pesquisaDetalhesLivro(String titulo);
}
