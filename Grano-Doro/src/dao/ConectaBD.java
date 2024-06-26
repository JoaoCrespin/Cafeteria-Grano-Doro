package dao;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ConectaBD {


    private static Connection con;

   
    public static Connection ConexaoDAO() {
        try {
            if (con == null || con.isClosed()) {
                con = conectar();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar conexão: " + e.getMessage());
        }
        return con;
    }


    private static Connection conectar() {
        try {
            Path currentRelativePath = Paths.get("");
            String projectPath = currentRelativePath.toAbsolutePath().toString();
            String dbPath = Paths.get(projectPath, "src", "database", "cafeina.db").toString();
            String url = "jdbc:sqlite:" + dbPath;
            con = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + erro.getMessage());
        }
        return con;
    }


    public static void fecharConexao() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        } finally {
            con = null; 
        }
    }
}
