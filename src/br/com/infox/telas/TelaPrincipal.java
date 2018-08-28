package br.com.infox.telas;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JPanel contentPane;
	private JMenuBar menu;
	private JMenu menCad;
	public static JMenu menRel;
	private JMenu menAju;
	private JMenu menOpc;
	private JMenuItem menCadCli;
	private JMenuItem menCadOs;
	public static JMenuItem menCadUsu;
	private JMenuItem menRelSer;
	private JMenuItem menAjuSob;
	private JMenuItem menOpcSai;
	private JDesktopPane desktop;
	public static JLabel lblUsuario;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		


		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				//as linhas abaixo substituem a lbldata pela data atual  
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
				
				lblData.setText(formatador.format(data));
			}
		});
		setTitle("X - Sistema Controle de OS ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 559);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(getDesktop(), GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(getDesktop(), GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

	private JMenuBar getMenuBar_1() {
		if (menu == null) {
			menu = new JMenuBar();
			menu.setBackground(Color.LIGHT_GRAY);
			menu.setAlignmentY(Component.CENTER_ALIGNMENT);
			menu.add(getMenCad());
			menu.add(getMenRel());
			menu.add(getMenAju());
			menu.add(getMenOpc());
		}
		return menu;
	}

	private JMenu getMenCad() {
		if (menCad == null) {
			menCad = new JMenu("Cadastro");
			menCad.add(getMenCadCli());
			menCad.add(getMenCadOs());
			menCad.add(getMenCadUsu());
		}
		return menCad;
	}

	private JMenu getMenRel() {
		if (menRel == null) {
			menRel = new JMenu("Relat\u00F3rio");
			menRel.setEnabled(false);
			menRel.add(getMenRelSer());
		}
		return menRel;
	}

	private JMenu getMenAju() {
		if (menAju == null) {
			menAju = new JMenu("Ajuda");
			menAju.add(getMenAjuSob());
		}
		return menAju;
	}

	private JMenu getMenOpc() {
		if (menOpc == null) {
			menOpc = new JMenu("Op\u00E7\u00F5es");
			menOpc.add(getMenOpcSai());
		}
		return menOpc;
	}

	private JMenuItem getMenCadCli() {
		if (menCadCli == null) {
			menCadCli = new JMenuItem("Cliente");
			menCadCli.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
			menCadCli.setSelected(true);
		}
		return menCadCli;
	}

	private JMenuItem getMenCadOs() {
		if (menCadOs == null) {
			menCadOs = new JMenuItem("OS");
			menCadOs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
		}
		return menCadOs;
	}

	private JMenuItem getMenCadUsu() {
		if (menCadUsu == null) {
			menCadUsu = new JMenuItem("Usu\u00E1rios");
			menCadUsu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Linhas abaixo abre Form tela usuario dentro de dekstop Pane
					
					TelaUsuario telaUsuario = new TelaUsuario();
					telaUsuario.setVisible(true);
					desktop.add(telaUsuario);
				}
			});
			menCadUsu.setEnabled(false);
			menCadUsu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_MASK));
		}
		return menCadUsu;
	}

	private JMenuItem getMenRelSer() {
		if (menRelSer == null) {
			menRelSer = new JMenuItem("Servi\u00E7os");
			menRelSer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		}
		return menRelSer;
	}

	private JMenuItem getMenAjuSob() {
		if (menAjuSob == null) {
			menAjuSob = new JMenuItem("Sobre");
			menAjuSob.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//Chamando a tela sobre	
					
					TelaSobre sobre = new TelaSobre();
					
					sobre.setVisible(true);				
				
				}
			});
			menAjuSob.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return menAjuSob;
	}

	private JMenuItem getMenOpcSai() {
		if (menOpcSai == null) {
			menOpcSai = new JMenuItem("Sair");
			menOpcSai.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//exibe uma caixa de dialogo
					int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair", "Atenção", JOptionPane.YES_NO_OPTION);
					if(sair == JOptionPane.YES_OPTION) {
						System.exit(0); 
					}
				}
			});
			menOpcSai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		}
		return menOpcSai;
	}

	private JDesktopPane getDesktop() {
		if (desktop == null) {
			desktop = new JDesktopPane();
			GroupLayout gl_desktop = new GroupLayout(desktop);
			gl_desktop.setHorizontalGroup(
				gl_desktop.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_desktop.createSequentialGroup()
						.addContainerGap(735, Short.MAX_VALUE)
						.addGroup(gl_desktop.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(getLblData(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getLblUsuario(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
						.addGap(54))
			);
			gl_desktop.setVerticalGroup(
				gl_desktop.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_desktop.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblUsuario(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getLblData(), GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(427, Short.MAX_VALUE))
			);
			desktop.setLayout(gl_desktop);
		}
		return desktop;
	}

	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usu\u00E1rio");
			lblUsuario.setForeground(Color.LIGHT_GRAY);
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblUsuario;
	}

	private JLabel getLblData() {
		if (lblData == null) {
			lblData = new JLabel("Data");
			lblData.setForeground(Color.LIGHT_GRAY);
			lblData.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblData;
	}
}
