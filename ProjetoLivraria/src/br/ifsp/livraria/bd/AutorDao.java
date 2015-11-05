package br.ifsp.livraria.bd;

import java.util.ArrayList;

import br.ifsp.livraria.pojo.Autor;

public interface AutorDao {

	public void cadastrarAutor(Autor autor);

	public ArrayList<Autor> obterAutor();

}
