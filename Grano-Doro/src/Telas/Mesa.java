package Telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import dto.MesaDTO;

public class Mesa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<MesaDTO> mesas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mesa frame = new Mesa();
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
    public Mesa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        mesas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mesas.add(new MesaDTO());
        }

        JButton botaoMesaLivre1 = new JButton("");
        botaoMesaLivre1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirComanda(0, botaoMesaLivre1);
            }
        });
        botaoMesaLivre1.setBorder(null);
        botaoMesaLivre1.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaLivre.png")));
        botaoMesaLivre1.setBounds(445, 147, 190, 190);
        contentPane.add(botaoMesaLivre1);

        JButton botaoMesaLivre2 = new JButton("");
        botaoMesaLivre2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirComanda(1, botaoMesaLivre2);
            }
        });
        botaoMesaLivre2.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaLivre.png")));
        botaoMesaLivre2.setBorder(null);
        botaoMesaLivre2.setBounds(685, 147, 190, 190);
        contentPane.add(botaoMesaLivre2);

        JButton botaoMesaLivre3 = new JButton("");
        botaoMesaLivre3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirComanda(2, botaoMesaLivre3);
            }
        });
        botaoMesaLivre3.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaLivre.png")));
        botaoMesaLivre3.setBorder(null);
        botaoMesaLivre3.setBounds(925, 147, 190, 190);
        contentPane.add(botaoMesaLivre3);

        JButton botaoMesaLivre4 = new JButton("");
        botaoMesaLivre4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirComanda(3, botaoMesaLivre4);
            }
        });
        botaoMesaLivre4.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaLivre.png")));
        botaoMesaLivre4.setBorder(null);
        botaoMesaLivre4.setBounds(445, 392, 190, 190);
        contentPane.add(botaoMesaLivre4);

        JButton botaoMesaLivre5 = new JButton("");
        botaoMesaLivre5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirComanda(4, botaoMesaLivre5);
            }
        });
        botaoMesaLivre5.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaLivre.png")));
        botaoMesaLivre5.setBorder(null);
        botaoMesaLivre5.setBounds(685, 392, 190, 190);
        contentPane.add(botaoMesaLivre5);

        JButton botaoMesaLivre6 = new JButton("");
        botaoMesaLivre6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirComanda(5, botaoMesaLivre6);
            }
        });
        botaoMesaLivre6.setIcon(new ImageIcon(Mesa.class.getResource("/Imagens/bMesaLivre.png")));
        botaoMesaLivre6.setBorder(null);
        botaoMesaLivre6.setBounds(925, 392, 190, 190);
        contentPane.add(botaoMesaLivre6);

        JLabel fundo = new JLabel("");
        fundo.setBounds(0, 0, 1280, 720);
        fundo.setIcon(new ImageIcon(Mesa.class.getResource("/Fundos/Principal.png")));
        contentPane.add(fundo);
    }

    private void abrirComanda(int mesaIndex, JButton botaoMesa) {
        MesaDTO mesa = mesas.get(mesaIndex);
        MesaPopUp mesaPopUp = new MesaPopUp(mesa, botaoMesa);
        mesaPopUp.setVisible(true);
    }
}
