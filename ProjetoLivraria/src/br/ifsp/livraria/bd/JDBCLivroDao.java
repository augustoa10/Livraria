package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.livraria.pojo.Livro;

public class JDBCLivroDao implements LivroDao {

	@Override
	public void cadastrarLivro(Livro livro) {
		try {
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "insert into Livro (idAutor, idEditora, isbn, titulo, dataPublicacao, categoria, precoVenda, resumo, indice, precoCusto, margemLucro, estoque) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, livro.getIdAutor());
			comando.setInt(2, livro.getIdEditora());
			comando.setInt(3, livro.getIsbn());
			comando.setString(4, livro.getTitulo());
			comando.setString(5, livro.getDataPublicacao());
			comando.setString(6, livro.getCategoria());
			comando.setDouble(7, livro.getPrecoVenda());
			comando.setString(8, livro.getResumo());
			comando.setString(9, livro.getIndice());
			comando.setDouble(10, livro.getPrecoCusto());
			comando.setDouble(11, livro.getMargemLucro());
			comando.setDouble(12, livro.getEstoque());
			
		

			comando.execute();
			comando.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	//M�todo para obter isbns e titulos do banco
	public ArrayList<Livro> obterLivro() {
		try{
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "select * from livro";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			ResultSet resultado = comando.executeQuery();
			
			ArrayList<Livro> listaLivro = new ArrayList<Livro>();
						
			while(resultado.next()){
				Livro livro = new Livro();
				livro.setIsbn(resultado.getInt("isbn"));
				livro.setTitulo(resultado.getString("titulo"));		
				listaLivro.add(livro);	
			}
			conexao.close();
			return listaLivro;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
