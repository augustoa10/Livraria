package br.ifsp.livraria.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ifsp.livraria.pojo.Cliente;

public class DadosClienteUI {
	public DadosClienteUI(Cliente c) {
		
		final JFrame frame = new JFrame("Dados de Cadastro - "+c.getNome()+" "+c.getSobreNome());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setSize(600, 400);
		
		JLabel lblNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField(c.getNome());
		lblNome.setLabelFor(txtNome);
		lblNome.setBounds(50, 20, 80, 20);
		txtNome.setBounds(170, 20, 140, 20);
		txtNome.setDisabledTextColor(new Color(0, 0, 0));
		txtNome.setEnabled(false);
		
		JLabel lblSobrenome = new JLabel("Sobrenome: ");
		JTextField txtSobrenome = new JTextField(c.getSobreNome());
		lblSobrenome.setLabelFor(txtSobrenome);
		lblSobrenome.setBounds(50, 60, 80, 20);
		txtSobrenome.setBounds(170, 60, 200, 20);
		txtSobrenome.setDisabledTextColor(new Color(0, 0, 0));
		txtSobrenome.setEnabled(false);
		
		JLabel lblEmail = new JLabel("Email: ");
		JTextField txtEmail = new JTextField(c.getEmail());
		lblEmail.setLabelFor(txtEmail);
		lblEmail.setBounds(50, 100, 80, 20);
		txtEmail.setBounds(170, 100, 200, 20);
		txtEmail.setDisabledTextColor(new Color(0, 0, 0));
		txtEmail.setEnabled(false);
		
		
		
		JLabel lblCpf = new JLabel("CPF: ");
		JTextField txtCpf = new JTextField(c.getCpf());
		lblCpf.setLabelFor(txtCpf);
		lblCpf.setBounds(50, 140, 80, 20);
		txtCpf.setBounds(170, 140, 200, 20);
		txtCpf.setDisabledTextColor(new Color(0, 0, 0));
		txtCpf.setEnabled(false);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		JTextField txtTelefone = new JTextField(c.getTelefone());
		lblTelefone.setLabelFor(txtTelefone);
		lblTelefone.setBounds(50, 180, 80, 20);
		txtTelefone.setBounds(170, 180, 140, 20);
		txtTelefone.setDisabledTextColor(new Color(0, 0, 0));
		txtTelefone.setEnabled(false);
		
		
		
		JLabel lblEndereco = new JLabel("Endereço: ");
		JTextField txtEndereco = new JTextField(c.getEndereco());
		lblEndereco.setLabelFor(txtEndereco);
		lblEndereco.setBounds(50, 220, 80, 20);
		txtEndereco.setBounds(170, 220, 200, 20);
		txtEndereco.setDisabledTextColor(new Color(0, 0, 0));
		txtEndereco.setEnabled(false);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		JTextField txtSexo = new JTextField(c.getSexo());
		lblSexo.setLabelFor(txtSexo);
		lblSexo.setBounds(50, 260, 80, 20);
		txtSexo.setBounds(170, 260, 140, 20);
		txtSexo.setDisabledTextColor(new Color(0, 0, 0));
		txtSexo.setEnabled(false);
		
		//Botão voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(200, 320, 140, 20);
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
		
		panel.add(lblNome);
		panel.add(txtNome);
		panel.add(lblSobrenome);
		panel.add(txtSobrenome);
		
		panel.add(lblEmail);
		panel.add(txtEmail);
		
		panel.add(lblCpf);
		panel.add(txtCpf);
		
		panel.add(lblTelefone);
		panel.add(txtTelefone);
		
		panel.add(lblEndereco);
		panel.add(txtEndereco);
		
		panel.add(lblSexo);
		panel.add(txtSexo);
		
		panel.add(btnVoltar);
		
		panel.setLayout(null);
		
		frame.add(panel);
		frame.setVisible(true);
		panel.setVisible(true);
		frame.setResizable(false);
		
	}
}
