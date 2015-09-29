package br.ifsp.livraria.pojo;

public class Cliente {

	    private String nome;
		private String sobreNome;
		private String email;
		private String senha;
		private String cpf;
		private String sexo;
		private String dataNascimento;
		private String telefone;
		private String endereco;
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSobreNome() {
			return sobreNome;
		}
		public void setSobreNome(String sobreNome) {
			this.sobreNome = sobreNome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public String getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
	
		public void validarSenha(String confirmaSenha){
			if (confirmaSenha.equals(senha)){
				System.out.println("Senha confirmada");
			}
			else{
				System.out.println("Senha incorreta");
			}
		}
		
}
