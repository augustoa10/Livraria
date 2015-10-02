package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ifsp.livraria.pojo.Livro;

public class JDBCLivroDao implements LivroDao {

	@Override
	public void cadastrarLivro(Livro livro) {
		try {
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "insert into livro (isbn,titulo,dataPublicacao,"
					+ "categoria,precoVenda,resumo,indice"
					+ "precoCusto,margemLucro,estoque,autor,editora) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setInt(1, livro.getIsbn());
			comando.setString(2, livro.getTitulo());
			comando.setString(3, livro.getDataDePublicacao());
			comando.setString(4, livro.getCategoria());
			comando.setDouble(5, livro.getPrecoDeVenda());
			comando.setString(6, livro.getResumo());
			comando.setString(7, livro.getIndice());
			comando.setDouble(8, livro.getPrecoDeCusto());
			comando.setDouble(9, livro.getMargemDeLucro());
			comando.setDouble(10, livro.getQuantidadeEmEstoque());
			comando.setString(11, livro.getEditora().toString());
			comando.setString(12, livro.getAutores());

			comando.execute();
			comando.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
