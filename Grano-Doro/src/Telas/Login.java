package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField areaUsuario;
	private JPasswordField areaSenha;
	private JButton botaoLogar;
	private JLabel labelCadastrar;
	private JLabel labelSublinha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		areaUsuario = new JTextField();
		areaUsuario.setBorder(null);
		areaUsuario.setOpaque(false);
		areaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaUsuario.setText("");
				areaUsuario.setForeground(Color.BLACK);
			}
		});
		areaUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaUsuario.setForeground(Color.LIGHT_GRAY);
		areaUsuario.setText("Usuário");
		areaUsuario.setBounds(146, 195, 421, 55);
		contentPane.add(areaUsuario);
		areaUsuario.setColumns(10);
		
		areaSenha = new JPasswordField("Senha");
		areaSenha.setBorder(null);
		areaSenha.setOpaque(false);
		areaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaSenha.setText("");
				areaSenha.setForeground(Color.BLACK);
			}
		});
		areaSenha.setForeground(Color.LIGHT_GRAY);
		areaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaSenha.setBounds(146, 312, 421, 55);
		contentPane.add(areaSenha);
		
		botaoLogar = new JButton("");
		botaoLogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoLogar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/botaoEntrarPressionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoLogar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/botaoEntrar.png")));
			}
		});
		botaoLogar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/botaoEntrar.png")));
		botaoLogar.setBackground(new Color(240, 240, 240));
		botaoLogar.setBorderPainted(false);
		botaoLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoLogar.setBounds(120, 457, 410, 60);
		contentPane.add(botaoLogar);
		botaoLogar.setBorderPainted(false);
		
		labelCadastrar = new JLabel("Novo Funcionário?");
		labelCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		labelCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		labelCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
				labelSublinha.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 28));
				labelSublinha.setForeground(new Color(240, 240, 240));
			}
		});
		labelCadastrar.setBounds(195, 531, 250, 69);
		contentPane.add(labelCadastrar);
		
		labelSublinha = new JLabel("――――――――――――――");
		labelSublinha.setForeground(new Color(240, 240, 240));
		labelSublinha.setFont(new Font("Segoe UI", Font.BOLD, 18));
		labelSublinha.setBounds(195, 575, 280, 14);
		contentPane.add(labelSublinha);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Login.class.getResource("/Imagens/Login.png")));
		fundo.setBounds(0, 0, 1280, 720);
		contentPane.add(fundo);
	
		
;
	}
}
