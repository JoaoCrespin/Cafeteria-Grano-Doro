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
			Path currentRelativePath = Paths.get("");
			String projectPath = currentRelativePath.toAbsolutePath().toString();
			String dbPath = Paths.get(projectPath, "src", "database", "cafeina.db").toString();
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
