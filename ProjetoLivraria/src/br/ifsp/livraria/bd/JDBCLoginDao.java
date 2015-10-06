package br.ifsp.livraria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ifsp.livraria.pojo.Cliente;

public class JDBCLoginDao implements LoginDao{

	@Override
	public Cliente montarCliente(String cpf) {
		try{
		//Abrindo conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();
		
		//Selecionando cliente
		String sql = "SELECT * FROM cliente WHERE cpf = ?;";
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, cpf);
		ResultSet resultado = comando.executeQuery();
		
		Cliente c = new Cliente();
		
			while(resultado.next()){
				c.setCpf(resultado.getString("cpf"));
				c.setNome(resultado.getString("nome"));
				c.setDataNascimento(resultado.getString("dataNascimento"));
				c.setEmail(resultado.getString("email"));
				c.setEndereco(resultado.getString("endereco"));
				c.setSexo(resultado.getString("sexo"));
				c.setSobreNome(resultado.getString("sobrenome"));
				c.setTelefone(resultado.getString("telefone"));
			}
		
		resultado.close();
		comando.close();
		conexao.close();
		return c;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public boolean validarCliente(String cpf, String senha){
		//Criando ArrayList de clientes
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		boolean encontradoCpf = false;
		boolean encontradaSenha = false;
		
		// Carregando o ArrayList através do método listarClientes
		clientes = listarClientes();
		
		for (int i=0; i<clientes.size(); i++){
			
			if(clientes.get(i).getCpf().equals(cpf)){
				encontradoCpf = true;
			}
			
			if(clientes.get(i).getSenha().equals(senha)){
				encontradaSenha = true;
			}
		}
		if (encontradoCpf == false || encontradaSenha == false){
			return false;
		}else{
			return true;
		}
	}
	
	// Método para puxar todos os cpfs e senhas do banco e carregar em um arrayList
	public ArrayList<Cliente> listarClientes() {
		try{
			//Abrindo conexão com o banco
			Connection conexao = ConnectionFactory.createConnection();
			ArrayList<Cliente> clientesCadastrados = new ArrayList<Cliente>();
			//Selecionando cliente
			String sql = "SELECT cpf,senha FROM cliente";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			ResultSet resultado = comando.executeQuery();
			
				while(resultado.next()){
					
					Cliente c = new Cliente();
					c.setCpf(resultado.getString("cpf"));
					c.setSenha(resultado.getString("senha"));
					clientesCadastrados.add(c);
				}	
			resultado.close();
			comando.close();
			conexao.close();
			
			return clientesCadastrados;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}
}
