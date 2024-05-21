package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dto.LoginDTO;

public class CadastroDAO
{
    Connection con;
    PreparedStatement ps;
    
    public boolean cadastrarUsuario(LoginDTO loginDTO)
    {
        con = new ConectaBD().ConexaoDAO();
        String sql = "INSERT INTO logindb (Usuario, Senha, Contato) VALUES (?, ?, ?)";
        try 
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, loginDTO.getUsuario());
            ps.setString(2, loginDTO.getSenha());
            ps.setString(3, loginDTO.getContato());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null, "Erro na classe CadastroDAO: " + erro.getMessage());
        }
        return false;
    }
}
