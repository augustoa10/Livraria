package br.ifsp.livraria.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ifsp.livraria.bd.JDBCLoginDao;
import br.ifsp.livraria.bd.LoginDao;


public class LoginUI {

	public static void main(String[] args) {
		
		//Criando frame
		final JFrame frame = new JFrame("Sistema para Livraria - Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 130);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		//icon
		Image icon = Toolkit.getDefaultToolkit().getImage("javalib\\login.gif");
		frame.setIconImage(icon);
		
		frame.validate();
		
		//Criando a label cpf
		JLabel rotuloCpf= new JLabel();
		rotuloCpf.setText("CPF: ");
		panel.add(rotuloCpf);

		final JFormattedTextField txtCpf = new JFormattedTextField();
		txtCpf.setColumns(20);
		
		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("###.###.###-##");
			maskData.install( txtCpf);
			txtCpf.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtCpf);
		
		//Criando a label senha
		JLabel rotuloSenha = new JLabel();
		rotuloSenha.setText("Senha: ");
		panel.add(rotuloSenha);

		final JTextField txtSenha = new JPasswordField(20);
		panel.add(txtSenha);
		
		JButton btnEntrar = new JButton(" Entrar ");
		btnEntrar.addActionListener(new ActionListener() {

			//Tratamento do botão Entrar
			public void actionPerformed(ActionEvent e) {
	
			LoginDao loginDao = new JDBCLoginDao();
			String cpf;
			String senha;
	
			try{
				if(txtCpf.getText().isEmpty() || txtSenha.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Você não preencheu todos os campos!");				
				}
				else
				{
					cpf=txtCpf.getText();
					senha=txtSenha.getText();
	
					if(loginDao.validarCliente(cpf, senha)){
						
						frame.dispose();
						PrincipalUI menu = new PrincipalUI();
						menu.menuPrincipal(loginDao.montarCliente(cpf));
						
					}else {
						JOptionPane.showMessageDialog(null, "Login ou senha inválidos!");
					}
				}
			}catch (Exception exp2){
				JOptionPane.showMessageDialog(null, "Dados Inválidos. Não foi possível efetuar login!");
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
				//Tratamento do botão Entrar
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
			panel.setVisible(true);
			frame.setVisible(true);
			frame.setResizable(false);
		}
}
