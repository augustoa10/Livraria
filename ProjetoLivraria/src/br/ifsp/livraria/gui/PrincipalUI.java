package br.ifsp.livraria.gui;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import br.ifsp.livraria.pojo.Cliente;

public class PrincipalUI {

	public void menuPrincipal(Cliente c){

		//Criando frame
		final JFrame frame = new JFrame("Sistema para Livraria");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		// background image and icon
		
		ImageIcon imgbrackground = new ImageIcon("javalib/background.gif"); 
		JLabel background = new JLabel(imgbrackground);
		frame.add(background);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("javalib\\icon.gif");
		frame.setIconImage(icon);
		
		frame.validate(); 
		
		// Cria��o da barra de menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));	
		
		// Cria��o de Menus
		JMenu menuCadastro = new JMenu("Cadastro");
		JMenu menuRelatorio = new JMenu("Relatorios");
		
		// Cria��o dos submenus de Cadastro
		// Cadastrar Livro
		JMenuItem menuItemLivros = new JMenuItem("Livros");
		menuItemLivros.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {		
				new CadastrarLivroUI();		
			}	
		});
		menuCadastro.add(menuItemLivros);
		
		// Cria��o dos submenus de Cadastro
		// Cadastrar Autor
		JMenuItem menuItemAutor = new JMenuItem("Autores");
		menuItemAutor.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {		
				new CadastrarAutorUI();		
			}	
		});
		menuCadastro.add(menuItemAutor);
		
		// Cria��o dos submenus de Cadastro
		// Cadastrar Editora
		JMenuItem menuItemEditora = new JMenuItem("Editoras");
		menuItemEditora.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {		
				new CadastrarEditoraUI();		
			}	
		});
		menuCadastro.add(menuItemEditora);
		
		// Cria��o dos submenus de Cadastro
		// Cadastrar Cliente
		JMenuItem menuItemCliente = new JMenuItem("Clientes");
		menuItemCliente.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {		
				new CadastrarClienteUI();		
			}	
		});
		menuCadastro.add(menuItemCliente);
		menuCadastro.addSeparator();
		
		// Cria��o dos submenus de Cadastro
		// Perfil do cliente
		JMenuItem menuItemDados = new JMenuItem("Dados Pessoais");
		menuItemDados.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {		
				new DadosClienteUI(c);		
			}	
		});
		menuCadastro.add(menuItemDados);
		menuCadastro.addSeparator();
		
		// Menu Sair
		JMenuItem menuItemSair = new JMenuItem("Sair");
		menuItemSair.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
				frame.dispose();

			}
		});
		menuCadastro.add(menuItemSair);
		
		//Adicionando Jmenu no JmenuBar
		menuBar.add(menuCadastro);
		menuBar.add(menuRelatorio);
		
		//Adicionando o JMenuBar no JFrame
		frame.setJMenuBar(menuBar);
	}
}
