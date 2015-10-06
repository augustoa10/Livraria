package br.ifsp.livraria.bd;

import br.ifsp.livraria.pojo.Cliente;

public interface LoginDao {
	
	public Cliente montarCliente(String cpf);
	public boolean validarCliente(String cpf, String senha);

}
