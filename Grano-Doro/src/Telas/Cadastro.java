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
	private JTextField areaEmail;

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
		areaCadastrarUsuario.setBounds(785, 195, 419, 55);
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
		areaCadastrarSenha.setBounds(785, 282, 419, 55);
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
		areaRepetirSenha.setBounds(785, 369, 419, 55);
		contentPane.add(areaRepetirSenha);
		
		areaEmail = new JTextField();
		areaEmail.setOpaque(false);
		areaEmail.setBorder(null);
		areaEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaEmail.setText("");
				areaEmail.setForeground(Color.BLACK);
			}
		});
		areaEmail.setForeground(Color.LIGHT_GRAY);
		areaEmail.setText("E-mail");
		areaEmail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaEmail.setBounds(785, 456, 419, 55);
		areaEmail.setColumns(10);
		contentPane.add(areaEmail);
		
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
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/Cadastro.png")));
		fundo.setBounds(0, 0, 1280, 720);
		contentPane.add(fundo);
		
		
	}
}
