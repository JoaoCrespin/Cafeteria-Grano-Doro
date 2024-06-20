package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dto.ProdutosDTO;

public class AcessoProdutosDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public AcessoProdutosDAO() {
        con = new ConectaBD().ConexaoDAO();
    }

    public List<ProdutosDTO> buscarProdutos() {
        List<ProdutosDTO> produtos = new ArrayList<>();
        String sql = "SELECT ProdutoNome, ProdutoValor FROM produtosdb";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setProdutoNome(rs.getString("ProdutoNome"));
                produto.setProdutoValor(rs.getFloat("ProdutoValor"));
                produtos.add(produto);
            }

            return produtos;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na classe AcessoProdutosDAO - buscarProdutos: " + erro.getMessage());
            return null;
        } finally {
            fecharConexao();
        }
    }

    private void fecharConexao() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados: " + e.getMessage());
        }
    }
}
