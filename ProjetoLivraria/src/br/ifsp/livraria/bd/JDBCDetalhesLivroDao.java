package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.livraria.pojo.DetalhesLivro;
import br.ifsp.livraria.pojo.PesquisaLivro;

public class JDBCDetalhesLivroDao implements DetalhesLivroDao{

	@Override
	public DetalhesLivro pesquisaDetalhesLivro(String titulo) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			stmt = conexao.prepareStatement("select l.titulo, a.nome, l.precoVenda, l.resumo, l.indice, e.nome from livro as l inner join autor as a ON l.idAutor=a.idAutor INNER JOIN editora as e ON l.idEditora = e.idEditora where l.titulo = ?");			
			stmt.setString(1, titulo);
			rs = stmt.executeQuery();
			
			DetalhesLivro detalhesLivro = new DetalhesLivro();
			
			if(rs.first()){ 
				detalhesLivro.setLivroTitulo(rs.getString("l.titulo")); 
				detalhesLivro.setAutorNome(rs.getString("a.nome"));
				detalhesLivro.setPreco(rs.getDouble("precoVenda"));
				detalhesLivro.setResumo(rs.getString("l.resumo"));
				detalhesLivro.setSumario(rs.getString("l.indice"));
				detalhesLivro.setNomeEditora(rs.getString("e.nome"));
			}else{
				System.out.println("Erro ao encontrar a primeira linha! ResultSet pode estar vazio.");
				throw new SQLException();
			}
			
			rs.close();
			stmt.close();
			conexao.close();
			
			return detalhesLivro;
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o comando MySQL");
			return null;
		}
	}
	
}
