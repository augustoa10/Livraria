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
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.ifsp.livraria.bd.EditoraDao;
import br.ifsp.livraria.bd.JDBCEditoraDao;
import br.ifsp.livraria.pojo.Editora;

public class CadastrarEditoraUI {
	
	public CadastrarEditoraUI(){
		
		//Criando o Frame para o cadastro de editora
		final JFrame frameCadEditora = new JFrame("Cadastro de Editora");
		frameCadEditora.setSize(390, 260);
		frameCadEditora.setVisible(true);
		frameCadEditora.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		//Criando a label NOME EDITORA
		JLabel rotuloNome = new JLabel();
		rotuloNome.setText("Nome Editora: ");
		panel.add(rotuloNome);
		
		final JTextField txtNome = new JTextField(30);
		panel.add(txtNome);
		
		//Criando a label ENDERECO
		JLabel rotuloEndereco = new JLabel();
		rotuloEndereco.setText("Endereco: ");
		panel.add(rotuloEndereco);
		
		final JTextField txtEndereco = new JTextField(30);
		panel.add(txtEndereco);
		
		//Criando a label TELEFONE
		JLabel rotuloTelefone = new JLabel();
		rotuloTelefone.setText("Telefone: ");
		panel.add(rotuloTelefone);
		
		final JFormattedTextField txtTelefone = new JFormattedTextField();
		txtTelefone.setColumns(30);
		
		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("(##) ####-####");
			maskData.install(txtTelefone);
			txtTelefone.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtTelefone);
		
		//Criando a label CNPJ
		JLabel rotuloCNPJ = new JLabel();
		rotuloCNPJ.setText("CNPJ: ");
		panel.add(rotuloCNPJ);
		
		final JFormattedTextField txtCNPJ = new JFormattedTextField();
		txtCNPJ.setColumns(30);
		
		MaskFormatter maskData1;
		try {
			maskData1 = new MaskFormatter("##.###.###/####-##");
			maskData1.install(txtCNPJ);
			txtCNPJ.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		panel.add(txtCNPJ);
		
		//Criando botão SALVAR
		JButton btnSalvar = new JButton(" Salvar ");
		btnSalvar.addActionListener(new ActionListener() {
			
			//Tratamento do Botão SALVAR
			public void actionPerformed(ActionEvent e) {

				EditoraDao ed = new JDBCEditoraDao();
				Editora editora = new Editora();
				
				try{
					
					if(txtNome.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtTelefone.getText().isEmpty() ||txtCNPJ.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Você não preencheu todos os dados, por favor preencha novamente!");
					}
					else{
						editora.setNomeEditora(txtNome.getText());
						editora.setEndereco(txtEndereco.getText());
						editora.setTelefone(txtTelefone.getText());
						editora.setCnpj(txtCNPJ.getText());
						
						ed.cadastrarEditora(editora);
						
						JOptionPane.showMessageDialog(null,"Editora cadastrada com sucesso!");
						frameCadEditora.dispose();
					}
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Dados Inválidos. Não foi possível cadastrar a Editora!");
				}	
			}
		});
		panel.add(btnSalvar);

		//Criando o Botão CANCELAR
		JButton btnCancelar = new JButton (" Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {

			//Tratamento do Botão CANCELAR
			public void actionPerformed(ActionEvent arg0) {

				frameCadEditora.dispose();
			}
		});
		panel.add(btnCancelar);

		//Coloca o painel na janela
		frameCadEditora.setContentPane(panel);
	}
}
