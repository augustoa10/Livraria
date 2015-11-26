package br.ifsp.livraria.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.ifsp.livraria.bd.JDBCCarrinhoDao;
import br.ifsp.livraria.pojo.Carrinho;
import br.ifsp.livraria.pojo.Livro;


public class CarrinhoUI extends JFrame {
	
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	
	private JLabel lblValorTotal;
	public static JTextField txtValorTotal;
	
	private JButton btExcluir;
	private JButton btEditar;
	private JButton btFinalizar;
	private DefaultTableModel listaCarrinho = new DefaultTableModel()
	{   
	    public boolean isCellEditable(int rowIndex, int mColIndex){   
	         return false;   
	    }   
	}; 

	public CarrinhoUI(Carrinho carrinho) {
		super("Carrinho de Compras");
		criaJanela(criaJTable(carrinho));
	}
	
	public void criaJanela(double valorTotal) {
		lblValorTotal = new JLabel();
		lblValorTotal.setText("Valor Total R$:");
		
		txtValorTotal = new JTextField(6);
		txtValorTotal.setText(Double.toString(valorTotal));
		txtValorTotal.setEditable(false); ;
		
		
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		btFinalizar = new JButton("Finalizar Compra");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(lblValorTotal);
		painelBotoes.add(txtValorTotal);
		
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelBotoes.add(btFinalizar);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 320);
		setVisible(true);

		btEditar.addActionListener(new BtEditarListener());
		btExcluir.addActionListener(new BtExcluirListener());
		btFinalizar.addActionListener(new BtFinalizarListener());
	}

	private double criaJTable(Carrinho carrinho) {
		tabela = new JTable(listaCarrinho);
		listaCarrinho.addColumn("ISBN");
		listaCarrinho.addColumn("Livro");
		listaCarrinho.addColumn("Qtd");
		listaCarrinho.addColumn("Preço");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(1);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		
		return pesquisar(listaCarrinho, carrinho);
	}

	public static double pesquisar(DefaultTableModel listaCarrinho, Carrinho carrinho) {
		listaCarrinho.setNumRows(0);
		
		double valorTotal = 0;
		
		for (Livro livro : carrinho.getLivros()) {
			listaCarrinho.addRow(new Object[]{livro.getIsbn(), livro.getTitulo(), livro.getEstoque(), livro.getPrecoVenda()});
			valorTotal = valorTotal + (livro.getEstoque() * livro.getPrecoVenda());
		}
		
		return valorTotal;
	}

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				String[] linha = {tabela.getValueAt(linhaSelecionada, 0).toString(),tabela.getValueAt(linhaSelecionada, 1).toString(), tabela.getValueAt(linhaSelecionada, 2).toString(),tabela.getValueAt(linhaSelecionada, 3).toString()};				
				AtualizarCarrinhoUI update = new AtualizarCarrinhoUI(listaCarrinho, linha, linhaSelecionada);
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar um livro para alterar a quantidade, tente novamente.");
			}
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				String[] linha = {tabela.getValueAt(linhaSelecionada, 0).toString(),tabela.getValueAt(linhaSelecionada, 1).toString(), tabela.getValueAt(linhaSelecionada, 2).toString(),tabela.getValueAt(linhaSelecionada, 3).toString()};				
				
				double valorAtual = Double.parseDouble(txtValorTotal.getText());
				double valorNovo = valorAtual - (Integer.parseInt(linha[2]) * Double.parseDouble(linha[3]));				
				txtValorTotal.setText(Double.toString(valorNovo));
				
				listaCarrinho.removeRow(linhaSelecionada);
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar um livro para excluir, tente novamente.");
			}
		}
	}
	
	private class BtFinalizarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			int linhasTabela = tabela.getRowCount();
			if (linhasTabela > 0) {
				
				ArrayList<Livro> livros = new ArrayList<Livro>();
				String isbn="",qtd="";
				for (int linha=0;linha<linhasTabela;linha++){
					Livro livro = new Livro();
					isbn = tabela.getModel().getValueAt(linha, 0).toString();
					qtd = tabela.getModel().getValueAt(linha, 2).toString();
					
					livro.setIsbn(Integer.parseInt(isbn));
					livro.setEstoque(Integer.parseInt(qtd));
					
					livros.add(livro);
					
				}
				
				JDBCCarrinhoDao carrinho = new JDBCCarrinhoDao();
				
				carrinho.finalizarCompra(livros);
				
				JOptionPane.showMessageDialog(null, "Venda Finalizada com sucesso! Obrigado e Volte sempre :)");
				
				dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "É necesário ao menos um livro no carrinho para finalizar a compra, adicione alguns livros ao carrinho e tente novamente.");
			}
		}
	}
}