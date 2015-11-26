package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.livraria.pojo.PesquisaLivro;

public class JDBCPesquisaLivroDao implements PesquisaLivroDao {

	//busca de livro por titulo
	public ArrayList<PesquisaLivro> listaLivroTitulo(String titulo)
	{
		
		try
		{
		Connection conexao = ConnectionFactory.createConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			stmt = conexao.prepareStatement("select l.titulo, a.nome, l.precoVenda from livro l inner join autor a using (idAutor) where l.titulo like ?");			
			stmt.setString(1, "%" + titulo+ "%");
			rs = stmt.executeQuery();
		
		ArrayList<PesquisaLivro> fichaLivro = new ArrayList<PesquisaLivro>();

			while(rs.next())
			{
				PesquisaLivro livro = new PesquisaLivro();
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("nome"));
				livro.setPrecoVenda(rs.getDouble("precoVenda"));
				
				fichaLivro.add(livro);
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			
			return fichaLivro;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}	
	}
	
	
	//busca de livro por autor
	public ArrayList<PesquisaLivro> listaLivroAutor(String autor)
	{
		
		try
		{
		Connection conexao = ConnectionFactory.createConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			stmt = conexao.prepareStatement("select l.titulo, a.nome, l.precoVenda from livro l inner join autor a using ( idAutor ) where a.nome like ?");			
			stmt.setString(1, "%"+autor+"%");
			rs = stmt.executeQuery();
		
		ArrayList<PesquisaLivro> fichaLivro = new ArrayList<PesquisaLivro>();

			while(rs.next())
			{
				PesquisaLivro livro = new PesquisaLivro();
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("nome"));
				livro.setPrecoVenda(rs.getDouble("precoVenda"));
				
				fichaLivro.add(livro);
			}
			rs.close();
			stmt.close();
			conexao.close();
			
			return fichaLivro;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}	
	}
	
}
