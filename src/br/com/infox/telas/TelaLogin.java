package br.com.infox.telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import br.com.infox.dal.ModuloConexao;

public class TelaLogin extends JFrame {
	//Variavel de conexao do DAL
	Connection conexao = null;
	//variaveis especiais para conexao ao banco
	//Prepared Statement e ResultSet são frameworks do pacote java.sql
	// e servem para preparar e executar as instruções SQL
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsurio;
	private JLabel lblSenha;
	private JTextField txtUsuario;
	private JButton btnLogin;
	private JPasswordField txtSenha;
	private JLabel lblStatus;

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
					TelaLogin frame = new TelaLogin();
					frame.setLocationRelativeTo(null); // para que o frame execute no inicio da tela
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setForeground(Color.GRAY);

		setResizable(false);
		setPreferredSize(new Dimension(355, 165));
		setLocationRelativeTo(null);
		setTitle("X System - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.setForeground(SystemColor.menu);
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(24)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(getLblSenha(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(getLblUsurio(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 52,
										Short.MAX_VALUE))
						.addComponent(getLblStatus()))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(getTxtUsuario(), GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTxtSenha(), GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(getBtnLogin(), GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(67, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(23)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(getLblUsurio())
								.addComponent(getTxtUsuario(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(getLblSenha())
								.addComponent(getTxtSenha(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(getLblStatus(),
										GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(getBtnLogin()))
						.addGap(9)));
		contentPane.setLayout(gl_contentPane);

		conexao = ModuloConexao.conector();
		// a linha abaixo serve de apoio ao status da conexao com o banco
		//System.out.println(conexao);
		if (conexao != null) {
			lblStatus.setForeground(Color.yellow);
			lblStatus.setText("Conectado");

		} else {
			lblStatus.setForeground(Color.RED);
			lblStatus.setText("Não Conectado");
		}

	}

	private JLabel getLblUsurio() {
		if (lblUsurio == null) {
			lblUsurio = new JLabel("Usu\u00E1rio");
			lblUsurio.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblUsurio;
	}

	private JLabel getLblSenha() {
		if (lblSenha == null) {
			lblSenha = new JLabel("Senha");
			lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblSenha;
	}

	private JTextField getTxtUsuario() {
		if (txtUsuario == null) {
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Dialog", Font.PLAIN, 13));
			txtUsuario.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			txtUsuario.setAlignmentX(Component.RIGHT_ALIGNMENT);
			txtUsuario.setColumns(10);
		}
		return txtUsuario;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logar();
				}
			});
			btnLogin.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return btnLogin;
	}

	private JPasswordField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JPasswordField();
			txtSenha.setFont(new Font("Dialog", Font.PLAIN, 13));
		}
		return txtSenha;
	}

	private JLabel getLblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel("Status");
			lblStatus.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblStatus;
	}

	public void logar() {
		String sql = "select * from tbusuarios where login=? and senha =?";
		try {
			// as linhas abaixo preparam a consulta ao banco em função do que foi digitado
			// nas caixas de testo. o ? é substituido pelo conteudo das variaveis
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtUsuario.getText());
			String senha = new String(txtSenha.getPassword());
			pst.setString(2, senha);
			// linha abaixo executa a query
			rs = pst.executeQuery();
			// se existir usuario correspondendo no banco, loga e abre pagina principal
			if (rs.next()) {
				// linha abaixo recebe o conteudo do campo perfil da tabela tbusuarios; cada
				// campo tem um numero, sendo o de perfil o sexto campo(6)
				String perfil = rs.getString(6);

				TelaPrincipal principal = new TelaPrincipal();

				principal.setVisible(true);
				principal.setExtendedState(MAXIMIZED_BOTH);
				this.dispose();
				
				// se usuario for admin - libera acesso aos campos Relatorios e cadastro de
				// usuarios
				if (perfil.equals("admin")) {
					TelaPrincipal.menRel.setEnabled(true);
					TelaPrincipal.menCadUsu.setEnabled(true);
					TelaPrincipal.lblUsuario.setForeground(Color.RED);
				}
				
				//Verifica qual usuario está logado e altera lblUsuario da tela principal para o nome logado				
				TelaPrincipal.lblUsuario.setText(rs.getString(2));
				
				//fecha conexao com o banco
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
