package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ifsp.livraria.pojo.Livro;

public class JDBCLivroDao implements LivroDao {

	@Override
	public void cadastrarLivro(Livro livro) {
		try {
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "insert into Livro (isbn,titulo,dataPublicacao, categoria,precoVenda,resumo,indice, precoCusto,margemLucro,estoque,autor,editora) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, livro.getIsbn());
			comando.setString(2, livro.getTitulo());
			comando.setString(3, livro.getDataPublicacao());
			comando.setString(4, livro.getCategoria());
			comando.setDouble(5, livro.getPrecoVenda());
			comando.setString(6, livro.getResumo());
			comando.setString(7, livro.getIndice());
			comando.setDouble(8, livro.getPrecoCusto());
			comando.setDouble(9, livro.getMargemLucro());
			comando.setDouble(10, livro.getEstoque());
			comando.setString(11, livro.getAutores());
			comando.setString(12, livro.getEditora());
		

			comando.execute();
			comando.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
