package br.ifsp.livraria.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.ifsp.livraria.bd.AutorDao;
import br.ifsp.livraria.bd.EditoraDao;
import br.ifsp.livraria.bd.JDBCAutorDao;
import br.ifsp.livraria.bd.JDBCEditoraDao;
import br.ifsp.livraria.bd.JDBCLivroDao;
import br.ifsp.livraria.bd.LivroDao;
import br.ifsp.livraria.pojo.Autor;
import br.ifsp.livraria.pojo.Editora;
import br.ifsp.livraria.pojo.Livro;
import br.ifsp.livraria.utils.ActionCheckBoxes;

public class CadastrarLivroUI {

	private int NUMERO_MAX_AUTORES = 3;
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
		
		// Código para inserir apenas números
		txtISBN.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ev){
				String carac = "0987654321";
				if(!carac.contains(ev.getKeyChar()+ "")){
					ev.consume();
				}
			}
		});
		rotISBN.setLabelFor(txtISBN);
		rotISBN.setBounds(50, 20, 80, 20);
		txtISBN.setBounds(170, 20, 80, 20);

		//TITULO
		JLabel rotTit = new JLabel("Titulo: ");
		JTextField txtTit = new JTextField(100);
		rotTit.setLabelFor(txtTit);
		rotTit.setBounds(50, 60, 80, 20);
		txtTit.setBounds(170, 60, 200, 20);
		
		//EDITORA
		JLabel rotEd = new JLabel("Editora: ");
		
		EditoraDao ed = new JDBCEditoraDao();
		final ArrayList<Editora> array = ed.obterEditora();
		
		final String[] itensEditora = new String[array.size()];
		
		for(int i=0 ; i<array.size() ; i++){
			Editora editora = (Editora) array.get(i);
			itensEditora[i] = editora.getNomeEditora();
		}
		
		final JComboBox<String> comboEditora = new JComboBox<String> (itensEditora);
		comboEditora.setSelectedIndex(-1);
		rotEd.setLabelFor(comboEditora);
		rotEd.setBounds(50, 100, 80, 20);
		comboEditora.setBounds(170, 100, 200, 20);
		
		
		//AUTOR
		JLabel rotAu = new JLabel("Autor: ");
		
		AutorDao ad = new JDBCAutorDao();
		final ArrayList<Autor> array2 = ad.obterAutor();
		
		final String[] itensAutor = new String[array2.size()];
		
		for(int i=0 ; i<array2.size() ; i++){
			Autor autor = (Autor) array2.get(i);
			itensAutor[i] = autor.getNomeAutor();
		}
		
		final JComboBox<String> comboAutor = new JComboBox<String> (itensAutor);
		comboAutor.setSelectedIndex(-1);
		
		rotAu.setLabelFor(comboAutor);
		rotAu.setBounds(450, 100, 80, 20);
		comboAutor.setBounds(510, 100, 200, 20);
		
		//Data Publicação
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
		
		//TODO		
		JCheckBox checkBoxAcademico = new JCheckBox("Acadêmico");
		JCheckBox checkBoxRomance = new JCheckBox("Romance");
		JCheckBox checkBoxQuadrinhos = new JCheckBox("Quadrinhos");
		JCheckBox checkBoxOutros= new JCheckBox("Outros");
		
		rotCategoria.setBounds(50, 180, 120, 20);
		checkBoxAcademico.setBounds(170, 170, 100, 20);
		checkBoxRomance.setBounds(170, 190, 100, 20);
		checkBoxQuadrinhos.setBounds(280, 170, 100, 20);
		checkBoxOutros.setBounds(280, 190, 100, 20);
		
		txtCategoria.setBounds(380, 170, 100, 20);
		txtCategoria.setVisible(false);


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

		// Listeners
		
		//Categoria Checkbox
		
		ActionListener actionListener = new ActionCheckBoxes();
		checkBoxAcademico.addActionListener(actionListener);
		checkBoxOutros.addActionListener(actionListener);
		checkBoxQuadrinhos.addActionListener(actionListener);
		checkBoxRomance.addActionListener(actionListener);
		
		
		
		// Salvar
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LivroDao livroDao = new JDBCLivroDao();
				Livro livro = new Livro();

				try {
					if (	txtDataPublica.getText().isEmpty()
							|| txtEstoque.getText().isEmpty()
							|| comboAutor.getSelectedIndex() == -1
							|| comboEditora.getSelectedIndex() == 1
							|| txtIndice.getText().isEmpty()
							|| txtISBN.getText().isEmpty()
							|| txtMargemDeLucro.getText().isEmpty()
							|| txtPrecoCusto.getText().isEmpty()
							|| txtPrecoCusto.getText().isEmpty()
							|| txtPrecoVenda.getText().isEmpty()
							|| txtResumo.getText().isEmpty()
							|| txtTit.getText().isEmpty()){
						JOptionPane
						.showMessageDialog(null,
								"Você não preencheu todos os dados, por favor preencha novamente!");
					}

					else {
						System.out.println("");

						livro.setIsbn(Integer.parseInt(txtISBN.getText()));
						livro.setTitulo(txtTit.getText());
						livro.setDataPublicacao(txtDataPublica.getText());
						
						/*int index = comboEditora.getSelectedIndex();
						Editora editora = (Editora) array.get(index);
						livro.setIdEditora(editora.getIdEditora());*/
						
						livro.setCategoria(ActionCheckBoxes.getStringBuilder().toString());
						livro.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
						livro.setResumo(txtResumo.getText());
						livro.setIndice(txtIndice.getText());
						
						/*int index2 = comboAutor.getSelectedIndex();
						Autor autor = (Autor) array2.get(index2);
						livro.setIdAutor(autor.getIdAutor());*/
						
						livro.setIdEditora(comboEditora.getSelectedIndex()+1);
						livro.setIdAutor(comboAutor.getSelectedIndex()+1);
						
						livro.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText()));
						livro.setMargemLucro(Double.parseDouble(txtMargemDeLucro.getText()));
						livro.setEstoque(Integer.parseInt(txtEstoque.getText()));

						livroDao.cadastrarLivro(livro);
						
						JOptionPane.showMessageDialog(null,"Livro cadastrado com sucesso!");
						telaCadastroLivro.dispose();
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
		
				txtDataPublica.setText("");
				
				txtISBN.setText("");
				txtTit.setText("");
				txtCategoria.setText("");

				telaCadastroLivro.dispose();
			}
		});

		// Add components
		painelCadLivro.add(rotISBN);
		painelCadLivro.add(txtISBN);

		painelCadLivro.add(rotTit);
		painelCadLivro.add(txtTit);

		painelCadLivro.add(rotEd);
		painelCadLivro.add(comboEditora);

		painelCadLivro.add(rotDataPublica);
		painelCadLivro.add(txtDataPublica);

		painelCadLivro.add(rotCategoria);
		painelCadLivro.add(checkBoxAcademico);
		painelCadLivro.add(checkBoxRomance);
		painelCadLivro.add(checkBoxQuadrinhos);
		painelCadLivro.add(checkBoxOutros);
		
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

		painelCadLivro.add(rotAu);
		painelCadLivro.add(comboAutor);

		// Add buttons
		painelCadLivro.add(btnSalvar);
		painelCadLivro.add(btnCancelar);

		painelCadLivro.setLayout(null);

		telaCadastroLivro.add(painelCadLivro);
		painelCadLivro.setVisible(true);
		telaCadastroLivro.setVisible(true);
	}
}

