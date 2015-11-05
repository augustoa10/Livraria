package br.ifsp.livraria.bd;

import java.util.ArrayList;

import br.ifsp.livraria.pojo.Editora;

public interface EditoraDao {

	public void cadastrarEditora(Editora editora);

	public ArrayList<Editora> obterEditora();
	
}

