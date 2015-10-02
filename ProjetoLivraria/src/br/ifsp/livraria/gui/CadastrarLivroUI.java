package br.ifsp.livraria.gui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
import javax.swing.text.NumberFormatter;

import br.ifsp.livraria.bd.JDBCLivroDao;
import br.ifsp.livraria.bd.LivroDao;
import br.ifsp.livraria.pojo.Livro;

public class CadastrarLivroUI {

	public CadastrarLivroUI(){

		final JFrame telaCadastroLivro = new JFrame("Cadastro de Livros");
		telaCadastroLivro.setSize(800, 800);
		telaCadastroLivro.setLocationRelativeTo(null); // Centro da tela
		telaCadastroLivro.setDefaultCloseOperation(telaCadastroLivro.HIDE_ON_CLOSE);
		telaCadastroLivro.setBackground(Color.CYAN);

		// Format
		DecimalFormat decimal = new DecimalFormat("#,###,###.00");
		NumberFormatter numFormatter = new NumberFormatter(decimal);
		numFormatter.setFormat(decimal);
		numFormatter.setAllowsInvalid(false);

		// painel Livro
		JPanel painelCadLivro = new JPanel();
		painelCadLivro.setSize(800, 600);
		// rotulo e textbox

		// Tratamento isbn
		JLabel rotISBN = new JLabel("ISBN: ");
		JTextField txtISBN = new JTextField();
		rotISBN.setLabelFor(txtISBN);
		rotISBN.setBounds(50, 20, 80, 20);
		txtISBN.setBounds(170, 20, 80, 20);

		JLabel rotTit = new JLabel("Titulo: ");
		JTextField txtTit = new JTextField(100);
		rotTit.setLabelFor(txtTit);
		rotTit.setBounds(50, 60, 80, 20);
		txtTit.setBounds(170, 60, 200, 20);

		JLabel rotEd = new JLabel("Editora: ");
		JTextField txtEd = new JTextField(100);
		rotEd.setLabelFor(txtEd);
		rotEd.setBounds(50, 100, 80, 20);
		txtEd.setBounds(170, 100, 80, 20);

		JLabel rotDataPublica = new JLabel("Data de Publicação: ");
		JFormattedTextField txtDataPublica = new JFormattedTextField();
		rotDataPublica.setLabelFor(txtDataPublica);
		rotDataPublica.setBounds(50, 140, 120, 20);
		txtDataPublica.setBounds(170, 140, 80, 20);

		MaskFormatter maskData;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.install(txtDataPublica);
			txtDataPublica.setCaretPosition(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// Categoria
		JLabel rotCategoria = new JLabel("Categoria: ");
		JTextField txtCategoria = new JTextField();
		
		rotCategoria.setLabelFor(txtCategoria);
		rotCategoria.setBounds(50, 180, 120, 20);
		txtCategoria.setBounds(170, 180, 80, 20);

		// Preço de Venda
		JLabel rotPrecoVenda = new JLabel("Preço de Venda: ");
		JTextField txtPrecoVenda = new JTextField();
		rotPrecoVenda.setLabelFor(txtPrecoVenda);
		rotPrecoVenda.setBounds(50, 220, 120, 20);
		txtPrecoVenda.setBounds(170, 220, 80, 20);

		// Preço de Custo
		JLabel rotPrecoCusto = new JLabel("Preço de Custo: ");
		JTextField txtPrecoCusto = new JTextField();
		rotPrecoCusto.setLabelFor(txtPrecoCusto);
		rotPrecoCusto.setBounds(50, 260, 120, 20);
		txtPrecoCusto.setBounds(170, 260, 80, 20);

		// Margem de Lucro
		JLabel rotMargemDeLucro = new JLabel("Margem de Lucro: ");
		JTextField txtMargemDeLucro = new JTextField();
		rotMargemDeLucro.setLabelFor(txtMargemDeLucro);
		rotMargemDeLucro.setBounds(50, 300, 120, 20);
		txtMargemDeLucro.setBounds(170, 300, 80, 20);

		// Quantidade em estoque
		JLabel rotEstoque = new JLabel("Estoque: ");
		JTextField txtEstoque = new JTextField();
		rotEstoque.setLabelFor(txtEstoque);
		rotEstoque.setBounds(50, 340, 80, 20);
		txtEstoque.setBounds(170, 340, 80, 20);

		// Resumo
		JLabel rotResumo = new JLabel("Resumo: ");
		JTextArea txtResumo = new JTextArea(6, 40);
		txtResumo.setLineWrap(true);
		rotResumo.setLabelFor(txtResumo);
		rotResumo.setBounds(50, 380, 120, 20);
		txtResumo.setBounds(170, 380, 420, 120);

		// Indice
		JLabel rotIndice = new JLabel("Índice: ");
		JTextArea txtIndice = new JTextArea(6, 40);
		txtIndice.setLineWrap(true);
		rotIndice.setLabelFor(txtIndice);
		rotIndice.setBounds(50, 520, 120, 20);
		txtIndice.setBounds(170, 520, 420, 120);

		// Buttons
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(130, 660, 90, 20);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(240, 660, 90, 20);

		// Autores
		JLabel rotAut = new JLabel("Autor: ");
		JTextField txtAut = new JTextField(100);
		rotAut.setLabelFor(txtAut);
		rotAut.setBounds(450, 20, 80, 20);
		txtAut.setBounds(570, 20, 200, 20);

		JLabel rotAut2 = new JLabel("Autor: ");
		JTextField txtAut2 = new JTextField(100);
		rotAut2.setLabelFor(txtAut2);
		rotAut2.setBounds(450, 60, 80, 20);
		txtAut2.setBounds(570, 60, 200, 20);
		rotAut2.setVisible(false);
		txtAut2.setVisible(false);

		JLabel rotAut3 = new JLabel("Autor: ");
		JTextField txtAut3 = new JTextField(100);
		rotAut3.setLabelFor(txtAut3);
		rotAut3.setBounds(450, 100, 80, 20);
		txtAut3.setBounds(570, 100, 200, 20);
		rotAut3.setVisible(false);
		txtAut3.setVisible(false);

		// Button Autor
		JButton btnAutor = new JButton("+ Autor");
		btnAutor.setBounds(450, 60, 80, 20);

		// Listeners
		// Salvar
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LivroDao livroDao = new JDBCLivroDao();
				Livro livro = new Livro();

				try {
					if (txtAut.getText().isEmpty()
							|| txtDataPublica.getText().isEmpty()
							|| txtEd.getText().isEmpty()
							|| txtEstoque.getText().isEmpty()
							|| txtIndice.getText().isEmpty()
							|| txtISBN.getText().isEmpty()
							|| txtMargemDeLucro.getText().isEmpty()
							|| txtPrecoCusto.getText().isEmpty()
							|| txtPrecoCusto.getText().isEmpty()
							|| txtPrecoVenda.getText().isEmpty()
							|| txtResumo.getText().isEmpty()
							|| txtTit.getText().isEmpty()
							|| txtCategoria.getText().isEmpty()){
						JOptionPane
						.showMessageDialog(null,
								"Você não preencheu todos os dados, por favor preencha novamente!");
					}

					else {
						System.out.println("");

						livro.setIsbn(Integer.parseInt(txtISBN.getText()));
						livro.setTitulo(txtTit.getText());
						livro.setDataDePublicacao(txtDataPublica.getText());
						livro.setEditora(txtEd.getText());
						livro.setCategoria(txtCategoria.getText());
						livro.setPrecoDeVenda(Double.parseDouble(txtPrecoVenda
								.getText()));
						livro.setResumo(txtResumo.getText());
						livro.setIndice(txtIndice.getText());

						// TODO

						if (!txtAut.getText().isEmpty()) {
							livro.setAutores(txtAut.getText());
						}
						if (!txtAut2.getText().isEmpty()) {
							livro.setAutoresInc(" - "+txtAut2.getText());
						}
						if (!txtAut3.getText().isEmpty()) {
							livro.setAutoresInc(" - "+txtAut3.getText());
						}


						livro.setPrecoDeCusto(Double.parseDouble(txtPrecoCusto.getText()));
						livro.setMargemDeLucro(Double.parseDouble(txtMargemDeLucro.getText()));
						livro.setQuantidadeEmEstoque(Integer.parseInt(txtEstoque.getText()));

						livroDao.cadastrarLivro(livro);
					}
				} catch (HeadlessException e) {
					JOptionPane.showMessageDialog(null,"Dados Inválidos. Não foi possível cadastrar o Livro!");
					e.printStackTrace();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Dados Inválidos. Não foi possível cadastrar o Livro!");
					e.printStackTrace();
				}
			}

		});

		// Cancelar
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtAut.setText("");
				txtDataPublica.setText("");
				txtEd.setText("");
				txtISBN.setText("");
				txtTit.setText("");
				txtCategoria.setText("");

				telaCadastroLivro.dispose();
			}
		});
		// Acrescentar Autor
		btnAutor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtAut2.isVisible()) {
					rotAut2.setVisible(true);
					txtAut2.setVisible(true);
					btnAutor.setBounds(450, 100, 80, 20);
				} else {
					rotAut3.setVisible(true);
					txtAut3.setVisible(true);
					btnAutor.setVisible(false);
				}
			}
		});

		// Add components
		painelCadLivro.add(rotISBN);
		painelCadLivro.add(txtISBN);

		painelCadLivro.add(rotTit);
		painelCadLivro.add(txtTit);

		painelCadLivro.add(rotEd);
		painelCadLivro.add(txtEd);

		painelCadLivro.add(rotDataPublica);
		painelCadLivro.add(txtDataPublica);

		painelCadLivro.add(rotCategoria);
		painelCadLivro.add(txtCategoria);

		painelCadLivro.add(rotPrecoVenda);
		painelCadLivro.add(txtPrecoVenda);

		painelCadLivro.add(rotPrecoCusto);
		painelCadLivro.add(txtPrecoCusto);

		painelCadLivro.add(rotMargemDeLucro);
		painelCadLivro.add(txtMargemDeLucro);

		painelCadLivro.add(rotEstoque);
		painelCadLivro.add(txtEstoque);

		painelCadLivro.add(rotResumo);
		painelCadLivro.add(txtResumo);

		painelCadLivro.add(rotIndice);
		painelCadLivro.add(txtIndice);

		painelCadLivro.add(rotAut);
		painelCadLivro.add(txtAut);

		painelCadLivro.add(rotAut2);
		painelCadLivro.add(txtAut2);

		painelCadLivro.add(rotAut3);
		painelCadLivro.add(txtAut3);

		painelCadLivro.add(btnAutor);
		painelCadLivro.add(btnAutor);

		// Add buttons
		painelCadLivro.add(btnSalvar);
		painelCadLivro.add(btnCancelar);

		painelCadLivro.setLayout(null);

		telaCadastroLivro.add(painelCadLivro);
		painelCadLivro.setVisible(true);
		telaCadastroLivro.setVisible(true);
		telaCadastroLivro.setResizable(false);
	}

}
