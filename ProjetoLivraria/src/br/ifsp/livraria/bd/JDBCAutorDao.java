package br.ifsp.livraria.bd;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.livraria.pojo.Autor;

public class JDBCAutorDao implements AutorDao{

	public void cadastrarAutor(Autor autor) {

		try{
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "insert into Autor (nome, dataNascimento, dataFalecimento, localNascimento, localFalecimento, biografia) values (?,?,?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, autor.getNomeAutor());
			comando.setString(2, autor.getDataNascimento());
			comando.setString(3, autor.getDataFalescimento());
			comando.setString(4, autor.getLocalNascimento());
			comando.setString(5, autor.getLocalFalescimento());
			comando.setString(6, autor.getBiografia());

			comando.execute();
			comando.close();
			conexao.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Autor> obterAutor() {
		
		try{
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "select * from autor";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			ResultSet resultado = comando.executeQuery();
			
			ArrayList<Autor> listaAutor = new ArrayList<Autor>();
						
			while(resultado.next()){
				Autor autor = new Autor();
				autor.setNomeAutor(resultado.getString("nome"));
				autor.setDataNascimento(resultado.getString("dataNascimento"));
				autor.setDataFalescimento(resultado.getString("dataFalecimento"));
				autor.setLocalNascimento(resultado.getString("localNascimento"));
				autor.setLocalFalescimento(resultado.getString("localFalecimento"));
				autor.setBiografia(resultado.getString("biografia"));
				
				listaAutor.add(autor);
				
				
			}
			conexao.close();
			return listaAutor;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
		
	}

}
