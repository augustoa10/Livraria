package br.ifsp.livraria.bd;

import java.util.ArrayList;

import br.ifsp.livraria.pojo.PesquisaLivro;

public interface PesquisaLivroDao {

	public ArrayList<PesquisaLivro> listaLivroTitulo(String titulo);
	public ArrayList<PesquisaLivro> listaLivroAutor(String autor);
	
}
