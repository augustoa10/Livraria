package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import br.ifsp.livraria.pojo.Livro;

public class JDBCCarrinhoDao implements CarrinhoDao{

	@Override
	public void finalizarCompra(ArrayList<Livro> livros) {
		
		try{
			Connection conexao = ConnectionFactory.createConnection();
			String sql="";
			
			for (Livro livro : livros) {
				
				sql = "update Livro set estoque = (estoque - ?) where isbn = ?;";
				
				PreparedStatement comando = conexao.prepareStatement(sql);
				
				comando.setInt(1, livro.getEstoque());
				comando.setInt(2, livro.getIsbn());
				
				comando.execute();
				comando.close();
			
			}
			
			conexao.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
