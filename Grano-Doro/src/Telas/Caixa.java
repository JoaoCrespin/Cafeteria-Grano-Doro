package Telas;

import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;

import dao.AcessoProdutosDAO;
import dto.ProdutosDTO;

public class Caixa extends JFrame {

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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Caixa frame = new Caixa();
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
    public Caixa() {
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
        
        lblValorTotal = new JLabel("R$ 0.00");
        lblValorTotal.setBounds(917, 626, 137, 48);
        contentPane.add(lblValorTotal);
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
                setVisible(false);
                Mesa mesa = new Mesa();
                mesa.setVisible(true);
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
        areaCodProduto.setBounds(309, 137, 305, 55);
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
        areaQuantidade.setBounds(309, 245, 180, 55);
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
        areaDinheiro.setBounds(309, 367, 305, 55);
        contentPane.add(areaDinheiro);

        areaTroco = new JTextField();
        areaTroco.setText("Troco");
        areaTroco.setForeground(Color.DARK_GRAY);
        areaTroco.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaTroco.setEditable(false);
        areaTroco.setOpaque(false);
        areaTroco.setColumns(10);
        areaTroco.setBorder(null);
        areaTroco.setBounds(309, 569, 305, 55);
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
                    atualizarLista(produto, quantidade);
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }
        });
        botaoAdicionar.setBorder(null);
        botaoAdicionar.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bAdicionarP.png")));
        botaoAdicionar.setBounds(511, 216, 160, 60);
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
                    calcularValorTotal();
                }
            }
        });
        botaoRemover.setBorder(null);
        botaoRemover.setIcon(new ImageIcon(Caixa.class.getResource("/Imagens/bRemoverP.png")));
        botaoRemover.setBounds(511, 279, 160, 60);
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
        botaoFinalizar.setBounds(328, 471, 310, 60);
        contentPane.add(botaoFinalizar);

        listModel = new DefaultListModel<>();
        areaLista = new JList<>(listModel);
        areaLista.setFont(new Font("Segoe UI Light", Font.BOLD, 24));
        areaLista.setForeground(Color.DARK_GRAY);

        JScrollPane scrollPane = new JScrollPane(areaLista);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBounds(711, 107, 498, 493);
        contentPane.add(scrollPane);

        JLabel fundo = new JLabel("");
        fundo.setIcon(new ImageIcon(Caixa.class.getResource("/Fundos/Caixa.png")));
        fundo.setBounds(0, 0, 1280, 720);
        contentPane.add(fundo);
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
