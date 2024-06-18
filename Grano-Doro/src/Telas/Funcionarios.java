package Telas;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class Funcionarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField areaSenha;
	private JTextField areaContato;
	private JTextField areaSalario;
	private JTextField areaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios frame = new Funcionarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Funcionarios() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVoltar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bvoltarApertado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblVoltar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bvoltar.png")));
			}
		});
		lblVoltar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bvoltar.png")));
		lblVoltar.setBounds(1071, 4, 32, 32);
		contentPane.add(lblVoltar);
		
		JLabel lblMinimizar = new JLabel("");
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bminimizaApertado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bminimiza.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bminimiza.png")));
		lblMinimizar.setBounds(1140, 4, 32, 32);
		contentPane.add(lblMinimizar);
		
		JLabel lblFechar = new JLabel("");
		lblFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFechar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bfecharApertado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFechar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bfechar.png")));
			}
		});
		lblFechar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bfechar.png")));
		lblFechar.setBounds(1207, 5, 32, 32);
		contentPane.add(lblFechar);
		
		JButton menuCaixa = new JButton("");
		menuCaixa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuCaixa.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuCaixaEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuCaixa.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuCaixa.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Caixa caixa = new Caixa();
				caixa.setVisible(true);
				
			}
		});
		menuCaixa.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuCaixa.png")));
		menuCaixa.setBorder(null);
		menuCaixa.setBounds(0, 105, 270, 85);
		contentPane.add(menuCaixa);
		
		JButton menuMesa = new JButton("");
		menuMesa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuMesa.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuMesaEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuMesa.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuMesa.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Mesa mesa = new Mesa();
				mesa.setVisible(true);
			}
		});
		menuMesa.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuMesa.png")));
		menuMesa.setBorder(null);
		menuMesa.setBounds(0, 190, 270, 85);
		contentPane.add(menuMesa);
		
		JButton menuEstoque = new JButton("");
		menuEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuEstoque.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuEstoqueEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuEstoque.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuEstoque.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Estoque estoque = new Estoque();
				estoque.setVisible(true);
			}
		});
		menuEstoque.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuEstoque.png")));
		menuEstoque.setBorder(null);
		menuEstoque.setBounds(0, 275, 270, 85);
		contentPane.add(menuEstoque);
		
		JButton menuFuncionarios = new JButton("");
		menuFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuFuncionarios.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuFuncEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuFuncionarios.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuFunc.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionarios funcionarios = new Funcionarios();
				funcionarios.setVisible(true);
			}
		});
		menuFuncionarios.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuFunc.png")));
		menuFuncionarios.setBorder(null);
		menuFuncionarios.setBounds(0, 360, 270, 85);
		contentPane.add(menuFuncionarios);
		
		JButton menuSair = new JButton("");
		menuSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuSair.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuSairEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuSair.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuSair.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				dispose();
				login.setVisible(true);
			}
		});
		menuSair.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuSair.png")));
		menuSair.setBorder(null);
		menuSair.setBounds(0, 445, 270, 85);
		contentPane.add(menuSair);
		
		areaSenha = new JTextField();
		areaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaSenha.setText(null);
				areaSenha.setForeground(Color.DARK_GRAY);
			}
		});
		
		areaUsuario = new JTextField();
		areaUsuario.setText("Usuário");
		areaUsuario.setOpaque(false);
		areaUsuario.setForeground(Color.LIGHT_GRAY);
		areaUsuario.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaUsuario.setColumns(10);
		areaUsuario.setBorder(null);
		areaUsuario.setBounds(323, 164, 185, 55);
		contentPane.add(areaUsuario);
		
		JButton botaoProcurarFuncionario = new JButton("");
		botaoProcurarFuncionario.setBorder(null);
		botaoProcurarFuncionario.setBounds(517, 167, 130, 60);
		contentPane.add(botaoProcurarFuncionario);
		areaSenha.setText("Senha");
		areaSenha.setOpaque(false);
		areaSenha.setForeground(Color.LIGHT_GRAY);
		areaSenha.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaSenha.setColumns(10);
		areaSenha.setBorder(null);
		areaSenha.setBounds(323, 259, 315, 55);
		contentPane.add(areaSenha);
		
		areaContato = new JTextField();
		areaContato.setText("Contato");
		areaContato.setOpaque(false);
		areaContato.setForeground(Color.LIGHT_GRAY);
		areaContato.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaContato.setColumns(10);
		areaContato.setBorder(null);
		areaContato.setBounds(323, 354, 315, 55);
		contentPane.add(areaContato);
		
		areaSalario = new JTextField();
		areaSalario.setText("Salário");
		areaSalario.setOpaque(false);
		areaSalario.setForeground(Color.LIGHT_GRAY);
		areaSalario.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaSalario.setColumns(10);
		areaSalario.setBorder(null);
		areaSalario.setBounds(323, 449, 315, 55);
		contentPane.add(areaSalario);
		
		JButton botaoAtualizarFuncionario = new JButton("");
		botaoAtualizarFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoAtualizarFuncionario.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/bAtualizarApertado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoAtualizarFuncionario.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/bAtualizar.png")));
			}
		});
		botaoAtualizarFuncionario.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/bAtualizar.png")));
		botaoAtualizarFuncionario.setBorder(null);
		botaoAtualizarFuncionario.setBounds(328, 544, 310, 60);
		contentPane.add(botaoAtualizarFuncionario);
		
		JButton botaoRemoverFuncionario = new JButton("");
		botaoRemoverFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoRemoverFuncionario.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/bRemoverApertado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoRemoverFuncionario.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/bRemover.png")));
			}
		});
		botaoRemoverFuncionario.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/bRemover.png")));
		botaoRemoverFuncionario.setBorder(null);
		botaoRemoverFuncionario.setBounds(328, 608, 310, 60);
		contentPane.add(botaoRemoverFuncionario);
		
		JTextArea areaLista = new JTextArea();
		areaLista.setOpaque(false);
		areaLista.setForeground(Color.DARK_GRAY);
		areaLista.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaLista.setBounds(711, 107, 498, 548);
		contentPane.add(areaLista);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Fundos/Funcionários.png")));
		fundo.setBounds(0, 0, 1280, 720);
		contentPane.add(fundo);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
