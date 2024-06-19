package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<ProdutosDTO> listarProdutos() {
        List<ProdutosDTO> listaDeProdutos = new ArrayList<>();
        con = new ConectaBD().ConexaoDAO();
        String sql = "SELECT * FROM produtosdb";
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setProdutoNome(rs.getString("ProdutoNome"));
                produto.setProdutoValor(rs.getFloat("ProdutoValor"));
                listaDeProdutos.add(produto);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + erro.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return listaDeProdutos;
    }

    public boolean removerProduto(String nomeProduto) {
        con = new ConectaBD().ConexaoDAO();
        String sql = "DELETE FROM produtosdb WHERE ProdutoNome = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nomeProduto);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao remover produto: " + erro.getMessage());
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

    public boolean editarProduto(ProdutosDTO produtosDTO, String nomeProdutoAntigo) {
        con = new ConectaBD().ConexaoDAO();
        String sql = "UPDATE produtosdb SET ProdutoNome = ?, ProdutoValor = ? WHERE ProdutoNome = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, produtosDTO.getProdutoNome());
            ps.setFloat(2, produtosDTO.getProdutoValor());
            ps.setString(3, nomeProdutoAntigo);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto: " + erro.getMessage());
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
