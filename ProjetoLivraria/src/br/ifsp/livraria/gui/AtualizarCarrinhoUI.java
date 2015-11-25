package br.ifsp.livraria.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AtualizarCarrinhoUI extends JFrame {

	private DefaultTableModel listaCarrinho = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JButton btCancelar;
	private JLabel lblQtde;

	private JTextField txtQtde;
	private String[] dados;

	private int linhaSelecionada;

	public AtualizarCarrinhoUI(DefaultTableModel tabelaCarrinho, String[] dados, int linha) {
		super("Alterar Qtde do Livro '" + dados[1] +"'");
		criaJanela();
		listaCarrinho = tabelaCarrinho;
		
		this.dados = dados;
		
		txtQtde.setText(dados[2]);
		
		linhaSelecionada = linha;  
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btLimpar = new JButton("Limpar");
		btCancelar = new JButton("Cancelar");
		lblQtde = new JLabel("         Digite a Quantidade Desejada:   ");

		txtQtde = new JTextField();

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(5, 2, 2, 4));
		painelFundo.add(lblQtde);
		painelFundo.add(txtQtde);
		painelFundo.add(btLimpar);
		painelFundo.add(btCancelar);
		painelFundo.add(btSalvar);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 175);
		setVisible(true);

		btSalvar.addActionListener(new AtualizarCarrinhoUI.BtSalvarListener());
		btLimpar.addActionListener(new AtualizarCarrinhoUI.BtLimparListener());
		btCancelar.addActionListener(new AtualizarCarrinhoUI.BtCancelarListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			double valorAtual = 0;
			double valorNovo = 0;
			int diferenca=0;
			if (Integer.parseInt(dados[2]) == Integer.parseInt(txtQtde.getText()))
			{
				JOptionPane.showMessageDialog(null, "Você não alterou a quantidade, tente novamente ou cancele.");
			}
			else
			{
				if (Integer.parseInt(txtQtde.getText()) <= 0){
					JOptionPane.showMessageDialog(null, "Você não pode comprar " + txtQtde.getText() + " livros. Se deseja excluir este item cancele e clique em 'excluir', se não, tente novamente.");
				}
				else
				{
					if (Integer.parseInt(dados[2]) > Integer.parseInt(txtQtde.getText()))
					{
						diferenca = Integer.parseInt(dados[2]) - Integer.parseInt(txtQtde.getText());
						valorAtual = Double.parseDouble(CarrinhoUI.txtValorTotal.getText());
						valorNovo = valorAtual - (diferenca * Double.parseDouble(dados[3]));				
						CarrinhoUI.txtValorTotal.setText(Double.toString(valorNovo));	
					}
					else
					{
						diferenca = Integer.parseInt(txtQtde.getText()) - Integer.parseInt(dados[2]);
						valorAtual = Double.parseDouble(CarrinhoUI.txtValorTotal.getText());
						valorNovo = valorAtual + (diferenca * Double.parseDouble(dados[3]));				
						CarrinhoUI.txtValorTotal.setText(Double.toString(valorNovo));
					}
					dados[2] = txtQtde.getText();
					listaCarrinho.removeRow(linhaSelecionada);
					listaCarrinho.addRow(new Object[]{dados[0], dados[1], dados[2], dados[3]});			
					setVisible(false);
				}
			}
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txtQtde.setText("");
		}
	}
	
	private class BtCancelarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}