package br.ifsp.livraria.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import br.ifsp.livraria.bd.JDBCDetalhesLivroDao;
import br.ifsp.livraria.pojo.Carrinho;
import br.ifsp.livraria.pojo.DetalhesLivro;
import br.ifsp.livraria.pojo.Livro;
//TODO INSTALL Windows Builder -- 
//Install new oftware = url: http://download.eclipse.org/windowbuilder/WB/release/R201506241200-1/4.4/
public class DetalhesLivroUI{

	public DetalhesLivroUI(DetalhesLivro detalhesLivro) {

		//Criando o Frame para detalhes de um livro
		final JFrame frameDetalhesLivro = new JFrame("Detalhes do Livro");
			
		JOptionPane.setRootFrame(frameDetalhesLivro);
		
		Container container = frameDetalhesLivro.getContentPane(); 
		container.setPreferredSize(new Dimension(550, 540));		
		GridBagConstraints cons = new GridBagConstraints();
		
		GridBagLayout layout = new GridBagLayout();
		container.setLayout(layout);
		
		frameDetalhesLivro.setSize(600, 590); //Was the same os the container's size
		frameDetalhesLivro.setBackground(new Color(0f,0f,0f)); 
		
		frameDetalhesLivro.setAlwaysOnTop(true);
		frameDetalhesLivro.setVisible(true);
		frameDetalhesLivro.setLocationRelativeTo(null);
		
		
		if (frameDetalhesLivro!=null) {
			
			cons.fill = GridBagConstraints.HORIZONTAL;
			cons.insets = new Insets(5, 15, 5, 15); //TODO change if need
			cons.gridy = 0;  
	        cons.gridx = 0;
	        container.add(new JLabel("Quantidade: "),cons);
	        
	        
			cons.gridy = 0;
			cons.gridx = 1;
			SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, getMaxQuant(detalhesLivro), 1);
			container.add(new JSpinner(spinnerModel),cons);
			
			cons.gridy = 0;
			cons.gridx = 2;
			JButton brnAddAoCarrinho = new JButton("Adicionar ao carrinho");
			container.add(brnAddAoCarrinho ,cons);
			
			cons.gridy = 1;  
	        cons.gridx = 0;
	        
	        container.add(new JLabel("Título: "),cons);
			
			cons.gridy = 1;  
	        cons.gridx = 2;
	        container.add(new JTextField(detalhesLivro.getLivroTitulo()),cons);
	        
			cons.gridy = 2;  
	        cons.gridx = 0;
	        container.add(new JLabel("Autor: "),cons);
			
			cons.gridy = 2;  
	        cons.gridx = 2;
	        container.add(new JTextField(detalhesLivro.getAutorNome()),cons);
			cons.gridy = 3;  
	        cons.gridx = 0;
	        container.add(new JLabel("Preço: "),cons);
			
			
			cons.gridy = 3;  
	        cons.gridx = 2;
	        container.add(new JTextField(String.valueOf(detalhesLivro.getPreco())),cons);//Por Mascara
			
	        cons.insets = new Insets(1, 15, 1, 15);
			cons.gridy = 5;  
	        cons.gridx = 0;
	        container.add(new JLabel("Resumo: "),cons);
	        
	        cons.insets = new Insets(5, 15, 5, 15);
			cons.gridy = 6;  
	        cons.gridx = 0;
	        container.add(new JTextArea(detalhesLivro.getResumo()),cons);
			
	        cons.insets = new Insets(1, 15, 1, 15);
			cons.gridy = 7;  
	        cons.gridx = 0;
	        container.add(new JLabel("Índice: "),cons);
	        
	        cons.insets = new Insets(5, 15, 5, 15);
			cons.gridy = 8;  
	        cons.gridx = 0;
	        container.add(new JTextArea(detalhesLivro.getSumario()),cons);

			
	        cons.gridy = 9;  
	        cons.gridx = 0;
	        container.add(new JLabel("Editora: "),cons);
	        
	        cons.gridy = 9;  
	        cons.gridx = 2;
	        
	        //Listener do Botão adicionar ao Carrinho
	        brnAddAoCarrinho.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String titulo = detalhesLivro.getLivroTitulo();
					JDBCDetalhesLivroDao detalhesLivroDao = new JDBCDetalhesLivroDao();
					Livro livro = detalhesLivroDao.pesquisaLivroPorTitulo(titulo);
					
					//Edita o atributo de Estoque 
					livro.setEstoque(Integer.parseInt(spinnerModel.getValue().toString()));
					
					//Adiciona ao array Carrinho
					Carrinho.carro.getLivros().add(livro);
					JOptionPane.showMessageDialog(null,"Livro cadastrado com sucesso!");
					frameDetalhesLivro.dispose();
				}
				
				
			});
	        
	        
	        container.add(new JTextField(detalhesLivro.getNomeEditora()),cons);
	        
	        
	         
			
			
		}
			
	}
	private int getMaxQuant(DetalhesLivro detalhesLivro) {
		if(detalhesLivro.getQuantidade()<=0){
			return 0;
		}
		return detalhesLivro.getQuantidade();
		
	}	

}
