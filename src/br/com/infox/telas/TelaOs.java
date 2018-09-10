package br.com.infox.telas;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;

public class TelaOs extends JInternalFrame {
	private JPanel panel;
	private JLabel lblNOs;
	private JLabel lblData;
	private JTextField txtOs;
	private JTextField txtData;
	private JRadioButton rbtOrc;
	private JRadioButton rbtOs;
	private ButtonGroup bg = new ButtonGroup();
	private JLabel lblSituao;
	private JComboBox cboOsSit;
	private JPanel panel_1;
	private JTextField txtCliPesquisar;
	private JLabel label;
	private JLabel lblid;
	private JTextField txtCliID;
	private JTable tblClientes;
	private JLabel lblEquipamento;
	private JLabel lblDefeito;
	private JLabel lblServio;
	private JLabel lblTcnico;
	private JTextField txtOsEquip;
	private JTextField txtOsDef;
	private JTextField txtOsServ;
	private JTextField txtOsTec;
	private JLabel lblValorTotal;
	private JTextField txtOsValor;

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
					TelaOs frame = new TelaOs();
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
	public TelaOs() {

		initialize();
		bg.add(rbtOrc);
		bg.add(rbtOs);
	}

	private void initialize() {
		setTitle("Ordem de Serviço");
		setIconifiable(true);
		setClosable(true);
		setPreferredSize(new Dimension(640, 480));
		setBounds(100, 100, 739, 536);
		
		JButton btnOsAdicionar = new JButton("");
		btnOsAdicionar.setToolTipText("Adicionar");
		btnOsAdicionar.setMinimumSize(new Dimension(50, 50));
		btnOsAdicionar.setMaximumSize(new Dimension(50, 50));
		Image create = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/Add.png")).getImage();
		btnOsAdicionar.setIcon(new ImageIcon(create));
		btnOsAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		JButton btnOsPesquisar = new JButton("");
		btnOsPesquisar.setToolTipText("Pesquisar");
		btnOsPesquisar.setMinimumSize(new Dimension(50, 50));
		btnOsPesquisar.setMaximumSize(new Dimension(50, 50));
		Image find = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/Find.png")).getImage();
		btnOsPesquisar.setIcon(new ImageIcon(find));
		btnOsPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		JButton btnOsAlterar = new JButton("");
		btnOsAlterar.setToolTipText("Alterar");
		btnOsAlterar.setMinimumSize(new Dimension(50, 50));
		btnOsAlterar.setMaximumSize(new Dimension(50, 50));
		Image edit = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/edit.png")).getImage();
		btnOsAlterar.setIcon(new ImageIcon(edit));
		btnOsAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnOsExcluir = new JButton("");
		btnOsExcluir.setToolTipText("Excluir");
		btnOsExcluir.setMinimumSize(new Dimension(50, 50));
		btnOsExcluir.setMaximumSize(new Dimension(50, 50));
		Image delete = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/delete.png")).getImage();
		btnOsExcluir.setIcon(new ImageIcon(delete));
		btnOsExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnOsImprimir = new JButton("");
		btnOsImprimir.setToolTipText("Imprimir OS");
		btnOsImprimir.setMinimumSize(new Dimension(50, 50));
		btnOsImprimir.setMaximumSize(new Dimension(50, 50));
		Image imprimir = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/print-icon.png")).getImage();
		btnOsImprimir.setIcon(new ImageIcon(imprimir));
		btnOsImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(getLblSituao())
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getCboOsSit(), 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getPanel_1(), GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(getLblEquipamento())
								.addComponent(getLblDefeito())
								.addComponent(getLblTcnico())
								.addComponent(getLblServio()))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(getTxtOsServ(), GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtOsDef(), GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtOsEquip(), GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(getTxtOsTec(), GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(getLblValorTotal())
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getTxtOsValor()))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(205)
							.addComponent(btnOsAdicionar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOsPesquisar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOsAlterar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnOsExcluir, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOsImprimir, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getPanel_1(), GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblSituao())
								.addComponent(getCboOsSit(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLblEquipamento())
						.addComponent(getTxtOsEquip(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLblDefeito())
						.addComponent(getTxtOsDef(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getTxtOsServ(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblServio()))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLblTcnico())
						.addComponent(getTxtOsTec(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblValorTotal())
						.addComponent(getTxtOsValor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOsPesquisar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOsAlterar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOsExcluir, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOsImprimir, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOsAdicionar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(33))
		);
		getContentPane().setLayout(groupLayout);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup().addContainerGap()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(getLblNOs())
											.addComponent(getTxtOs(), GroupLayout.PREFERRED_SIZE, 48,
													GroupLayout.PREFERRED_SIZE))
									.addGap(38)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(getLblData())
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
													.addComponent(getRbtOs())
													.addComponent(getTxtData(), GroupLayout.PREFERRED_SIZE, 136,
															GroupLayout.PREFERRED_SIZE))))
							.addComponent(getRbtOrc())).addContainerGap(16, Short.MAX_VALUE)));
			gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panel.createSequentialGroup().addContainerGap()
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblNOs()).addComponent(getLblData()))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(getTxtOs(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(getTxtData(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
													.addComponent(getRbtOrc())
													.addComponent(getRbtOs()))
											.addContainerGap(15, Short.MAX_VALUE)));
			panel.setLayout(gl_panel);
		}
		return panel;
	}

	private JLabel getLblNOs() {
		if (lblNOs == null) {
			lblNOs = new JLabel("Nº OS");
		}
		return lblNOs;
	}

	private JLabel getLblData() {
		if (lblData == null) {
			lblData = new JLabel("Data");
		}
		return lblData;
	}

	private JTextField getTxtOs() {
		if (txtOs == null) {
			txtOs = new JTextField();
			txtOs.setEditable(false);
			txtOs.setColumns(10);
		}
		return txtOs;
	}

	private JTextField getTxtData() {
		if (txtData == null) {
			txtData = new JTextField();
			txtData.setEditable(false);
			txtData.setColumns(10);
		}
		return txtData;
	}

	private JRadioButton getRbtOrc() {
		if (rbtOrc == null) {
			rbtOrc = new JRadioButton("Orçamento");
		}
		return rbtOrc;
	}

	private JRadioButton getRbtOs() {
		if (rbtOs == null) {
			rbtOs = new JRadioButton("Ordem de Serviço");
		}
		return rbtOs;
	}

	private JLabel getLblSituao() {
		if (lblSituao == null) {
			lblSituao = new JLabel("Situação");
			lblSituao.setFont(new Font("SansSerif", Font.PLAIN, 13));
		}
		return lblSituao;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getCboOsSit() {
		if (cboOsSit == null) {
			cboOsSit = new JComboBox();
			cboOsSit.setModel(new DefaultComboBoxModel(new String[] { "Entrega OK", "Orçamento REPROVADO",
					"Aguardando Aprovação", "Aguardando peças", "Abandonado pelo cliente", "Na bancada", "Retorno" }));
		}
		return cboOsSit;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			JScrollPane scrollPane = new JScrollPane();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(getTxtCliPesquisar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getLabel())
								.addGap(35)
								.addComponent(getLblid())
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getTxtCliID(), GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(49, Short.MAX_VALUE))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTxtCliPesquisar())
								.addComponent(getLabel()))
							.addComponent(getLblid())
							.addComponent(getTxtCliID()))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGap(27))
			);
			scrollPane.setViewportView(getTblClientes());
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}

	private JTextField getTxtCliPesquisar() {
		if (txtCliPesquisar == null) {
			txtCliPesquisar = new JTextField();
			txtCliPesquisar.setText("");
			txtCliPesquisar.setColumns(10);
		}
		return txtCliPesquisar;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			Image search = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/search-icon.png"))
					.getImage();
			label.setIcon(new ImageIcon(search));
		}
		return label;
	}

	private JLabel getLblid() {
		if (lblid == null) {
			lblid = new JLabel("*ID");
		}
		return lblid;
	}

	private JTextField getTxtCliID() {
		if (txtCliID == null) {
			txtCliID = new JTextField();
			txtCliID.setColumns(10);
		}
		return txtCliID;
	}

	private JTable getTblClientes() {
		if (tblClientes == null) {
			tblClientes = new JTable();
			tblClientes.setModel(
					new javax.swing.table.DefaultTableModel(
							new Object[][] { { null, null, null, null }, { null, null, null, null },
									{ null, null, null, null }, { null, null, null, null } },
							new String[] { "Id", "Nome", "Fone" }));
			// jScrollPane1.setViewportView(table);
		}
		return tblClientes;
	}
	private JLabel getLblEquipamento() {
		if (lblEquipamento == null) {
			lblEquipamento = new JLabel("* Equipamento");
			lblEquipamento.setFont(new Font("SansSerif", Font.PLAIN, 13));
		}
		return lblEquipamento;
	}
	private JLabel getLblDefeito() {
		if (lblDefeito == null) {
			lblDefeito = new JLabel("* Defeito");
			lblDefeito.setFont(new Font("SansSerif", Font.PLAIN, 13));
		}
		return lblDefeito;
	}
	private JLabel getLblServio() {
		if (lblServio == null) {
			lblServio = new JLabel("Serviço");
			lblServio.setFont(new Font("SansSerif", Font.PLAIN, 13));
		}
		return lblServio;
	}
	private JLabel getLblTcnico() {
		if (lblTcnico == null) {
			lblTcnico = new JLabel("Técnico");
			lblTcnico.setFont(new Font("SansSerif", Font.PLAIN, 13));
		}
		return lblTcnico;
	}
	private JTextField getTxtOsEquip() {
		if (txtOsEquip == null) {
			txtOsEquip = new JTextField();
			txtOsEquip.setColumns(10);
		}
		return txtOsEquip;
	}
	private JTextField getTxtOsDef() {
		if (txtOsDef == null) {
			txtOsDef = new JTextField();
			txtOsDef.setColumns(10);
		}
		return txtOsDef;
	}
	private JTextField getTxtOsServ() {
		if (txtOsServ == null) {
			txtOsServ = new JTextField();
			txtOsServ.setColumns(10);
		}
		return txtOsServ;
	}
	private JTextField getTxtOsTec() {
		if (txtOsTec == null) {
			txtOsTec = new JTextField();
			txtOsTec.setColumns(10);
		}
		return txtOsTec;
	}
	private JLabel getLblValorTotal() {
		if (lblValorTotal == null) {
			lblValorTotal = new JLabel("Valor Total");
			lblValorTotal.setFont(new Font("SansSerif", Font.PLAIN, 13));
		}
		return lblValorTotal;
	}
	private JTextField getTxtOsValor() {
		if (txtOsValor == null) {
			txtOsValor = new JTextField();
			txtOsValor.setColumns(10);
		}
		return txtOsValor;
	}
}
