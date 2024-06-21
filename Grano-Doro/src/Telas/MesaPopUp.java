package Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import dto.MesaDTO;
import dto.ProdutosDTO;
import dao.AcessoProdutosDAO;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class MesaPopUp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField areaCodProduto;
    private JTextField areaQuantidade;
    private JTextField areaDinheiro;
    private JTextField areaTroco;
    private DefaultListModel<String> listModel;
    private JList<String> areaLista;
    private JLabel lblValorTotal;
    private double valorTotal;
    private MesaDTO mesa;
    private JButton botaoMesa;

    public MesaPopUp(MesaDTO mesa, JButton botaoMesa) {
    	setUndecorated(true);
        this.mesa = mesa;
        this.botaoMesa = botaoMesa;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 680);
        setLocationRelativeTo(null);
        int verticalOffset = -20;
        setLocation(getX(), getY() - verticalOffset);
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
		lblMinimizar.setBounds(958, 0, 32, 32);
		contentPane.add(lblMinimizar);

        areaCodProduto = new JTextField();
        areaCodProduto.setText("Nome do Produto");
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
        areaCodProduto.setBounds(36, 117, 305, 55);
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
        areaQuantidade.setBounds(36, 225, 180, 55);
        contentPane.add(areaQuantidade);

        areaDinheiro = new JTextField();
        areaDinheiro.setText("Dinheiro");
        areaDinheiro.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                calcularTroco();
            }
            public void removeUpdate(DocumentEvent e) {
                calcularTroco();
            }
            public void insertUpdate(DocumentEvent e) {
                calcularTroco();
            }
        });
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
        areaDinheiro.setBounds(36, 339, 305, 55);
        contentPane.add(areaDinheiro);

        areaTroco = new JTextField();
        areaTroco.setText("Troco");
        areaTroco.setForeground(Color.DARK_GRAY);
        areaTroco.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaTroco.setEditable(false);
        areaTroco.setOpaque(false);
        areaTroco.setColumns(10);
        areaTroco.setBorder(null);
        areaTroco.setBounds(36, 549, 305, 55);
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
                String nomeProduto = areaCodProduto.getText();
                int quantidade;

                try {
                    quantidade = Integer.parseInt(areaQuantidade.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("Quantidade inválida!");
                    return;
                }

                ProdutosDTO produto = buscarProdutoPorNome(nomeProduto);
                if (produto != null) {
                    mesa.adicionarProduto(produto);
                    atualizarLista(produto, quantidade);
                } else {
                    System.out.println("Produto não encontrado!");
                }
                atualizarImagemMesa();
            }
        });
        botaoAdicionar.setBorder(null);
        botaoAdicionar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bAdicionarP.png")));
        botaoAdicionar.setBounds(238, 196, 160, 60);
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
                int selectedIndex = areaLista.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                    mesa.getProdutos().remove(selectedIndex);
                    calcularValorTotal();
                }
                atualizarImagemMesa();
            }
        });
        botaoRemover.setBorder(null);
        botaoRemover.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bRemoverP.png")));
        botaoRemover.setBounds(238, 259, 160, 60);
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
                finalizarCompra();
            }
        });
        botaoFinalizar.setBorder(null);
        botaoFinalizar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bFinalizarCompra.png")));
        botaoFinalizar.setBounds(60, 447, 310, 60);
        contentPane.add(botaoFinalizar);

        listModel = new DefaultListModel<>();
        areaLista = new JList<>(listModel);
        areaLista.setBackground(new Color(217, 217, 217));
        areaLista.setBorder(null);
        areaLista.setOpaque(false);
        areaLista.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaLista.setForeground(Color.DARK_GRAY);

        JScrollPane scrollPane = new JScrollPane(areaLista);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
        scrollPane.setBackground(new Color(217, 217, 217));
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBounds(431, 68, 538, 540);
        contentPane.add(scrollPane);
        
        lblValorTotal = new JLabel("R$ 0.00");
        lblValorTotal.setForeground(new Color(255, 255, 255));
        lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblValorTotal.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
        lblValorTotal.setBounds(795, 608, 174, 55);
        contentPane.add(lblValorTotal);

        JLabel fundo = new JLabel("");
        fundo.setIcon(new ImageIcon(Caixa.class.getResource("/Fundos/Mesa.png")));
        fundo.setBounds(0, 0, 1000, 680);
        contentPane.add(fundo);

        for (ProdutosDTO produto : mesa.getProdutos()) {
            listModel.addElement(produto.getProdutoNome() + " - 1"); // Exibir quantidade 1 como exemplo
        }
        atualizarImagemMesa();
        calcularValorTotal(); // Atualizar o valor total ao iniciar a janela
    }

    private ProdutosDTO buscarProdutoPorNome(String nomeProduto) {
        AcessoProdutosDAO dao = new AcessoProdutosDAO();
        List<ProdutosDTO> produtos = dao.buscarProdutos();

        for (ProdutosDTO produto : produtos) {
            if (produto.getProdutoNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }

    private void atualizarLista(ProdutosDTO produto, int quantidade) {
        for (int i = 0; i < listModel.size(); i++) {
            String item = listModel.get(i);
            if (item.startsWith(produto.getProdutoNome() + " - ")) {
                String[] partes = item.split(" - ");
                int quantidadeAtual = Integer.parseInt(partes[1]);
                int novaQuantidade = quantidadeAtual + quantidade;
                listModel.set(i, produto.getProdutoNome() + " - " + novaQuantidade);
                calcularValorTotal();
                return;
            }
        }
        listModel.addElement(produto.getProdutoNome() + " - " + quantidade);
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        valorTotal = 0.0;
        for (int i = 0; i < listModel.size(); i++) {
            String item = listModel.get(i);
            String[] partes = item.split(" - ");
            String nomeProduto = partes[0];
            int quantidade = Integer.parseInt(partes[1]);

            ProdutosDTO produto = buscarProdutoPorNome(nomeProduto);
            if (produto != null) {
                valorTotal += produto.getProdutoValor() * quantidade;
            }
        }
        lblValorTotal.setText(String.format("R$ %.2f", valorTotal));
        calcularTroco();
    }

    private void calcularTroco() {
        try {
            double dinheiro = Double.parseDouble(areaDinheiro.getText());
            double troco = dinheiro - valorTotal;
            areaTroco.setText(String.format("R$ %.2f", troco));
        } catch (NumberFormatException e) {
            areaTroco.setText("R$ 0.00");
        }
    }

    private void finalizarCompra() {
        areaCodProduto.setText("Nome do Produto");
        areaCodProduto.setForeground(Color.LIGHT_GRAY);
        areaQuantidade.setText("Quantidade");
        areaQuantidade.setForeground(Color.LIGHT_GRAY);
        areaDinheiro.setText("Dinheiro");
        areaDinheiro.setForeground(Color.LIGHT_GRAY);
        areaTroco.setText("Troco");
        listModel.clear();
        lblValorTotal.setText("R$ 0.00");
        mesa.limparProdutos();
        atualizarImagemMesa();
    }

    private void atualizarImagemMesa() {
        if (mesa.getProdutos().isEmpty()) {
            botaoMesa.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaLivre.png")));
        } else {
            botaoMesa.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaOcupada.png")));
        }
    }
}
