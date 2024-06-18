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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;

public class MesaPopUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField areaCodProduto;
	private JTextField areaQuantidade;
	private JTextField areaDinheiro;
	private JTextField areaTroco;
	private JTextField areaListaCompras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MesaPopUp frame = new MesaPopUp();
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
	public MesaPopUp() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblVoltar = new JLabel("");
		lblVoltar.setBounds(865, 4, 32, 32);
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
		contentPane.setLayout(null);
		lblVoltar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bvoltar.png")));
		contentPane.add(lblVoltar);
		
		JLabel lblMinimizar = new JLabel("");
		lblMinimizar.setBounds(907, 4, 32, 32);
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
		contentPane.add(lblMinimizar);
		
		JLabel lblFechar = new JLabel("");
		lblFechar.setBounds(961, 4, 32, 32);
		lblFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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
		contentPane.add(lblFechar);
		
		areaCodProduto = new JTextField();
		areaCodProduto.setText("Código do Produto");
		areaCodProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaCodProduto.setText(null);
				areaCodProduto.setForeground(Color.DARK_GRAY);
			}
		});
		areaCodProduto.setForeground(Color.LIGHT_GRAY);
		areaCodProduto.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaCodProduto.setBorder(null);
		areaCodProduto.setOpaque(false);
		areaCodProduto.setBounds(39, 138, 305, 55);
		contentPane.add(areaCodProduto);
		areaCodProduto.setColumns(10);
		
		areaQuantidade = new JTextField();
		areaQuantidade.setText("Quantidade");
		areaQuantidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaQuantidade.setText(null);
				areaQuantidade.setForeground(Color.DARK_GRAY);
			}
		});
		areaQuantidade.setForeground(Color.LIGHT_GRAY);
		areaQuantidade.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaQuantidade.setBorder(null);
		areaQuantidade.setOpaque(false);
		areaQuantidade.setColumns(10);
		areaQuantidade.setBounds(39, 246, 180, 55);
		contentPane.add(areaQuantidade);
		
		areaDinheiro = new JTextField();
		areaDinheiro.setText("Dinheiro");
		areaDinheiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaDinheiro.setText(null);
				areaDinheiro.setForeground(Color.DARK_GRAY);
			}
		});
		areaDinheiro.setForeground(Color.LIGHT_GRAY);
		areaDinheiro.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaDinheiro.setOpaque(false);
		areaDinheiro.setColumns(10);
		areaDinheiro.setBorder(null);
		areaDinheiro.setBounds(39, 368, 305, 55);
		contentPane.add(areaDinheiro);
		
		areaTroco = new JTextField();
		areaTroco.setText("Troco");
		areaTroco.setForeground(Color.DARK_GRAY);
		areaTroco.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaTroco.setEditable(false);
		areaTroco.setOpaque(false);
		areaTroco.setColumns(10);
		areaTroco.setBorder(null);
		areaTroco.setBounds(39, 572, 305, 55);
		contentPane.add(areaTroco);
		
		JButton botaoAdicionar = new JButton("");
		botaoAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoAdicionar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bAdicionarApertadoP.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoAdicionar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bAdicionarP.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		botaoAdicionar.setBorder(null);
		botaoAdicionar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bAdicionarP.png")));
		botaoAdicionar.setBounds(241, 217, 160, 60);
		contentPane.add(botaoAdicionar);
		
		JButton botaoRemover = new JButton("");
		botaoRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoRemover.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bRemoverApertadoP.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoRemover.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bRemoverP.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		botaoRemover.setBorder(null);
		botaoRemover.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bRemoverP.png")));
		botaoRemover.setBounds(241, 280, 160, 60);
		contentPane.add(botaoRemover);
		
		JButton botaoFinalizar = new JButton("");
		botaoFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoFinalizar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bFinalizarCompraApertado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoFinalizar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bFinalizarCompra.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		botaoFinalizar.setBorder(null);
		botaoFinalizar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bFinalizarCompra.png")));
		botaoFinalizar.setBounds(58, 472, 310, 60);
		contentPane.add(botaoFinalizar);
		
		areaListaCompras = new JTextField();
		areaListaCompras.setHorizontalAlignment(SwingConstants.LEFT);
		areaListaCompras.setText("teste");
		areaListaCompras.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaListaCompras.setForeground(Color.DARK_GRAY);
		areaListaCompras.setOpaque(false);
		areaListaCompras.setBorder(null);
		areaListaCompras.setBounds(418, 70, 89, 102);
		contentPane.add(areaListaCompras);
		areaListaCompras.setColumns(10);
		
		JTextArea areaLista = new JTextArea();
		areaLista.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaLista.setForeground(Color.DARK_GRAY);
		areaLista.setOpaque(false);
		areaLista.setBounds(445, 107, 498, 493);
		contentPane.add(areaLista);
		
		
		JLabel fundo = new JLabel("");
		fundo.setBounds(0, 0, 1010, 720);
		fundo.setIcon(new ImageIcon(MesaPopUp.class.getResource("/Fundos/Mesa.png")));
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
