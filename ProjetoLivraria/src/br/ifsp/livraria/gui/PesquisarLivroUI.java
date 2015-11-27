package br.ifsp.livraria.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ifsp.livraria.bd.JDBCDetalhesLivroDao;
import br.ifsp.livraria.bd.JDBCPesquisaLivroDao;
import br.ifsp.livraria.bd.PesquisaLivroDao;
import br.ifsp.livraria.pojo.DetalhesLivro;
import br.ifsp.livraria.pojo.Livro;
import br.ifsp.livraria.pojo.PesquisaLivro;

public class PesquisarLivroUI {

	public PesquisarLivroUI(){
		
		//Criando o Frame para pesquisa de livros
		final JFrame framePesquisaLivro = new JFrame("Pesquisa de Livros");
		framePesquisaLivro.setSize(550, 540);
		framePesquisaLivro.setVisible(true);
		framePesquisaLivro.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		
		//crianado combobox para escolha da pesquisa com titulo ou autor
		JComboBox combo = new JComboBox();
	    combo.addItem("Escolha uma Opção");
	    combo.addItem("Título");
	    combo.addItem("Autor");
	    combo.setPreferredSize(new Dimension(195, 18));
	    panel.add(combo);
		
	    //crianado textfield para pesquisar de acordo com que foi escolhido no comboBox
		JTextField txtNome = new JTextField(15);
		panel.add(txtNome);
		
		
		// CRIAR TABELA ************************************************************************
		String[] colunas = new String[]{"Título" , "Autor" , "Preço"};
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colunas);
		
		JTable tabela = new JTable(modelo);
		JScrollPane barraRolagem = new JScrollPane(tabela);
		panel.add(barraRolagem);
		
		//Criando botão pesquisar
				JButton btnPesquisar = new JButton("Pesquisar");
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
							//pesquisando livro por autor
							if (combo.getSelectedItem() == "Título"){
								PesquisaLivroDao pdt = new JDBCPesquisaLivroDao();
								ArrayList<PesquisaLivro> LivroTitulo = new ArrayList<PesquisaLivro>();
								LivroTitulo = pdt.listaLivroTitulo(txtNome.getText());
								
								limpaTable(modelo);
								
								for (PesquisaLivro livro: LivroTitulo){
									Object[] linha = new Object[]{String.valueOf(livro.getTitulo()), livro.getAutor(), livro.getPrecoVenda()};
									modelo.addRow(linha);
								}
							}
							
							//pesquisando livro por título
							else if (combo.getSelectedItem() == "Autor"){
								PesquisaLivroDao pda = new JDBCPesquisaLivroDao();
								ArrayList<PesquisaLivro> LivroAutor = new ArrayList<PesquisaLivro>();
								LivroAutor = pda.listaLivroAutor(txtNome.getText());
				
								limpaTable(modelo);
								
								for (PesquisaLivro livro: LivroAutor){
									Object[] linha = new Object[]{String.valueOf(livro.getTitulo()), livro.getAutor(), livro.getPrecoVenda()};
									modelo.addRow(linha);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Você deve selecionar uma opção");
							} 
					
					}
				});
				panel.add(btnPesquisar);
		
		//Criando botão detalhes de um livro
		JButton btnDetalhes = new JButton("Detalhes do Livro");
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selecionada = tabela.getSelectedRow();
				if (selecionada == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para ver o detalhe do livro");
					return; //Não tem nada selecionado
				}
				else {
					//chamada para tela DETALHES DO LIVRO 
					String titulo = tabela.getValueAt(selecionada, 0).toString();
					JDBCDetalhesLivroDao detalhesLivroDao = new JDBCDetalhesLivroDao();
					DetalhesLivro detalhesLivro = detalhesLivroDao.pesquisaDetalhesLivro(titulo);
					Livro livro = new Livro();
					DetalhesLivroUI detalhesUI = new DetalhesLivroUI(detalhesLivro);
					framePesquisaLivro.dispose();
				}
			
			}
		});
		panel.add(btnDetalhes);
		
		//adicionando painel na janela
		framePesquisaLivro.setContentPane(panel);
	}
	
	private void limpaTable (DefaultTableModel modelo){
		int limitRow = modelo.getRowCount();
		if (limitRow!=0){
			for (int i = 0; i < limitRow; i++) {
				modelo.removeRow(0);
			}
		}
	}
}
