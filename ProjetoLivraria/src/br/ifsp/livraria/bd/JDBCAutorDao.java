package br.ifsp.livraria.bd;


import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
