package br.com.infox.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TelaCliente extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setBounds(100, 100, 695, 484);
	}

}
