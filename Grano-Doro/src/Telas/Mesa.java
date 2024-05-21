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

public class Mesa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesa frame = new Mesa();
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
	public Mesa() {
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
		
		JButton menuMesa = new JButton("");
		menuMesa.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuMesaEscolhido.png")));
		menuMesa.setBorder(null);
		menuMesa.setBounds(0, 105, 270, 85);
		contentPane.add(menuMesa);
		
		JButton menuVenda = new JButton("");
		menuVenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuVenda.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuVendaEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuVenda.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuVenda.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//Vendas vendas = new Vendas();
				//vendas.setVisible(true);
				
			}
		});
		menuVenda.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuVenda.png")));
		menuVenda.setBorder(null);
		menuVenda.setBounds(0, 190, 270, 85);
		contentPane.add(menuVenda);
		
		JButton menuCaixa = new JButton("");
		menuCaixa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuCaixa.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuCaixaEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuCaixa.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuCaixa.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//Caixa caixa = new Caixa();
				//caixa.setVisible(true);
			}
		});
		menuCaixa.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuCaixa.png")));
		menuCaixa.setBorder(null);
		menuCaixa.setBounds(0, 275, 270, 85);
		contentPane.add(menuCaixa);
		
		JButton menuEstoque = new JButton("");
		menuEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuEstoque.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuEstoqueEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuEstoque.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuEstoque.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//Estoque estoque = new Estoque();
				//estoque.setVisible(true);
			}
		});
		menuEstoque.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuEstoque.png")));
		menuEstoque.setBorder(null);
		menuEstoque.setBounds(0, 360, 270, 85);
		contentPane.add(menuEstoque);
		
		JButton menuFuncionarios = new JButton("");
		menuFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuFuncionarios.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuFuncEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuFuncionarios.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuFunc.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//Funcionarios funcionarios = new Funcionarios();
				//funcionarios.setVisible(true);
			}
		});
		menuFuncionarios.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuFunc.png")));
		menuFuncionarios.setBorder(null);
		menuFuncionarios.setBounds(0, 445, 270, 85);
		contentPane.add(menuFuncionarios);
		
		JButton menuSair = new JButton("");
		menuSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuSair.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuSairEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuSair.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuSair.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				dispose();
				login.setVisible(true);
			}
		});
		menuSair.setIcon(new ImageIcon(Mesa.class.getResource("/Menus/menuSair.png")));
		menuSair.setBorder(null);
		menuSair.setBounds(0, 530, 270, 85);
		contentPane.add(menuSair);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Mesa.class.getResource("/Fundos/Principal.png")));
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
