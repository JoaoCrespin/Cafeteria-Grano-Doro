package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dto.LoginDTO;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ResultSet usuarioAutenticacao(LoginDTO loginDTO) {
        con = new ConectaBD().ConexaoDAO();
        String sql = "SELECT Usuario, Senha, Contato, Salario FROM logindb WHERE Usuario = ? AND Senha = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, loginDTO.getUsuario());
            ps.setString(2, loginDTO.getSenha());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na classe LoginDAO: " + erro.getMessage());
            return null;
        }
    }
    public void updateLogin(LoginDTO loginDTO) {
        con = new ConectaBD().ConexaoDAO();
        String sql = "UPDATE logindb SET Usuario = ?, Senha = ?, Contato = ?, Salario = ? WHERE UserID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, loginDTO.getUsuario());
            ps.setString(2, loginDTO.getSenha());
            ps.setString(3, loginDTO.getContato());
            ps.setDouble(4, loginDTO.getSalario());
            ps.setInt(5, loginDTO.getUserID());
            ps.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na classe LoginDAO ao atualizar: " + erro.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }


    public List<LoginDTO> getAllLogins() {
        List<LoginDTO> logins = new ArrayList<>();
        con = new ConectaBD().ConexaoDAO();
        String sql = "SELECT UserID, Usuario, Senha, Contato, Salario FROM logindb";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("UserID");
                String usuario = rs.getString("Usuario");
                String senha = rs.getString("Senha");
                String contato = rs.getString("Contato");
                double salario = rs.getDouble("Salario");
                LoginDTO login = new LoginDTO();
                login.setUserID(userID);
                login.setUsuario(usuario);
                login.setSenha(senha);
                login.setContato(contato);
                login.setSalario(salario);
                logins.add(login);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na classe UsuarioDAO: " + erro.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return logins;
    }

    public void removeLogin(int userID) {
        con = new ConectaBD().ConexaoDAO();
        String sql = "DELETE FROM logindb WHERE UserID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.executeUpdate();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na classe LoginDAO: " + erro.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}
