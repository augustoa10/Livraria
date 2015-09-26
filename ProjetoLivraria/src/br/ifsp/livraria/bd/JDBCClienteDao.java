package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCClienteDao implements ClienteDao {

	public void cadastrarCliente() {
		
		try{
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "insert into Cliente (nome, sobrenome, email, senha, confirmarSenha, cpf, sexo, dataNascimento, telefone, endereco) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			Cliente cliente = new Cliente();
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getSobrenome());
			comando.setString(3, cliente.getEmail());
			comando.setString(4, cliente.getSenha());
			comando.setString(5, cliente.getConfirmarSenha());
			comando.setString(6, cliente.getCpf());
			comando.setString(7, cliente.getSexo());
			comando.setString(8, cliente.getDataNascimento());
			comando.setString(9, cliente.getTelefone());
			comando.setString(10, cliente.getEndereco());
			
			comando.execute();
			comando.close();
			conexao.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}