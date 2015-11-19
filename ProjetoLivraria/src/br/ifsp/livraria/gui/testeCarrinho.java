package br.ifsp.livraria.gui;

import java.util.ArrayList;

import br.ifsp.livraria.pojo.Carrinho;
import br.ifsp.livraria.pojo.Cliente;
import br.ifsp.livraria.pojo.Livro;

public class testeCarrinho {
	
public static void main(String[] args) {
		
		
		Cliente c1 = new Cliente();
		c1.setNome("Felipe");
		
		Livro l1 = new Livro();
		l1.setTitulo("Livro 1");
		l1.setIndice("1");
		l1.setEstoque(10);
		l1.setPrecoVenda(10.50);
		
		Livro l2 = new Livro();
		l2.setIndice("2");
		l2.setTitulo("Livro 2");
		l2.setEstoque(15);
		l2.setPrecoVenda(15.50);
		
		ArrayList<Livro> livros = new ArrayList<Livro>();
		livros.add(l1);
		livros.add(l2);
		
		Carrinho car = new Carrinho();
		car.setCliente(c1);
		car.setLivros(livros);		
		
		CarrinhoUI lc = new CarrinhoUI(car);
		lc.setVisible(true);
	}

}
