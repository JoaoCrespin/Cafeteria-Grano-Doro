package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dto.ProdutosDTO;

public class CadastroProdutosDAO {
    Connection con;
    PreparedStatement ps;

    public boolean cadastrarProduto(ProdutosDTO produtosDTO) {
        con = new ConectaBD().ConexaoDAO();
        String sql = "INSERT INTO produtosdb (ProdutoNome, ProdutoValor) VALUES (?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, produtosDTO.getProdutoNome());
            ps.setFloat(2, produtosDTO.getProdutoValor());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + erro.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return false;
    }
}
