package dao;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ConectaBD 
{
	private Connection con = null;
	
	public Connection ConexaoDAO()
	{
		try
		{
			// Obter o caminho absoluto do diretório do projeto
			Path currentRelativePath = Paths.get("");
			String projectPath = currentRelativePath.toAbsolutePath().toString();
			
			// Construir o caminho relativo para o banco de dados
			String dbPath = Paths.get(projectPath, "src", "database", "cafeina.db").toString();
			
			// URL de conexão para SQLite
			String url = "jdbc:sqlite:" + dbPath;
			con = DriverManager.getConnection(url);
		}
		catch(SQLException erro) 
		{
			JOptionPane.showMessageDialog(null, "Erro de conexao: " + erro.getMessage());
		}
	
		return con;
	}
}
