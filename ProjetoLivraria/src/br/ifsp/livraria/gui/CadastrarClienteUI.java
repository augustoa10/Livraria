package br.ifsp.livraria.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ifsp.livraria.bd.ClienteDao;
import br.ifsp.livraria.bd.JDBCClienteDao;
import br.ifsp.livraria.pojo.Cliente;

public class CadastrarClienteUI {

	public CadastrarClienteUI(){

		//Criando o Frame para o cadastro de Cliente
		final JFrame frameCadCliente = new JFrame("Cadastro de Cliente");
		frameCadCliente.setSize(370, 510);
		frameCadCliente.setVisible(true);
		

		JPanel panel = new JPanel();

		//Criando a label NOME Cliente
		JLabel rotuloNome = new JLabel();
		rotuloNome.setText("Nome Cliente: ");
		panel.add(rotuloNome);

		final JTextField txtNome = new JTextField(30);
		panel.add(txtNome);

		//Criando a label Sobrenome
		JLabel rotuloSobrenome = new JLabel();
		rotuloSobrenome.setText("Sobrenome Cliente: ");
		panel.add(rotuloSobrenome);

		final JTextField txtSobrenome = new JTextField(30);
		panel.add(txtSobrenome);

		//Criando a label Email
		JLabel rotuloEmail = new JLabel();
		rotuloEmail.setText("Email: ");
		panel.add(rotuloEmail);

		final JTextField txtEmail = new JTextField(30);
		panel.add(txtEmail);

		//Criando a label Senha
		JLabel rotuloSenha = new JLabel();
		rotuloSenha.setText("Senha: ");
		panel.add(rotuloSenha);

		final JTextField txtSenha = new JTextField(30);
		panel.add(txtSenha);

		//Criando a label Confirmar Senha
		JLabel rotuloConfirmaSenha = new JLabel();
		rotuloConfirmaSenha.setText("Confirmar Senha: ");
		panel.add(rotuloConfirmaSenha);

		final JTextField txtConfirmaSenha = new JTextField(30);
		panel.add(txtConfirmaSenha);

		//Criando a label CPF
		JLabel rotuloCPF = new JLabel();
		rotuloCPF.setText("CPF: ");
		panel.add(rotuloCPF);

		final JTextField txtCpf = new JTextField(30);
		panel.add(txtCpf);

		//Criando a label Sexo
		JLabel rotuloSexo = new JLabel();
		rotuloSexo.setText("Sexo: ");
		panel.add(rotuloSexo);

		final JTextField txtSexo = new JTextField(30);
		panel.add(txtSexo);

		//Criando a label Data Nascimento
		JLabel rotuloData = new JLabel();
		rotuloData.setText("Data de Nascimento: ");
		panel.add(rotuloData);

		final JTextField txtData = new JTextField(30);
		panel.add(txtData);

		//Criando a label Telefone
		JLabel rotuloTelefone = new JLabel();
		rotuloTelefone.setText("Telefone: ");
		panel.add(rotuloTelefone);

		final JTextField txtTelefone = new JTextField(30);
		panel.add(txtTelefone);

		//Criando a label Endereço
		JLabel rotuloEndereco = new JLabel();
		rotuloEndereco.setText("Endere�o: ");
		panel.add(rotuloEndereco);

		final JTextField txtEndereco = new JTextField(30);
		panel.add(txtEndereco);

		//Criando botão SALVAR
		JButton btnSalvar = new JButton(" Salvar ");
		btnSalvar.addActionListener(new ActionListener() {

			//Tratamento do Botão SALVAR
			public void actionPerformed(ActionEvent e) {

				ClienteDao cd = new JDBCClienteDao();
				Cliente cliente = new Cliente();

				try{
					if(txtConfirmaSenha.getText().equals(txtSenha.getText()))  {  
					  
						JOptionPane.showMessageDialog(null,"Senha de confirma��o correta!");   
					}  
					else  {  
						JOptionPane.showMessageDialog(null,"Senha de confirma��o incorreta!");  
						txtConfirmaSenha.setText("");
					}  

					if(txtNome.getText().isEmpty() || txtSobrenome.getText().isEmpty() || txtEmail.getText().isEmpty() ||txtSenha.getText().isEmpty() ||txtConfirmaSenha.getText().isEmpty() || txtCpf.getText().isEmpty() || txtSexo.getText().isEmpty() || txtData.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtEndereco.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Voc� n�o preencheu todos os dados, por favor preencha novamente!");
					}

					else {
						cliente.setNome(txtNome.getText());
						cliente.setSobreNome(txtSobrenome.getText());
						cliente.setEmail(txtEmail.getText());
						cliente.setSenha(txtSenha.getText());
						cliente.setConfirmaSenha(txtConfirmaSenha.getText());
						cliente.setCpf(txtCpf.getText());
						cliente.setSexo(txtSexo.getText());
						cliente.setDataNascimento(txtData.getText());
						cliente.setTelefone(txtTelefone.getText());
						cliente.setEndereco(txtEndereco.getText());

						cd.cadastrarCliente(cliente);

						JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
						frameCadCliente.dispose();
					}
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Dados Inv�lidos. N�o foi poss�vel cadastrar o Cliente!");
				}	
			}
		});
		panel.add(btnSalvar);

		//Criando o bot�o CANCELAR
		JButton btnCancelar = new JButton (" Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {

			//Tratamento do bot�o CANCELAR
			public void actionPerformed(ActionEvent arg0) {

				frameCadCliente.dispose();
			}
		});
		panel.add(btnCancelar);

		//Coloca o painel na janela
		frameCadCliente.setContentPane(panel);
	}
}
