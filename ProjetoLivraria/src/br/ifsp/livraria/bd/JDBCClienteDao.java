package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ifsp.livraria.pojo.Cliente;

public class JDBCClienteDao implements ClienteDao {

	public void cadastrarCliente(Cliente cliente) {
		
		try{
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "insert into Cliente (nome, sobrenome, email, senha, confirmaSenha, cpf, sexo, dataNascimento, telefone, endereco) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getSobreNome());
			comando.setString(3, cliente.getEmail());
			comando.setString(4, cliente.getSenha());
			comando.setString(5, cliente.getConfirmaSenha());
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
