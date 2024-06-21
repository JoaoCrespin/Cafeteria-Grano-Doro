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
import dto.LoginDTO;
import dao.CadastroDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField areaCadastrarUsuario;
	private JPasswordField areaCadastrarSenha;
	private JPasswordField areaRepetirSenha;
	private JTextField areaContato;
	private JLabel lblVoltar;
	private JLabel lblMinimizar;
	private JLabel lblFechar;
	
	private int status;
	private JTextField areaVerSenha;
	private JLabel botaoVerRepetirSenha;
	private JTextField areaVerRepetirSenha;

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
	
	private void cadastrarUsuario() throws SQLException {
	    String usuario = areaCadastrarUsuario.getText();
	    String senha = areaCadastrarSenha.getText();
	    String repetirSenha = areaRepetirSenha.getText();
	    String contato = areaContato.getText();

	    if (!senha.equals(repetirSenha)) {
	        JOptionPane.showMessageDialog(null, "As senhas não coincidem. Por favor, tente novamente.");
	        status=0;
	        return;
	    }

	    LoginDTO loginDTO = new LoginDTO();
	    loginDTO.setUsuario(usuario);
	    loginDTO.setSenha(senha);
	    loginDTO.setContato(contato);

	    CadastroDAO usuarioDAO = new CadastroDAO();
	    boolean cadastradoComSucesso = usuarioDAO.cadastrarUsuario(loginDTO);

	    if (cadastradoComSucesso) {
	        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
	        status=1;
	    } else {
	        JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário");
	        status=0;
	    }
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
				areaCadastrarUsuario.setForeground(Color.DARK_GRAY);
			}
		});
	
		areaCadastrarUsuario.setForeground(Color.LIGHT_GRAY);
		areaCadastrarUsuario.setText("Usuário");
		areaCadastrarUsuario.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
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
				areaCadastrarSenha.setForeground(Color.DARK_GRAY);
			}
		});
		
		JLabel botaoVerSenha = new JLabel("");
		botaoVerSenha.setBorder(null);
		botaoVerSenha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bVerSenha.png")));
		botaoVerSenha.addMouseListener(new MouseAdapter() {
			@Override
			//Faz "areaCadastrarSenha" ficar invisivel, copia o texto de "areaCadastrarSenha" para "areaVerSenha", troca o icon.
			public void mouseEntered(MouseEvent e) {
				areaCadastrarSenha.setVisible(false);
				areaVerSenha.setText(areaCadastrarSenha.getText());
				botaoVerSenha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bVerSenhaApertado.png")));
			}
			@Override
			//Faz "areaCadastrarSenha" ficar visivel, elimina o texto de "areaVerSenha", troca o icon para o padrão.
			public void mouseExited(MouseEvent e) {
				areaCadastrarSenha.setVisible(true);
				areaVerSenha.setText(null);
				botaoVerSenha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bVerSenha.png")));
			}
		});
		
				botaoVerSenha.setBounds(1141, 281, 55, 55);
				contentPane.add(botaoVerSenha);
		areaCadastrarSenha.setForeground(Color.LIGHT_GRAY);
		areaCadastrarSenha.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaCadastrarSenha.setBounds(788, 281, 418, 55);
		contentPane.add(areaCadastrarSenha);
		
		areaRepetirSenha = new JPasswordField("Senha");
		areaRepetirSenha.setOpaque(false);
		areaRepetirSenha.setBorder(null);
		areaRepetirSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaRepetirSenha.setText("");
				areaRepetirSenha.setForeground(Color.DARK_GRAY);
			}
		});
		
		areaVerSenha = new JTextField();
		areaVerSenha.setOpaque(false);
		areaVerSenha.setForeground(Color.DARK_GRAY);
		areaVerSenha.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaVerSenha.setColumns(10);
		areaVerSenha.setBorder(null);
		areaVerSenha.setBounds(788, 281, 418, 55);
		contentPane.add(areaVerSenha);
		
		botaoVerRepetirSenha = new JLabel("");
		botaoVerRepetirSenha.setBorder(null);
		botaoVerRepetirSenha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bVerSenha.png")));
		botaoVerRepetirSenha.addMouseListener(new MouseAdapter() {
			@Override
			//Faz "areaRepetirSenha" ficar invisivel, copia o texto de "areaRepetirSenha" para "areaVerRepetirSenha", troca o icon.
			public void mouseEntered(MouseEvent e) {
				areaRepetirSenha.setVisible(false);
				areaVerRepetirSenha.setText(areaRepetirSenha.getText());
				botaoVerRepetirSenha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bVerSenhaApertado.png")));
			}
			@Override
			//Faz "areaRepetirSenha" ficar visivel, elimina o texto de "areaVerRepetirSenha", troca o icon para o padrão.
			public void mouseExited(MouseEvent e) {
				areaRepetirSenha.setVisible(true);
				areaVerRepetirSenha.setText(null);
				botaoVerRepetirSenha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/bVerSenha.png")));
			}
		});
		
		botaoVerRepetirSenha.setIcon(new ImageIcon(Cadastro.class.getResource("/Imagens/bVerSenha.png")));
		botaoVerRepetirSenha.setBorder(null);
		botaoVerRepetirSenha.setBounds(1141, 369, 55, 55);
		contentPane.add(botaoVerRepetirSenha);
		areaRepetirSenha.setForeground(Color.LIGHT_GRAY);
		areaRepetirSenha.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaRepetirSenha.setBounds(788, 369, 418, 55);
		contentPane.add(areaRepetirSenha);
		
		areaContato = new JTextField();
		areaContato.setOpaque(false);
		areaContato.setBorder(null);
		areaContato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				areaContato.setText("");
				areaContato.setForeground(Color.DARK_GRAY);
			}
		});
		
		areaVerRepetirSenha = new JTextField();
		areaVerRepetirSenha.setOpaque(false);
		areaVerRepetirSenha.setForeground(Color.DARK_GRAY);
		areaVerRepetirSenha.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaVerRepetirSenha.setColumns(10);
		areaVerRepetirSenha.setBorder(null);
		areaVerRepetirSenha.setBounds(788, 369, 418, 55);
		contentPane.add(areaVerRepetirSenha);
		areaContato.setForeground(Color.LIGHT_GRAY);
		areaContato.setText("Contato");
		areaContato.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
		areaContato.setBounds(788, 456, 418, 55);
		areaContato.setColumns(10);
		contentPane.add(areaContato);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cadastrarUsuario();
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "Erro no botao cadastrar: " + erro.getMessage());
				}
				if(status==1) {
					Login login = new Login();
					dispose();
					login.setVisible(true);
					
				}

				
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
				Login login = new Login();
				dispose();
				login.setVisible(true);
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
		fundo.setIcon(new ImageIcon(Cadastro.class.getResource("/Fundos/Cadastro.png")));
		fundo.setBounds(0, 0, 1280, 720);
		contentPane.add(fundo);
		
		
	}
}
