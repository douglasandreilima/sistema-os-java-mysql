package br.com.infox.telas;

import java.awt.EventQueue;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;

public class TelaUsuario extends JInternalFrame {
	/**
	 * 
	 */

	// Variavel de conexao do DAL
	Connection conexao = null;
	// variaveis especiais para conexao ao banco
	// Prepared Statement e ResultSet são frameworks do pacote java.sql
	// e servem para preparar e executar as instruções SQL
	PreparedStatement pst = null;
	ResultSet rs = null;

	private static final long serialVersionUID = 1L;
	private JLabel lblID;
	private JLabel lblNome;
	private JLabel lblFone;
	private JLabel lblSenha;
	private JLabel lblPerfil;
	private JTextField txtUsuId;
	private JTextField txtUsuNome;
	private JTextField txtUsuFone;
	private JPasswordField txtUsuSenha;
	private JComboBox cboUsuPerfil;
	private JTextField txtUsulogin;
	private JLabel lblLogin;
	private JButton btnUsuCreate;
	private JButton btnUsuRead;
	private JButton btnUsuUpdate;
	private JButton btnUsuDelete;
	private JLabel lblCamposObrigtorios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	public TelaUsuario() {

		initialize();
		conexao = ModuloConexao.conector();

	}

	// metodo para consultar usuarios no Banco de Dados
	private void consultar() {
		String sql = "select * from tbusuarios where iduser=?";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtUsuId.getText()); // pega a ID para pesquisar no Banco
			rs = pst.executeQuery();

			if (rs.next()) {
				txtUsuNome.setText(rs.getString(2)); // pega registro 2 ou 2 campo da tabela e escreve no campo Nome;
				txtUsuFone.setText(rs.getString(3));
				txtUsulogin.setText(rs.getString(4));
				txtUsuSenha.setText(rs.getString(5));
				// linha abaixo seleciona opcao do comboBox conforme escrito no Banco
				cboUsuPerfil.setSelectedItem(rs.getString(6));

			} else {
				JOptionPane.showMessageDialog(null, "ID não encontrado");
				txtUsuNome.setText(null);
				txtUsuFone.setText(null);
				txtUsulogin.setText(null);
				txtUsuSenha.setText(null);
				// linha abaixo seleciona opcao do comboBox conforme escrito no Banco
				cboUsuPerfil.setSelectedItem(null);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Método para adicionar usuários ao banco
	private void adicionar() {
		String sql = "INSERT INTO tbusuarios(iduser,usuario,fone,login,senha,perfil) VALUES(?,?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, txtUsuId.getText());
			pst.setString(2, txtUsuNome.getText());
			pst.setString(3, txtUsuFone.getText());
			pst.setString(4, txtUsulogin.getText());
			String senha = "";
			senha = new String(txtUsuSenha.getPassword());
			pst.setString(5, senha);
			pst.setString(6, cboUsuPerfil.getSelectedItem().toString());

			// validacao campos obrigátorios
			if ((txtUsuId.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsulogin.getText().isEmpty()) || (senha.isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigátorios");
			} else {

				// linha abaixo atualiza a tabela usuários com os dados do formulário
				// estrutura abaixo é usada para confirmar a inserção dos dados ao usuário
				int adicionado = pst.executeUpdate();

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

					// após adicionar limpar os campos
					txtUsuNome.setText(null);
					txtUsuFone.setText(null);
					txtUsulogin.setText(null);
					txtUsuSenha.setText(null);
					// linha abaixo seleciona opcao do comboBox conforme escrito no Banco
					cboUsuPerfil.setSelectedItem(null);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void initialize() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setIconifiable(true);
		setClosable(true);
		setTitle("Usu\u00E1rios");
		setBounds(100, 100, 680, 444);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(45)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(getBtnUsuCreate()).addGap(30)
										.addComponent(getBtnUsuRead()).addGap(18).addComponent(getBtnUsuUpdate()))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(getLblID()).addGap(34)
										.addComponent(getTxtUsuId(), GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
										.addComponent(getLblCamposObrigtorios()))
								.addGroup(groupLayout
										.createSequentialGroup()
										.addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(getLblSenha(), GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(getLblLogin(), Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addComponent(getLblNome()).addComponent(getLblFone()))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(getTxtUsuSenha(), GroupLayout.DEFAULT_SIZE, 293,
														Short.MAX_VALUE)
												.addComponent(getTxtUsuNome(), Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
												.addComponent(getTxtUsuFone(), Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
												.addComponent(getTxtUsulogin(), GroupLayout.PREFERRED_SIZE, 293,
														GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(53).addComponent(getLblPerfil())
										.addGap(18).addComponent(getCboUsuPerfil(), GroupLayout.PREFERRED_SIZE, 108,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(
										groupLayout.createSequentialGroup().addGap(29).addComponent(getBtnUsuDelete())))
						.addGap(60)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(getLblID())
								.addComponent(getTxtUsuId(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblCamposObrigtorios()))
						.addGap(39)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTxtUsuNome(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblNome()))
						.addGap(34)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTxtUsuFone(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblFone()))
						.addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTxtUsulogin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblLogin()))
						.addGap(28)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(getLblSenha())
								.addComponent(getTxtUsuSenha(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblPerfil()).addComponent(getCboUsuPerfil(),
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(getBtnUsuUpdate())
								.addComponent(getBtnUsuCreate()).addComponent(getBtnUsuRead())
								.addComponent(getBtnUsuDelete()))
						.addGap(36)));
		getContentPane().setLayout(groupLayout);
	}

	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("*ID");
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblID;
	}

	private JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("*Nome");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNome;
	}

	private JLabel getLblFone() {
		if (lblFone == null) {
			lblFone = new JLabel("Fone");
			lblFone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblFone;
	}

	private JLabel getLblSenha() {
		if (lblSenha == null) {
			lblSenha = new JLabel("*Senha");
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblSenha;
	}

	private JLabel getLblPerfil() {
		if (lblPerfil == null) {
			lblPerfil = new JLabel("*Perfil");
			lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPerfil;
	}

	private JTextField getTxtUsuId() {
		if (txtUsuId == null) {
			txtUsuId = new JTextField();
			txtUsuId.setColumns(10);
		}
		return txtUsuId;
	}

	private JTextField getTxtUsuNome() {
		if (txtUsuNome == null) {
			txtUsuNome = new JTextField();
			txtUsuNome.setColumns(10);
		}
		return txtUsuNome;
	}

	private JTextField getTxtUsuFone() {
		if (txtUsuFone == null) {
			txtUsuFone = new JTextField();
			txtUsuFone.setColumns(10);
		}
		return txtUsuFone;
	}

	private JPasswordField getTxtUsuSenha() {
		if (txtUsuSenha == null) {
			txtUsuSenha = new JPasswordField();
		}
		return txtUsuSenha;
	}

	private JComboBox getCboUsuPerfil() {
		if (cboUsuPerfil == null) {
			cboUsuPerfil = new JComboBox();
			cboUsuPerfil.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cboUsuPerfil.setModel(new DefaultComboBoxModel(new String[] { "admin", "user" }));
			cboUsuPerfil.setSelectedIndex(1);
			cboUsuPerfil.setToolTipText("");
		}
		return cboUsuPerfil;
	}

	private JTextField getTxtUsulogin() {
		if (txtUsulogin == null) {
			txtUsulogin = new JTextField();
			txtUsulogin.setColumns(10);
		}
		return txtUsulogin;
	}

	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("*Login");
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblLogin;
	}

	private JButton getBtnUsuCreate() {
		if (btnUsuCreate == null) {
			btnUsuCreate = new JButton("");
			btnUsuCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnUsuCreate.setToolTipText("Adicionar");
			Image create = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/Add.png")).getImage();
			btnUsuCreate.setIcon(new ImageIcon(create));
			btnUsuCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					adicionar();
				}
			});
			btnUsuCreate.setMinimumSize(new Dimension(50, 50));
			btnUsuCreate.setMaximumSize(new Dimension(50, 50));
		}
		return btnUsuCreate;
	}

	private JButton getBtnUsuRead() {
		if (btnUsuRead == null) {
			btnUsuRead = new JButton("");
			btnUsuRead.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// chamando o metodo consultar para trazer os dados do usuario do Banco para a
					// tela
					consultar();

				}
			});
			btnUsuRead.setToolTipText("Consultar");
			Image read = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/Find.png")).getImage();
			btnUsuRead.setIcon(new ImageIcon(read));
			btnUsuRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnUsuRead.setMinimumSize(new Dimension(50, 50));
			btnUsuRead.setMaximumSize(new Dimension(50, 50));
		}
		return btnUsuRead;
	}

	private JButton getBtnUsuUpdate() {
		if (btnUsuUpdate == null) {
			btnUsuUpdate = new JButton("");
			btnUsuUpdate.setToolTipText("Alterar");
			Image update = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/edit.png")).getImage();
			btnUsuUpdate.setIcon(new ImageIcon(update));
			btnUsuUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnUsuUpdate.setMinimumSize(new Dimension(50, 50));
			btnUsuUpdate.setMaximumSize(new Dimension(50, 50));
		}
		return btnUsuUpdate;
	}

	private JButton getBtnUsuDelete() {
		if (btnUsuDelete == null) {
			btnUsuDelete = new JButton("");
			btnUsuDelete.setToolTipText("Remover");
			Image delete = new ImageIcon(this.getClass().getResource("/br/com/infox/icones/delete.png")).getImage();
			btnUsuDelete.setIcon(new ImageIcon(delete));
			btnUsuDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnUsuDelete.setMinimumSize(new Dimension(50, 50));
			btnUsuDelete.setMaximumSize(new Dimension(50, 50));
		}
		return btnUsuDelete;
	}

	private JLabel getLblCamposObrigtorios() {
		if (lblCamposObrigtorios == null) {
			lblCamposObrigtorios = new JLabel("* Campos obrig\u00E1torios");
			lblCamposObrigtorios.setForeground(Color.RED);
			lblCamposObrigtorios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblCamposObrigtorios;
	}
}
