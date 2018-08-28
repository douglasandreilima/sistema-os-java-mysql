package br.com.infox.dal;

import java.sql.*;

public class ModuloConexao {
	// M�todos responsavel por estabelecer conex�o com o banco de dados mysql

	public static Connection conector() {
		java.sql.Connection conexao = null;
		// a linha abaixo "chama" o driver
		String driver = "com.mysql.jdbc.Driver";
		// Armazenando informa��es referente ao banco de dados
		String url = "jdbc:mysql://127.0.0.1:3306/dbinfox";
		String user = "root";
		String password = "";
		
		// estabelecendo a conexao com o banco
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			// a linha abaixo serve de apoio para esclarecer o erro
			
			//System.out.println(e);
			
			return null;
		}

	}
}
