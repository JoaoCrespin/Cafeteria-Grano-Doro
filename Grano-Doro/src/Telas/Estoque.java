package Telas;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import dto.ProdutosDTO;
import dao.CadastroProdutosDAO;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Estoque extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField areaNomeProduto;
    private JTextField areaValorProduto;
    private JList<String> areaProdutos;
    private DefaultListModel<String> listModel;
    private String produtoSelecionado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Estoque frame = new Estoque();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void cadastrarProduto() {
        String nomeproduto = areaNomeProduto.getText();
        String valorproduto = areaValorProduto.getText();

        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setProdutoNome(nomeproduto);
        produtosDTO.setProdutoValor(Float.parseFloat(valorproduto)); // Certifique-se de converter o valor corretamente

        CadastroProdutosDAO cadastroprodutosDAO = new CadastroProdutosDAO();

        boolean isCadastrado = cadastroprodutosDAO.cadastrarProduto(produtosDTO);

        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            atualizarListaProdutos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto.");
        }
    }

    private void atualizarListaProdutos() {
        listModel.clear();
        CadastroProdutosDAO cadastroprodutosDAO = new CadastroProdutosDAO();
        for (ProdutosDTO produto : cadastroprodutosDAO.listarProdutos()) {
            listModel.addElement(produto.getProdutoNome() + " - " + produto.getProdutoValor());
        }
    }

    private void removerProduto() {
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado.");
            return;
        }
        CadastroProdutosDAO cadastroprodutosDAO = new CadastroProdutosDAO();
        boolean isRemovido = cadastroprodutosDAO.removerProduto(produtoSelecionado.split(" - ")[0]);
        if (isRemovido) {
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
            atualizarListaProdutos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao remover produto.");
        }
    }

    private void editarProduto() {
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado.");
            return;
        }

        String nomeproduto = areaNomeProduto.getText();
        String valorproduto = areaValorProduto.getText();

        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setProdutoNome(nomeproduto);
        produtosDTO.setProdutoValor(Float.parseFloat(valorproduto));

        CadastroProdutosDAO cadastroprodutosDAO = new CadastroProdutosDAO();
        boolean isEditado = cadastroprodutosDAO.editarProduto(produtosDTO, produtoSelecionado.split(" - ")[0]);
        if (isEditado) {
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
            atualizarListaProdutos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto.");
        }
    }

    /**
     * Create the frame.
     */
    public Estoque() {
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
				Principal principal  = new Principal();
				principal.setVisible(true);
				dispose();
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
		menuFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuFuncionarios.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuFuncEscolhido.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuFuncionarios.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuFunc.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionarios funcionarios = new Funcionarios();
				funcionarios.setVisible(true);
				dispose();
			}
		});
		menuFuncionarios.setIcon(new ImageIcon(Principal.class.getResource("/Menus/menuFunc.png")));
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
        
        areaNomeProduto = new JTextField();
        areaNomeProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                areaNomeProduto.setText("");
                areaNomeProduto.setForeground(Color.DARK_GRAY);
            }
        });
        areaNomeProduto.setText("Nome do produto");
        areaNomeProduto.setOpaque(false);
        areaNomeProduto.setForeground(Color.LIGHT_GRAY);
        areaNomeProduto.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaNomeProduto.setColumns(10);
        areaNomeProduto.setBorder(null);
        areaNomeProduto.setBounds(322, 158, 318, 55);
        contentPane.add(areaNomeProduto);
        
        areaValorProduto = new JTextField();
        areaValorProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                areaValorProduto.setText("");
                areaValorProduto.setForeground(Color.DARK_GRAY);
            }
        });
        areaValorProduto.setText("Valor do Produto");
        areaValorProduto.setOpaque(false);
        areaValorProduto.setForeground(Color.LIGHT_GRAY);
        areaValorProduto.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaValorProduto.setColumns(10);
        areaValorProduto.setBorder(null);
        areaValorProduto.setBounds(322, 272, 318, 55);
        contentPane.add(areaValorProduto);
        
        listModel = new DefaultListModel<>();
        areaProdutos = new JList<>(listModel);
        areaProdutos.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		areaNomeProduto.setForeground(Color.DARK_GRAY);
        		areaValorProduto.setForeground(Color.DARK_GRAY);
        	}
        });
        areaProdutos.setBackground(new Color(217, 217, 217));
        areaProdutos.setOpaque(false);
        areaProdutos.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    produtoSelecionado = areaProdutos.getSelectedValue();
                    if (produtoSelecionado != null) {
                        String[] dadosProduto = produtoSelecionado.split(" - ");
                        areaNomeProduto.setText(dadosProduto[0]);
                        areaValorProduto.setText(dadosProduto[1]);
                    }
                }
            }
        });
        areaProdutos.setForeground(Color.DARK_GRAY);
        areaProdutos.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaProdutos.setBounds(705, 101, 510, 560);
        contentPane.add(areaProdutos);
        
        JButton botaoCadastrarProduto = new JButton("");
        botaoCadastrarProduto.setBorder(null);
        botaoCadastrarProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bCadastrarProduto.png")));
        botaoCadastrarProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botaoCadastrarProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bCadastrarProdutoApertado.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                botaoCadastrarProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bCadastrarProduto.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                cadastrarProduto();
            }
        });
        botaoCadastrarProduto.setBounds(328, 386, 310, 60);
        contentPane.add(botaoCadastrarProduto);
        
        JButton botaoAtualizarProduto = new JButton("");
        botaoAtualizarProduto.setBorder(null);
        botaoAtualizarProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bAtualizar.png")));
        botaoAtualizarProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botaoAtualizarProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bAtualizarApertado.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                botaoAtualizarProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bAtualizar.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                editarProduto();
            }
        });
        botaoAtualizarProduto.setBounds(328, 469, 310, 60);
        contentPane.add(botaoAtualizarProduto);
        
        JButton botaoRemoverProduto = new JButton("");
        botaoRemoverProduto.setBorder(null);
        botaoRemoverProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bRemover.png")));
        botaoRemoverProduto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botaoRemoverProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bRemoverApertado.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                botaoRemoverProduto.setIcon(new ImageIcon(Estoque.class.getResource("/Imagens/bRemover.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                removerProduto();
            }
        });
        botaoRemoverProduto.setBounds(328, 552, 310, 60);
        contentPane.add(botaoRemoverProduto);
        
        JLabel fundo = new JLabel("");
        fundo.setIcon(new ImageIcon(Estoque.class.getResource("/Fundos/Estoque.png")));
        fundo.setBounds(0, 0, 1280, 720);
        contentPane.add(fundo);
        
        // Atualizar a lista de produtos ao iniciar
        atualizarListaProdutos();
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
