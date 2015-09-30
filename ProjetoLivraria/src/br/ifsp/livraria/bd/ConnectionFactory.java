package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
public static Connection createConnection(){
		
		String stringConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = ""; 
		
		Connection conexao = null;
		
		try{
			conexao = DriverManager.getConnection(stringConexao, usuario, senha);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conexao;
	}
}
