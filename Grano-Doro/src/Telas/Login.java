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

import dto.LoginDTO;
import dao.LoginDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

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
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField areaUsuario;
	private JPasswordField areaSenha;
	private JButton botaoLogar;
	private JLabel labelCadastrar;
	private JLabel labelSublinha;
	private JLabel lblMinimizar;
	private JLabel lblFechar;
	private JLabel lblVoltar;
	private JLabel fundo;
	private JTextField areaVerSenha;

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

	private void metodologin()
	{
		ResultSet rs;
		try
		{
		String Usuario = areaUsuario.getText();
		String Senha = areaSenha.getText();
		
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUsuario(Usuario);
		loginDTO.setSenha(Senha);
		
		LoginDAO loginDAO = new LoginDAO();
		rs = loginDAO.usuarioAutenticacao(loginDTO);
		
		if (rs.next())
		{
			Principal form = new Principal();
			form.setVisible(true);
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Erro na autenticacao");
		}
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(null, "Erro no metodologin" + erro.getMessage());
		}
		
	}

	
	public Login() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		areaUsuario = new JTextField();
		areaUsuario.setBounds(147, 217, 418, 55);
		areaUsuario.setBorder(null);
		areaUsuario.setOpaque(false);
		areaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaUsuario.setText("");
				areaUsuario.setForeground(Color.DARK_GRAY);
			}
		});
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				areaSenha.setVisible(false);
				areaVerSenha.setText(areaSenha.getText());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				areaSenha.setVisible(true);
				areaVerSenha.setText(null);
			}
		});

		btnNewButton.setBounds(510, 336, 55, 60);
		contentPane.add(btnNewButton);
		areaUsuario.setFont(new Font("Segoe UI", Font.BOLD, 24));
		areaUsuario.setForeground(Color.LIGHT_GRAY);
		areaUsuario.setText("Usuário");
		contentPane.add(areaUsuario);
		areaUsuario.setColumns(10);
		
		areaSenha = new JPasswordField("Senha");
		areaSenha.setBounds(155, 335, 360, 55);
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
		contentPane.add(areaSenha);
		
		botaoLogar = new JButton("");
		botaoLogar.setBounds(120, 464, 410, 60);
		botaoLogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoLogar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/botaoEntrarPressionado.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				botaoLogar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/botaoEntrar.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				metodologin();
			}
		});
		botaoLogar.setIcon(new ImageIcon(Login.class.getResource("/Imagens/botaoEntrar.png")));
		botaoLogar.setBackground(new Color(240, 240, 240));
		botaoLogar.setBorderPainted(false);
		botaoLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

				
			}
		});
		
		areaVerSenha = new JTextField();
		areaVerSenha.setBorder(null);
		areaVerSenha.setOpaque(false);
		areaVerSenha.setBounds(155, 335, 360, 55);
		contentPane.add(areaVerSenha);
		areaVerSenha.setColumns(10);
		contentPane.add(botaoLogar);
		botaoLogar.setBorderPainted(false);
		
		labelCadastrar = new JLabel("Novo Funcionário?");
		labelCadastrar.setBounds(195, 550, 250, 69);
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
		contentPane.add(labelCadastrar);
		
		labelSublinha = new JLabel("――――――――――――――");
		labelSublinha.setBounds(195, 594, 280, 14);
		labelSublinha.setForeground(new Color(240, 240, 240));
		labelSublinha.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contentPane.add(labelSublinha);
		
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
		
		fundo = new JLabel("");
		fundo.setBorder(null);
		fundo.setIcon(new ImageIcon(Login.class.getResource("/Imagens/Login.png")));
		fundo.setBounds(0, 0, 1280, 720);
		contentPane.add(fundo);
	
		
;
	
	}
}
