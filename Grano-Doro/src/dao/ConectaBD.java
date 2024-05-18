package dao;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD 
{
	
	private Connection con = null;
	
	public Connection ConexaoDAO()
	{
		try
		{
			String url = "jdbc:sqlite:C:\\Users\\Ravi\\Desktop\\ProjetoCafe\\DB\\cafeina";
			con = DriverManager.getConnection(url);
		}
		
		catch(SQLException erro) 
		{
			JOptionPane.showMessageDialog(null, "Erro de conexao" + erro.getMessage());
		}
	
		return con;
	}
}
