package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField areaCadastrarUsuario;
	private JPasswordField areaCadastrarSenha;
	private JPasswordField areaRepetirSenha;
	private JTextField areaID;
	private JLabel lblVoltar;
	private JLabel lblMinimizar;
	private JLabel lblFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		areaCadastrarUsuario = new JTextField();
		areaCadastrarUsuario.setBorder(null);
		areaCadastrarUsuario.setOpaque(false);
		areaCadastrarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaCadastrarUsuario.setText("");
				areaCadastrarUsuario.setForeground(Color.BLACK);
			}
		});
	
		areaCadastrarUsuario.setForeground(Color.LIGHT_GRAY);
		areaCadastrarUsuario.setText("Usuário");
		areaCadastrarUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaCadastrarUsuario.setBounds(788, 195, 418, 55);
		contentPane.add(areaCadastrarUsuario);
		areaCadastrarUsuario.setColumns(10);
		
		areaCadastrarSenha = new JPasswordField("Senha");
		areaCadastrarSenha.setBorder(null);
		areaCadastrarSenha.setOpaque(false);
		areaCadastrarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaCadastrarSenha.setText("");
				areaCadastrarSenha.setForeground(Color.BLACK);
			}
		});
		areaCadastrarSenha.setForeground(Color.LIGHT_GRAY);
		areaCadastrarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaCadastrarSenha.setBounds(788, 281, 418, 55);
		contentPane.add(areaCadastrarSenha);
		
		areaRepetirSenha = new JPasswordField("Repita a Senha");
		areaRepetirSenha.setOpaque(false);
		areaRepetirSenha.setBorder(null);
		areaRepetirSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaRepetirSenha.setText("");
				areaRepetirSenha.setForeground(Color.BLACK);
			}
		});
		areaRepetirSenha.setForeground(Color.LIGHT_GRAY);
		areaRepetirSenha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaRepetirSenha.setBounds(788, 369, 418, 55);
		contentPane.add(areaRepetirSenha);
		
		areaID = new JTextField();
		areaID.setOpaque(false);
		areaID.setBorder(null);
		areaID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaID.setText("");
				areaID.setForeground(Color.BLACK);
			}
		});
		areaID.setForeground(Color.LIGHT_GRAY);
		areaID.setText("ID de Usuário");
		areaID.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaID.setBounds(788, 456, 418, 55);
		areaID.setColumns(10);
		contentPane.add(areaID);
		
		JButton botaoCadastrar = new JButton("");
		botaoCadastrar.setBorder(null);
		botaoCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoCadastrar.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/botaoCadastroApertado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoCadastrar.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/botaoCadastro.png")));
			}
		});
		botaoCadastrar.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/botaoCadastro.png")));
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoCadastrar.setBounds(760, 543, 410, 60);
		contentPane.add(botaoCadastrar);
		
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
		
		
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/Cadastro.png")));
		fundo.setBounds(0, 0, 1280, 720);
		contentPane.add(fundo);
		
		
	}
}
