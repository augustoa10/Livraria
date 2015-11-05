package br.ifsp.livraria.pojo;

public class Autor {

	// Atributos Autor
	private int idAutor;
	private String nomeAutor;
	private String dataNascimento;
	private String dataFalescimento;
	private String localNascimento;
	private String localFalescimento;
	private String biografia;

	//Getters and Setters
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDataFalescimento() {
		return dataFalescimento;
	}
	public void setDataFalescimento(String dataFalescimento) {
		this.dataFalescimento = dataFalescimento;
	}
	public String getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	public String getLocalFalescimento() {
		return localFalescimento;
	}
	public void setLocalFalescimento(String localFalescimento) {
		this.localFalescimento = localFalescimento;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
}
