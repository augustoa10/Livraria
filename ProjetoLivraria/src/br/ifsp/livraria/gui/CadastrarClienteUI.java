package br.ifsp.livraria.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ifsp.livraria.bd.ClienteDao;
import br.ifsp.livraria.bd.JDBCClienteDao;
import br.ifsp.livraria.pojo.Cliente;

public class CadastrarClienteUI {

	public CadastrarClienteUI(){

		//Criando o Frame para o cadastro de Cliente
		final JFrame frameCadCliente = new JFrame("Cadastro de Cliente");
		frameCadCliente.setSize(370, 640);
		frameCadCliente.setVisible(true);
		frameCadCliente.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		//Criando a label NOME Cliente
		JLabel rotuloNome = new JLabel();
		rotuloNome.setText("Nome Cliente: ");
		panel.add(rotuloNome);

		final JTextField txtNome = new JTextField(30);
		panel.add(txtNome);
		
		panel.add(rotuloNome);
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

		final JTextField txtSenha = new JPasswordField(30);
		panel.add(txtSenha);

		//Criando a label Confirmar Senha
		JLabel rotuloConfirmaSenha = new JLabel();
		rotuloConfirmaSenha.setText("Confirmar Senha: ");
		panel.add(rotuloConfirmaSenha);

		final JTextField txtConfirmaSenha = new JPasswordField(30);
		panel.add(txtConfirmaSenha);

		//Criando a label CPF
		JLabel rotuloCPF = new JLabel();
		rotuloCPF.setText("CPF: ");
		panel.add(rotuloCPF);
		
		final JFormattedTextField txtCpf = new JFormattedTextField();
		txtCpf.setColumns(30);
		
		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("###.###.###-##");
			maskData.install( txtCpf);
			txtCpf.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtCpf);
		
		//Criando a label Sexo
		JLabel rotuloSexo = new JLabel();
		rotuloSexo.setText("Sexo: ");
		panel.add(rotuloSexo);

		final JTextField txtSexo = new JTextField(30);
		txtSexo.setVisible(false);
		panel.add(txtSexo);
		
		JPanel painelSexo = new JPanel();
		painelSexo.setLayout(new FlowLayout());
		
		ButtonGroup groupSexo = new ButtonGroup();
		
		JRadioButton radioButtonSexoFeminino = new JRadioButton("Feminino", false);
		JRadioButton radioButtonSexoMasculino = new JRadioButton("Masculino", false);

		groupSexo.add(radioButtonSexoFeminino);
		groupSexo.add(radioButtonSexoMasculino);
		
		panel.add(radioButtonSexoFeminino);
		panel.add(radioButtonSexoMasculino);
		
		//Para adequar a posição de elemento
		JLabel jLabelNull = new JLabel("              ");
		panel.add(jLabelNull);
		
		//Criando a label Data Nascimento
		JLabel rotuloData = new JLabel();
		rotuloData.setText("Data de Nascimento: ");
		panel.add(rotuloData);

		final JFormattedTextField txtData = new JFormattedTextField();
		txtData.setColumns(30);
		
		MaskFormatter maskData2;
		try {
			maskData2 = new MaskFormatter("##/##/####");
			maskData2.install(txtData);
			txtData.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtData);

		//Criando a label Telefone
		JLabel rotuloTelefone = new JLabel();
		rotuloTelefone.setText("Telefone: ");
		panel.add(rotuloTelefone);

		final JFormattedTextField txtTelefone = new JFormattedTextField();
		txtTelefone.setColumns(30);
		
		MaskFormatter maskData3;
		try {
			maskData3 = new MaskFormatter("(##) ####-####");
			maskData3.install(txtTelefone);
			txtTelefone.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtTelefone);
		
		//Criando a label Celular
		JLabel rotuloCelular = new JLabel();
		rotuloCelular.setText("Celular: ");
		panel.add(rotuloCelular);

		final JFormattedTextField txtCelular = new JFormattedTextField();
		txtCelular.setColumns(30);
		
		MaskFormatter maskData4;
		try {
			maskData4 = new MaskFormatter("(##) #.####-####");
			maskData4.install(txtCelular);
			txtCelular.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtCelular);
		
		//Criando a label Endereço
		JLabel rotuloEndereco = new JLabel();
		rotuloEndereco.setText("************************** Endereço ****************************");
		panel.add(rotuloEndereco);
		
		/*cidade*/
		JLabel rotuloCidade = new JLabel();
		rotuloCidade.setText("Cidade: ");
		panel.add(rotuloCidade);
		final JTextField txtCidade = new JTextField(24);
		panel.add(txtCidade);
		
		/*bairro*/
		JLabel rotuloBairro = new JLabel();
		rotuloBairro.setText(" Bairro: ");
		panel.add(rotuloBairro);
		final JTextField txtBairro = new JTextField(24);
		panel.add(txtBairro);
		
		/*rua*/
		JLabel rotuloRua = new JLabel();
		rotuloRua.setText("     Rua: ");
		panel.add(rotuloRua);
		final JTextField txtRua = new JTextField(24);
		panel.add(txtRua);
		
		/*n° da casa*/
		JLabel rotuloNum = new JLabel();
		rotuloNum.setText("Número: ");
		panel.add(rotuloNum);
		final JTextField txtNum = new JTextField(8);
		panel.add(txtNum);
				
		//Listener de RadioButtonSexo
		radioButtonSexoFeminino.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				if (state == event.SELECTED) {
					txtSexo.setText(radioButtonSexoFeminino.getText());
				}else if (state == event.DESELECTED) {
					txtSexo.setText("");
				}
			}
		});
		
		radioButtonSexoMasculino.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				int state = event.getStateChange();
				if (state == event.SELECTED) {
					txtSexo.setText(radioButtonSexoMasculino.getText());
				}else if (state == event.DESELECTED) {
					txtSexo.setText("");
				}
			}
		});

		//Criando botÃƒÂ£o SALVAR
		JButton btnSalvar = new JButton(" Salvar ");
		btnSalvar.addActionListener(new ActionListener() {

			//Tratamento do BotÃƒÂ£o SALVAR
			public void actionPerformed(ActionEvent e) {

				ClienteDao cd = new JDBCClienteDao();
				Cliente cliente = new Cliente();

				try{
					if(txtConfirmaSenha.getText().equals(txtSenha.getText()))  {  
					  
						JOptionPane.showMessageDialog(null,"Senha de confirmação correta!");   
					}  
					else  {  
						JOptionPane.showMessageDialog(null,"Senha de confirmação incorreta!");  
						txtConfirmaSenha.setText("");
					}  

					if(txtNome.getText().isEmpty() || txtSobrenome.getText().isEmpty() || txtEmail.getText().isEmpty() || 
							txtSenha.getText().isEmpty() ||txtConfirmaSenha.getText().isEmpty() || txtCpf.getText().isEmpty() ||
							txtSexo.getText().isEmpty() || txtData.getText().isEmpty() || txtTelefone.getText().isEmpty() || 
							txtCelular.getText().isEmpty() || txtCidade.getText().isEmpty() || txtBairro.getText().isEmpty()|| 
							txtRua.getText().isEmpty() || txtNum.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Você não preencheu todos os dados, por favor preencha novamente!");
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
						cliente.setCelular(txtCelular.getText());
						cliente.setCidade(txtCidade.getText());
						cliente.setBairro(txtBairro.getText());
						cliente.setRua(txtRua.getText());
						cliente.setNumero(txtNum.getText());
						
						cd.cadastrarCliente(cliente);

						JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
						frameCadCliente.dispose();
					}
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Dados Inválidos. Não foi possível cadastrar o Cliente!");
				}	
			}
		});
		panel.add(btnSalvar);

		//Criando o botÃ£o CANCELAR
		JButton btnCancelar = new JButton (" Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {

			//Tratamento do botÃ£o CANCELAR
			public void actionPerformed(ActionEvent arg0) {

				frameCadCliente.dispose();
			}
		});
		panel.add(btnCancelar);

		//Coloca o painel na janela
		frameCadCliente.setContentPane(panel);
	}
}
