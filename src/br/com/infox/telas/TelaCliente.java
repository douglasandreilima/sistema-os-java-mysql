package br.com.infox.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTable;

public class TelaCliente extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblcamposObrigatrios;
	private JLabel lblnome;
	private JLabel lblEndereo;
	private JLabel lbltelefone;
	private JLabel lblEmail;
	private JTextField txtCliNome;
	private JTextField txtCliEndereco;
	private JTextField txtCliFone;
	private JTextField txtCliEmail;
	private JButton btnCliCreate;
	private JButton btnCliUpdate;
	private JButton btnCliDelete;
	private JTextField txtCliPesquisar;
	private JLabel label;
	private JTable tblClientes;

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
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {

		initialize();
	}
	private void initialize() {
		
		setClosable(true);
		setIconifiable(true);
		setTitle("Clientes");
		setBounds(100, 100, 744, 530);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(252)
					.addComponent(getBtnCliCreate(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getBtnCliUpdate(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(getBtnCliDelete(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getTblClientes(), GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(getLblnome())
											.addComponent(getLblEndereo()))
										.addGap(28)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(getTxtCliEndereco())
											.addComponent(getTxtCliNome(), GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(getLbltelefone())
											.addComponent(getLblEmail()))
										.addGap(28)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(getTxtCliFone(), GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
											.addComponent(getTxtCliEmail(), GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
								.addComponent(getTxtCliPesquisar(), GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getLabel_1())
								.addGap(87)
								.addComponent(getLblcamposObrigatrios())
								.addGap(30)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(getLblcamposObrigatrios()))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getLabel_1())
								.addComponent(getTxtCliPesquisar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(getTblClientes(), GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLblnome())
						.addComponent(getTxtCliNome(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLblEndereo())
						.addComponent(getTxtCliEndereco(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLbltelefone())
						.addComponent(getTxtCliFone(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getTxtCliEmail(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblEmail()))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getBtnCliCreate(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(getBtnCliUpdate(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(getBtnCliDelete(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	private JLabel getLblcamposObrigatrios() {
		if (lblcamposObrigatrios == null) {
			lblcamposObrigatrios = new JLabel("*Campos obrigatórios");
			lblcamposObrigatrios.setForeground(Color.RED);
			lblcamposObrigatrios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblcamposObrigatrios;
	}
	private JLabel getLblnome() {
		if (lblnome == null) {
			lblnome = new JLabel("*Nome");
			lblnome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblnome;
	}
	private JLabel getLblEndereo() {
		if (lblEndereo == null) {
			lblEndereo = new JLabel("Endereço");
			lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblEndereo;
	}
	private JLabel getLbltelefone() {
		if (lbltelefone == null) {
			lbltelefone = new JLabel("*Telefone");
			lbltelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbltelefone;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblEmail;
	}
	private JTextField getTxtCliNome() {
		if (txtCliNome == null) {
			txtCliNome = new JTextField();
			txtCliNome.setColumns(10);
		}
		return txtCliNome;
	}
	private JTextField getTxtCliEndereco() {
		if (txtCliEndereco == null) {
			txtCliEndereco = new JTextField();
			txtCliEndereco.setColumns(10);
		}
		return txtCliEndereco;
	}
	private JTextField getTxtCliFone() {
		if (txtCliFone == null) {
			txtCliFone = new JTextField();
			txtCliFone.setColumns(10);
		}
		return txtCliFone;
	}
	private JTextField getTxtCliEmail() {
		if (txtCliEmail == null) {
			txtCliEmail = new JTextField();
			txtCliEmail.setColumns(10);
		}
		return txtCliEmail;
	}
	private JButton getBtnCliCreate() {
		if (btnCliCreate == null) {
			btnCliCreate = new JButton("");
			btnCliCreate.setToolTipText("Adicionar");
			Image create = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/Add.png")).getImage();
			btnCliCreate.setIcon(new ImageIcon(create));
			btnCliCreate.setMinimumSize(new Dimension(50, 50));
			btnCliCreate.setMaximumSize(new Dimension(50, 50));
		}
		return btnCliCreate;
	}
	private JButton getBtnCliUpdate() {
		if (btnCliUpdate == null) {
			btnCliUpdate = new JButton("");
			btnCliUpdate.setToolTipText("Alterar");
			Image update = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/edit.png")).getImage();
			btnCliUpdate.setIcon(new ImageIcon(update));
			btnCliUpdate.setMinimumSize(new Dimension(50, 50));
			btnCliUpdate.setMaximumSize(new Dimension(50, 50));
		}
		return btnCliUpdate;
	}
	private JButton getBtnCliDelete() {
		if (btnCliDelete == null) {
			btnCliDelete = new JButton("");
			btnCliDelete.setToolTipText("Remover");
			Image delete = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/delete.png")).getImage();
			btnCliDelete.setIcon(new ImageIcon(delete));
			btnCliDelete.setMinimumSize(new Dimension(50, 50));
			btnCliDelete.setMaximumSize(new Dimension(50, 50));
		}
		return btnCliDelete;
	}
	private JTextField getTxtCliPesquisar() {
		if (txtCliPesquisar == null) {
			txtCliPesquisar = new JTextField();
			txtCliPesquisar.setColumns(10);
		}
		return txtCliPesquisar;
	}
	private JLabel getLabel_1() {
		if (label == null) {
			label = new JLabel("");
			Image search = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/search-icon.png")).getImage();
			label.setIcon(new ImageIcon(search));
		}
		return label;
	}
	private JTable getTblClientes() {
		if (tblClientes == null) {
			tblClientes = new JTable();
		}
		return tblClientes;
	}
}
