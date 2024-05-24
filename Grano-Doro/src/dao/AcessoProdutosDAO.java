package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dto.ProdutosDTO;

public class AcessoProdutosDAO
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ResultSet usuarioAutenticacao(ProdutosDTO produtosDTO)
	{
		con = new ConectaBD().ConexaoDAO();
		String sql = "SELECT ProdutoNome, ProdutoValor FROM produtosdb WHERE ProdutoNome = ? AND ProdutoValor = ?";
		try 
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, produtosDTO.getProdutoNome());
			ps.setFloat(2, produtosDTO.getProdutoValor());
			rs = ps.executeQuery();
			return rs;
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe AcessoProdutosDAO: " + erro.getMessage());
			return null;
		}
	}
	
}
