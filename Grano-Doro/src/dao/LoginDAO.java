package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dto.LoginDTO;

public class LoginDAO
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ResultSet usuarioAutenticacao(LoginDTO loginDTO)
	{
		con = new ConectaBD().ConexaoDAO();
		String sql = "SELECT Usuario, Senha FROM logindb WHERE Usuario = ? AND Senha = ?";
		try 
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, loginDTO.getUsuario());
			ps.setString(2, loginDTO.getSenha());
			rs = ps.executeQuery();
			return rs;
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe UsuarioDAO: " + erro.getMessage());
			return null;
		}
	}
	
}
