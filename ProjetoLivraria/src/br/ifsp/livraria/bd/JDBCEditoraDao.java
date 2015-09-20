package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ifsp.livraria.pojo.Editora;

public class JDBCEditoraDao implements EditoraDao{

	public void cadastrarEditora(){
		
		try{
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "insert into Editora (nome,endereco,telefone,cnpj) values (?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			Editora editora = new Editora();
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
}
