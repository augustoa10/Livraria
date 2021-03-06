package br.ifsp.livraria.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ifsp.livraria.bd.AutorDao;
import br.ifsp.livraria.bd.JDBCAutorDao;
import br.ifsp.livraria.pojo.Autor;


public class CadastrarAutorUI {

	public CadastrarAutorUI(){

		final JFrame frameCadAutor = new JFrame("Cadastro de Autor");
		frameCadAutor.setSize(400,460);
		frameCadAutor.setVisible(true);
		frameCadAutor.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		//Criando a label Nome Autor
		JLabel rotuloNome = new JLabel();
		rotuloNome.setText("Nome Autor: ");
		panel.add(rotuloNome);

		final JTextField txtNome = new JTextField(30);
		panel.add(txtNome);

		//Criando a label Data de Nascimento
		JLabel rotuloDataNascimento = new JLabel();
		rotuloDataNascimento.setText("Data do Nascimento: ");
		panel.add(rotuloDataNascimento);

		final JFormattedTextField txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setColumns(30);
		
		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.install(txtDataNascimento);
			txtDataNascimento.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtDataNascimento);

		//Criando a label Data do Falescimento
		JLabel rotuloDataFalescimento = new JLabel();
		rotuloDataFalescimento.setText("Data do Falescimento: ");
		panel.add(rotuloDataFalescimento);

		final JFormattedTextField txtDataFalescimento = new JFormattedTextField();
		txtDataFalescimento.setColumns(30);
		
		MaskFormatter maskData1;
		try {
			maskData1 = new MaskFormatter("##/##/####");
			maskData1.install(txtDataFalescimento);
			txtDataFalescimento.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtDataFalescimento);

		//Criando a label Local do Nascimento
		JLabel rotuloLocalNascimento = new JLabel();
		rotuloLocalNascimento.setText("Local do Nascimento: ");
		panel.add(rotuloLocalNascimento);

		final JTextField txtLocalNascimento = new JTextField(30);
		panel.add(txtLocalNascimento);

		//Criando a label Local do Falescimento
		JLabel rotuloLocalFalescimento = new JLabel();
		rotuloLocalFalescimento.setText("Local do Falescimento: ");
		panel.add(rotuloLocalFalescimento);

		final JTextField txtLocalFalescimento = new JTextField(30);
		panel.add(txtLocalFalescimento);

		//Criando a label Biografia
		JLabel rotuloBiografia = new JLabel();
		rotuloBiografia.setText("Biografia: ");
		panel.add(rotuloBiografia);

		final JTextArea txtBiografia = new JTextArea(8, 33);
		panel.add(txtBiografia);


		//Criando botão SALVAR
		JButton btnSalvar = new JButton(" Salvar ");
		btnSalvar.addActionListener(new ActionListener() {

			//Tratamento do botão SALVAR
			public void actionPerformed(ActionEvent e) {

				AutorDao ca = new JDBCAutorDao();
				Autor autor = new Autor();

				try{
					if(txtNome.getText().isEmpty() || txtDataNascimento.getText().isEmpty() ||txtLocalNascimento.getText().isEmpty() || txtBiografia.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Voc� n�o preencheu todos os dados, por favor preencha novamente!");				
					}
					else
					{
						autor.setNomeAutor(txtNome.getText());
						autor.setDataNascimento(txtDataNascimento.getText());
						autor.setDataFalescimento(txtDataFalescimento.getText());
						autor.setLocalNascimento(txtLocalNascimento.getText());
						autor.setLocalFalescimento(txtLocalFalescimento.getText());
						autor.setBiografia(txtBiografia.getText());

						ca.cadastrarAutor(autor);

						JOptionPane.showMessageDialog(null,"Autor cadastrado com sucesso!");
						frameCadAutor.dispose();
					}
				}catch (Exception exp2){
					JOptionPane.showMessageDialog(null, "Dados Inv�lidos. N�o foi poss�vel cadastrar o Autor!");
				}	
			}
		});
		panel.add(btnSalvar);

		//Criando o botão CANCELAR
		JButton btnCancelar = new JButton (" Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {

			//Tratamento do botão CANCELAR
			public void actionPerformed(ActionEvent arg0) {

				frameCadAutor.dispose();
			}
		});
		panel.add(btnCancelar);

		//Coloca o painel na janela
		frameCadAutor.setContentPane(panel);
	}
}
