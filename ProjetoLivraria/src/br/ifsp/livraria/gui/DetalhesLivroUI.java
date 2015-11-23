package br.ifsp.livraria.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.ifsp.livraria.pojo.DetalhesLivro;

public class DetalhesLivroUI{
	public DetalhesLivroUI(DetalhesLivro detalhesLivro) {
		//Criando o Frame para detalhes de um livro
		final JFrame frameDetalhesLivro = new JFrame("Detalhes do Livro");
		
		Container container = frameDetalhesLivro.getContentPane(); 
		container.setPreferredSize(new Dimension(550, 540));		
		GridBagConstraints cons = new GridBagConstraints();
		
		GridBagLayout layout = new GridBagLayout();
		container.setLayout(layout);
		
		frameDetalhesLivro.setSize(550, 540);
		frameDetalhesLivro.setBackground(new Color(0f,0f,0f)); 
		
//		AWTUtilities.setWindowOpacity(frameDetalhesLivro, .7f); //TODO Try set transparent
		frameDetalhesLivro.setAlwaysOnTop(true);
		frameDetalhesLivro.setVisible(true);
		frameDetalhesLivro.setLocationRelativeTo(null);

				
		
		if (frameDetalhesLivro!=null) {
			cons.insets = new Insets(5, 15, 5, 15);
			cons.fill = GridBagConstraints.HORIZONTAL;
			
	        cons.gridy = 0;  
	        cons.gridx = 0;
			container.add(new JLabel("Título: "),cons);
			
			cons.gridy = 0;
			cons.gridx = 1;
			container.add(new JTextField(detalhesLivro.getLivroTitulo()),cons);
			
			cons.gridy = 1;  
	        cons.gridx = 0;
			container.add(new JLabel("Autor: "),cons);
			
			cons.gridy = 1;  
	        cons.gridx = 1;
			container.add(new JTextField(detalhesLivro.getAutorNome()),cons);
			cons.gridy = 2;  
	        cons.gridx = 0;
			container.add(new JLabel("Preço: "),cons);
			
			cons.gridy = 2;  
	        cons.gridx = 1;
			container.add(new JTextField(String.valueOf(detalhesLivro.getPreco())),cons);//Por Mascara
			cons.gridy = 3;  
	        cons.gridx = 0;
			container.add(new JLabel("Resumo: "),cons);
			
			cons.insets = new Insets(1, 15, 1, 15);
			cons.gridy = 4;  
	        cons.gridx = 0;
			container.add(new JTextArea(detalhesLivro.getResumo()),cons);
			
			cons.insets = new Insets(5, 15, 5, 15);
			cons.gridy = 5;  
	        cons.gridx = 0;
			container.add(new JLabel("Índice: "),cons);
			cons.insets = new Insets(1, 15, 1, 15);
			cons.gridy = 6;  
	        cons.gridx = 0;
			container.add(new JTextArea(detalhesLivro.getSumario()),cons);
			
			cons.insets = new Insets(5, 15, 5, 15);
			cons.gridy = 7;  
	        cons.gridx = 0;
			container.add(new JLabel("Editora: "),cons);
			
			cons.gridy = 7;  
	        cons.gridx = 1;
			container.add(new JTextArea(detalhesLivro.getNomeEditora()),cons);
			
			JScrollPane barraRolagem = new JScrollPane();
			
			barraRolagem.add(container);
			
			frameDetalhesLivro.getContentPane().add(barraRolagem,cons);
			
			
		}
			
//		frameDetalhesLivro.add(container);
	    
	    
		
		
		// CRIAR TABELA ************************************************************************
				
//		JTable tabela = new JTable(modelo);
		
//		panel.add(barraRolagem);
	}
	

}
