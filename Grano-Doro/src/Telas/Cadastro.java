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
	private JLabel labelLogo;
	private JPanel panel;

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
		setBounds(100, 100, 960, 582);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		areaCadastrarUsuario = new JTextField();
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
		areaCadastrarUsuario.setBounds(545, 115, 350, 30);
		contentPane.add(areaCadastrarUsuario);
		areaCadastrarUsuario.setColumns(10);
		
		areaCadastrarSenha = new JPasswordField("Senha");
		areaCadastrarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaCadastrarSenha.setText("");
				areaCadastrarSenha.setForeground(Color.BLACK);
			}
		});
		areaCadastrarSenha.setForeground(Color.LIGHT_GRAY);
		areaCadastrarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaCadastrarSenha.setBounds(545, 176, 350, 30);
		contentPane.add(areaCadastrarSenha);
		
		areaRepetirSenha = new JPasswordField("Repita a Senha");
		areaRepetirSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaRepetirSenha.setText("");
				areaRepetirSenha.setForeground(Color.BLACK);
			}
		});
		areaRepetirSenha.setForeground(Color.LIGHT_GRAY);
		areaRepetirSenha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaRepetirSenha.setBounds(545, 237, 350, 30);
		contentPane.add(areaRepetirSenha);
		
		areaEmail = new JTextField();
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
		areaEmail.setBounds(545, 298, 350, 30);
		areaEmail.setColumns(10);
		contentPane.add(areaEmail);
		
		JLabel labelCadastro = new JLabel("Cadastro");
		labelCadastro.setBounds(545, 54, 110, 38);
		labelCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		contentPane.add(labelCadastro);
		
		labelLogo = new JLabel("");
		labelLogo.setBounds(0, 99, 480, 384);
		contentPane.add(labelLogo);
		labelLogo.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/GranoDoroLogoMeio.png")));
		
		panel = new JPanel();
		panel.setBackground(new Color(126, 81, 48));
		panel.setBounds(0, 0, 480, 582);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Efetuar Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(590, 368, 246, 44);
		contentPane.add(btnNewButton);
		
		
	}
}
