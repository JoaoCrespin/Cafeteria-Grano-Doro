package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem menuMesas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuCafe = new JMenuBar();
		menuCafe.setBounds(0, 0, 1264, 50);
		contentPane.add(menuCafe);
		
		JMenuItem menuCaixa = new JMenuItem("Caixa");
		menuCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		menuCafe.add(menuCaixa);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Estoque ");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		menuCafe.add(mntmNewMenuItem);
		
		JMenuItem menuVendas = new JMenuItem("Vendas");
		menuCafe.add(menuVendas);
		
		menuMesas = new JMenuItem("Mesas");
		menuCafe.add(menuMesas);
		
		JMenuItem menuSair = new JMenuItem("Sair");
		menuCafe.add(menuSair);
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
