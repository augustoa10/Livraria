package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.livraria.pojo.Editora;

public class JDBCEditoraDao implements EditoraDao{

	public void cadastrarEditora(Editora editora){
		
		try{
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "insert into Editora (nome,endereco,telefone,cnpj) values (?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, editora.getNomeEditora());
			comando.setString(2, editora.getEndereco());
			comando.setString(3, editora.getTelefone());
			comando.setString(4, editora.getCnpj());
			
			comando.execute();
			comando.close();
			conexao.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	@Override
	public ArrayList<Editora> obterEditora() {
		
		try{
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "select * from editora";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			ResultSet resultado = comando.executeQuery();
			
			ArrayList<Editora> listaEditora = new ArrayList<Editora>();
						
			while(resultado.next()){
				Editora editora = new Editora();
				editora.setNomeEditora(resultado.getString("nome"));
				editora.setEndereco(resultado.getString("endereco"));
				editora.setTelefone(resultado.getString("telefone"));
				editora.setCnpj(resultado.getString("cnpj"));

				
				listaEditora.add(editora);
				
				
			}
			conexao.close();
			return listaEditora;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}		
		
	}
}
