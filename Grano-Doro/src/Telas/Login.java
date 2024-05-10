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
	private JButton botarLogar;
	private JLabel lblNewLabel;
	private JPanel panel;
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
		setBounds(100, 100, 960, 582);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		labelLogin.setBounds(65, 115, 108, 46);
		contentPane.add(labelLogin);
		
		areaUsuario = new JTextField();
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
		areaUsuario.setBounds(65, 196, 350, 30);
		contentPane.add(areaUsuario);
		areaUsuario.setColumns(10);
		
		areaSenha = new JPasswordField("Senha");
		areaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaSenha.setText("");
				areaSenha.setForeground(Color.BLACK);
			}
		});
		areaSenha.setForeground(Color.LIGHT_GRAY);
		areaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		areaSenha.setBounds(65, 261, 350, 30);
		contentPane.add(areaSenha);
		
		botarLogar = new JButton("");
		botarLogar.setBackground(new Color(255, 0, 0));
		botarLogar.setBorderPainted(false);
		botarLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botarLogar.setBounds(170, 348, 140, 44);
		contentPane.add(botarLogar);
		botarLogar.setBorderPainted(false);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagens/GranoDoroLogoMeio.png")));
		lblNewLabel.setBounds(464, 108, 480, 384);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(126, 81, 48));
		panel.setBounds(464, 0, 480, 582);
		contentPane.add(panel);
		
		labelCadastrar = new JLabel("Novo Funcionário?");
		labelCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		labelCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		labelCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 21));
				labelSublinha.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
				labelSublinha.setForeground(new Color(240, 240, 240));
			}
		});
		labelCadastrar.setBounds(143, 450, 194, 27);
		contentPane.add(labelCadastrar);
		
		labelSublinha = new JLabel("――――――――――――――――");
		labelSublinha.setForeground(new Color(240, 240, 240));
		labelSublinha.setFont(new Font("Segoe UI", Font.BOLD, 11));
		labelSublinha.setBounds(153, 470, 184, 14);
		contentPane.add(labelSublinha);
	
		
;
	}
}
