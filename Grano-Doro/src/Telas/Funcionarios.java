package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dao.LoginDAO;
import dto.LoginDTO;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Funcionarios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField areaSenha;
    private JTextField areaContato;
    private JTextField areaSalario;
    private JTextField areaUsuario;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<LoginDTO> logins;

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

    public Funcionarios() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		
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
				dispose();
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
				Mesa mesa = new Mesa();
				mesa.setVisible(true);
				dispose();
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
				dispose();
			}
		});
		menuEstoque.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuEstoque.png")));
		menuEstoque.setBorder(null);
		menuEstoque.setBounds(0, 275, 270, 85);
		contentPane.add(menuEstoque);
		
		JButton menuFuncionarios = new JButton("");
		menuFuncionarios.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuFuncEscolhido.png")));
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
        areaSenha.setText("Senha");
        areaSenha.setOpaque(false);
        areaSenha.setForeground(Color.LIGHT_GRAY);
        areaSenha.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaSenha.setColumns(10);
        areaSenha.setBorder(null);
        areaSenha.setBounds(323, 259, 315, 55);
        contentPane.add(areaSenha);

        areaUsuario = new JTextField();
        areaUsuario.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		areaUsuario.setText(null);
        		areaUsuario.setForeground(Color.DARK_GRAY);
        	}
        });
        areaUsuario.setText("Usuário");
        areaUsuario.setOpaque(false);
        areaUsuario.setForeground(Color.LIGHT_GRAY);
        areaUsuario.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaUsuario.setColumns(10);
        areaUsuario.setBorder(null);
        areaUsuario.setBounds(323, 164, 315, 55);
        contentPane.add(areaUsuario);
  

        areaContato = new JTextField();
        areaContato.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		areaContato.setText(null);
        		areaContato.setForeground(Color.DARK_GRAY);
        	}
        });
        areaContato.setText("Contato");
        areaContato.setOpaque(false);
        areaContato.setForeground(Color.LIGHT_GRAY);
        areaContato.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaContato.setColumns(10);
        areaContato.setBorder(null);
        areaContato.setBounds(323, 354, 315, 55);
        contentPane.add(areaContato);

        areaSalario = new JTextField();
        areaSalario.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		areaSalario.setText(null);
        		areaSalario.setForeground(Color.DARK_GRAY);
        	}
        });
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

            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = table.getSelectedRow();
                if (selectedIndex != -1) {
                    LoginDTO selectedLogin = logins.get(selectedIndex);
                    // Atualizar os dados do funcionário selecionado
                    selectedLogin.setUsuario(areaUsuario.getText());
                    selectedLogin.setContato(areaContato.getText());

                    // Tratamento para o salário
                    double salario = 0.0;
                    try {
                        salario = NumberFormat.getInstance().parse(areaSalario.getText()).doubleValue();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Informe um valor válido para o salário.");
                        return;
                    }
                    selectedLogin.setSalario(salario);

                    // Atualizar no banco de dados
                    LoginDAO dao = new LoginDAO();
                    dao.updateLogin(selectedLogin);

                    // Atualizar na tabela
                    tableModel.setValueAt(selectedLogin.getUsuario(), selectedIndex, 0);
                    tableModel.setValueAt(selectedLogin.getContato(), selectedIndex, 1);
                    tableModel.setValueAt(selectedLogin.getSalario(), selectedIndex, 2);

                    JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário para atualizar.");
                }
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

            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndex = table.getSelectedRow();
                if (selectedIndex != -1) {
                    int option = JOptionPane.showConfirmDialog(null, "Deseja realmente remover este funcionário?");
                    if (option == JOptionPane.YES_OPTION) {
                        LoginDTO selectedLogin = logins.get(selectedIndex);
                        int userID = selectedLogin.getUserID();
                        // Remover do banco de dados
                        LoginDAO dao = new LoginDAO();
                        dao.removeLogin(userID);
                        // Remover da lista
                        tableModel.removeRow(selectedIndex);
                        logins.remove(selectedIndex);
                        JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário para remover.");
                }
            }
        });
        botaoRemoverFuncionario.setIcon(new ImageIcon(Funcionarios.class.getResource("/Imagens/bRemover.png")));
        botaoRemoverFuncionario.setBorder(null);
        botaoRemoverFuncionario.setBounds(328, 615, 310, 60);
        contentPane.add(botaoRemoverFuncionario);

        String[] colunas = {"Usuário", "Contato", "Salário"};
        tableModel = new DefaultTableModel(colunas, 0);
        table = new JTable(tableModel);
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		areaUsuario.setForeground(Color.DARK_GRAY);
        		areaSenha.setForeground(Color.DARK_GRAY);
        		areaContato.setForeground(Color.DARK_GRAY);
        		areaSalario.setForeground(Color.DARK_GRAY);
        		
        	}
        });
        table.setGridColor(new Color(217, 217, 217));
        table.setShowVerticalLines(false);
        table.setFillsViewportHeight(true);
        table.setBorder(null);
        table.setBackground(new Color(217, 217, 217));
        table.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        table.setForeground(Color.DARK_GRAY);
        table.setRowHeight(30);
        

        loadLoginData();


        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = table.getSelectedRow();
                    if (selectedIndex != -1) {
                        LoginDTO selectedLogin = logins.get(selectedIndex);
                        areaUsuario.setText(selectedLogin.getUsuario());
                        areaContato.setText(selectedLogin.getContato());
                        String salarioString = String.valueOf(selectedLogin.getSalario());
                        areaSalario.setText(salarioString);
                    }
                }
            }
        });

    
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setOpaque(false);
        scrollPane.setBounds(686, 86, 548, 590);
        contentPane.add(scrollPane);

        JLabel fundo = new JLabel("");
        fundo.setIcon(new ImageIcon(Funcionarios.class.getResource("/Fundos/Funcionários.png")));
        fundo.setBounds(0, 0, 1280, 720);
        contentPane.add(fundo);
    }

   
    private void loadLoginData() {
        LoginDAO dao = new LoginDAO();
        logins = dao.getAllLogins();
        for (LoginDTO login : logins) {
            Object[] rowData = {login.getUsuario(), login.getContato(), login.getSalario()};
            tableModel.addRow(rowData);
        }
    }
}
