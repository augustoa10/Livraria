package br.ifsp.livraria.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import br.ifsp.livraria.bd.JDBCLoginDao;
import br.ifsp.livraria.bd.LoginDao;


public class LoginUI {

	public static void main(String[] args) {
		
		//Criando frame
		final JFrame frame = new JFrame("Sistema para Livraria - Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		//Criando a label cpf
		JLabel rotuloCpf= new JLabel();
		rotuloCpf.setText("CPF: ");
		panel.add(rotuloCpf);

		final JTextField txtCpf = new JTextField(30);
		panel.add(txtCpf);
		
		//Criando a label senha
		JLabel rotuloSenha = new JLabel();
		rotuloSenha.setText("Senha: ");
		panel.add(rotuloSenha);

		final JTextField txtSenha = new JPasswordField(30);
		panel.add(txtSenha);
		
		JButton btnEntrar = new JButton(" Entrar ");
		btnEntrar.addActionListener(new ActionListener() {

			//Tratamento do bot�o Entrar
			public void actionPerformed(ActionEvent e) {
	
			LoginDao log = new JDBCLoginDao();
			String cpf;
			String senha;
	
			try{
				if(txtCpf.getText().isEmpty() || txtSenha.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Voc� n�o preencheu todos os campos!");				
				}
				else
				{
					cpf=txtCpf.getText();
					senha=txtSenha.getText();
	
					if(log.validarCliente(cpf, senha)){
						
						frame.dispose();
						PrincipalUI menu = new PrincipalUI();
						menu.menuPrincipal(log.montarCliente(cpf));
						
					}else {
						JOptionPane.showMessageDialog(null, "Login ou senha inv�lidos!");
					}
				}
			}catch (Exception exp2){
				JOptionPane.showMessageDialog(null, "Dados Inv�lidos. N�o foi poss�vel efetuar login!");
					}	
				}
			});
			panel.add(btnEntrar);
			
			JButton btnCadastrar = new JButton(" Efetuar Cadastro ");
			btnCadastrar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new CadastrarClienteUI();
				}
				//Tratamento do bot�o Entrar
			});
			panel.add(btnCadastrar);
			
			JButton btnSair = new JButton( "Sair ");
			btnSair.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
				
			});
			panel.add(btnSair);
			
			frame.setContentPane(panel);
		}
}