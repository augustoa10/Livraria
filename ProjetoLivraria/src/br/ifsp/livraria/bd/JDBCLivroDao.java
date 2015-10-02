package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ifsp.livraria.pojo.Livro;

public class JDBCLivroDao implements LivroDao {

	@Override
	public void cadastrarLivro() {

		try {
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "insert into livro (isbn,titulo,dataDePublicacao,"
					+ "editora,categoria,precoDeVenda,resumo,indice,autor"
					+ "precoDeCusto,margemDeLucro,quantidadeEmEstoque) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);

			Livro livro = new Livro();
			comando.setInt(1, livro.getIsbn());
			comando.setString(2, livro.getTitulo());
			comando.setString(3, livro.getDataDePublicacao());
			comando.setString(4, livro.getEditora().toString());
			comando.setString(5, livro.getCategoria());
			comando.setDouble(6, livro.getPrecoDeVenda());
			comando.setString(7, livro.getResumo());
			comando.setString(8, livro.getIndice());
			comando.setString(9, livro.getAutores());
			comando.setDouble(10, livro.getPrecoDeCusto());
			comando.setDouble(11, livro.getMargemDeLucro());
			comando.setDouble(12, livro.getQuantidadeEmEstoque());

			comando.execute();
			comando.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
