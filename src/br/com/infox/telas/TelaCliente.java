package br.com.infox.telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import br.com.infox.dal.ModuloConexao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//importando recursos da biblioteca rs2xml.jar
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

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

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JLabel lblIdCliente;
	private JTextField txtCliID;
	private JScrollPane scrollPane;

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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getLblEndereo())
								.addComponent(getLblnome())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(getLblEmail())
									.addComponent(getLbltelefone(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(getLabel_1_1(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getTxtCliNome(), GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtCliEndereco(), 578, 578, 578)
								.addComponent(getTxtCliID(), GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(getTxtCliFone(), GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
										.addComponent(getTxtCliEmail(), GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(getTxtCliPesquisar(), GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getLabel_1())
							.addGap(87)
							.addComponent(getLblcamposObrigatrios())
							.addGap(30))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(getScrollPane(), GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
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
					.addComponent(getScrollPane(), GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLabel_1_1())
						.addComponent(getTxtCliID(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getTxtCliNome(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblnome()))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getTxtCliEndereco(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblEndereo()))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLbltelefone())
						.addComponent(getTxtCliFone(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
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

	private void adicionar() {
		String sql = "INSERT INTO tbclientes(nomecli,endcli,fonecli,emailcli) VALUES(?,?,?,?)";
		conexao = ModuloConexao.conector();
		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, txtCliNome.getText());
			pst.setString(2, txtCliEndereco.getText());
			pst.setString(3, txtCliFone.getText());
			pst.setString(4, txtCliEmail.getText());

			// validacao campos obrigatorios
			if ((txtCliNome.getText().isEmpty()) || (txtCliFone.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
			} else {

				// linha abaixo atualiza a tabela usuarios com os dados do formulario
				// estrutura abaixo é usada para confirmar a insercao dos dados ao usuario
				int adicionado = pst.executeUpdate();

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");

					// apos adicionar limpar os campos

					txtCliFone.setText(null);
					txtCliEndereco.setText(null);
					txtCliEmail.setText(null);
					txtCliNome.setText(null);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
			}
		}
	}

	// metodo pesquisar clientes pelo nome com filtro
	private void pesquisarCliente() {
		String sql = "select * from tbclientes where nomecli like ?";
		conexao = ModuloConexao.conector();

		try {
			pst = conexao.prepareStatement(sql);

			// % eh continuacao do comando sql da string sql
			pst.setString(1, txtCliPesquisar.getText() + "%");

			rs = pst.executeQuery();

			// abaixo usa a bibilioteca rs2xml.jar para preecher a tabela
			tblClientes.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
			}
		}
	}

	// metodo para setar os campos do formulario com o conteudo da tabela de
	// pesquisa cliente
	public void setarCampos() {
		int setar = tblClientes.getSelectedRow();
		txtCliID.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
		txtCliNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
		txtCliEndereco.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
		txtCliFone.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
		txtCliEmail.setText(tblClientes.getModel().getValueAt(setar, 4).toString());

		btnCliCreate.setEnabled(false);
	}

	// alterar dados do cliente (update)
	private void alterar() {
		String sql = "update tbclientes set nomecli=?,endcli=?,fonecli=?,emailcli=? where idcli=?";
		conexao = ModuloConexao.conector();

		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, txtCliNome.getText());
			pst.setString(2, txtCliEndereco.getText());
			pst.setString(3, txtCliFone.getText());
			pst.setString(4, txtCliEmail.getText());
			pst.setString(5, txtCliID.getText());

			// validacao campos obrigatorios
			if ((txtCliNome.getText().isEmpty()) || (txtCliFone.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null,
						"Preencha todos os campos obrigatórios ou selecione algum cliente na pesquisa");
			} else {

				// linha abaixo atualiza a tabela cliente com os dados do formulario
				// estrutura abaixo é usada para confirmar a alteracao dos dados do cliente na
				// tabela
				int adicionado = pst.executeUpdate();

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso");

					// apos adicionar limpar os campos
					txtCliNome.setText(null);
					txtCliEndereco.setText(null);
					txtCliFone.setText(null);
					txtCliEmail.setText(null);
					txtCliID.setText(null);

					btnCliCreate.setEnabled(true);
				}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {

			}
		}
	}

	// metodo para deletar um cliente
	private void remover() {
		// Estrutura de confirmacao para remover ou nao
		int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "DELETE FROM tbclientes where idcli=?";
			conexao = ModuloConexao.conector();
			try {
				pst = conexao.prepareStatement(sql);
				pst.setString(1, txtCliID.getText());
				int deletar = pst.executeUpdate();

				if (deletar > 0) {
					JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso");
					// apos deletar apagar os campos
					txtCliID.setText(null);
					txtCliNome.setText(null);
					txtCliEndereco.setText(null);
					txtCliFone.setText(null);
					txtCliEmail.setText(null);
					btnCliCreate.setEnabled(true);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			} finally {
				try {
					conexao.close();
				} catch (Exception e2) {
				}
			}
		}

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
			btnCliCreate.addActionListener(new ActionListener() {

				// chamando metodo adicionar cliente
				public void actionPerformed(ActionEvent arg0) {
					adicionar();
				}
			});
			btnCliCreate.setToolTipText("Adicionar");
			Image create = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/Add.png")).getImage();
			btnCliCreate.setIcon(new ImageIcon(create));
			btnCliCreate.setMinimumSize(new Dimension(50, 50));
			btnCliCreate.setMaximumSize(new Dimension(50, 50));
			btnCliCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnCliCreate;
	}

	private JButton getBtnCliUpdate() {
		if (btnCliUpdate == null) {
			btnCliUpdate = new JButton("");
			btnCliUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					alterar();
				}
			});
			btnCliUpdate.setToolTipText("Alterar");
			Image update = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/edit.png")).getImage();
			btnCliUpdate.setIcon(new ImageIcon(update));
			btnCliUpdate.setMinimumSize(new Dimension(50, 50));
			btnCliUpdate.setMaximumSize(new Dimension(50, 50));
			btnCliUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnCliUpdate;
	}

	private JButton getBtnCliDelete() {
		if (btnCliDelete == null) {
			btnCliDelete = new JButton("");
			btnCliDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					remover();
					
				}
			});
			btnCliDelete.setToolTipText("Remover");
			Image delete = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/delete.png")).getImage();
			btnCliDelete.setIcon(new ImageIcon(delete));
			btnCliDelete.setMinimumSize(new Dimension(50, 50));
			btnCliDelete.setMaximumSize(new Dimension(50, 50));
			btnCliDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btnCliDelete;
	}

	private JTextField getTxtCliPesquisar() {
		if (txtCliPesquisar == null) {
			txtCliPesquisar = new JTextField();
			txtCliPesquisar.addKeyListener(new KeyAdapter() {
				@Override
				// evento abaixo enquanto digita ele chama metodo em tempo real
				public void keyReleased(KeyEvent arg0) {
					pesquisarCliente();
				}
			});
			txtCliPesquisar.setColumns(10);
		}
		return txtCliPesquisar;
	}

	private JLabel getLabel_1() {
		if (label == null) {
			label = new JLabel("");
			Image search = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/search-icon.png"))
					.getImage();
			label.setIcon(new ImageIcon(search));
		}
		return label;
	}

	private JTable getTblClientes() {
		if (tblClientes == null) {
			tblClientes = new JTable();
			tblClientes.addMouseListener(new MouseAdapter() {
				// evento para setar campos da tabela
				@Override
				public void mouseClicked(MouseEvent arg0) {
					setarCampos();
				}
			});
			tblClientes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Endereço", "Fone", "Email"
				}
			));
		}
		return tblClientes;
	}

	private JLabel getLabel_1_1() {
		if (lblIdCliente == null) {
			lblIdCliente = new JLabel("ID Cliente");
		}
		return lblIdCliente;
	}

	private JTextField getTxtCliID() {
		if (txtCliID == null) {
			txtCliID = new JTextField();
			txtCliID.setEnabled(false);
			txtCliID.setEditable(false);
			txtCliID.setColumns(10);
		}
		return txtCliID;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTblClientes());
		}
		return scrollPane;
	}
}
