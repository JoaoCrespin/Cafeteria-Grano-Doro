package dto;

import java.util.ArrayList;
import java.util.List;

public class MesaDTO {
    private boolean emUso;
    private List<ProdutosDTO> produtos;

    public MesaDTO() {
        this.emUso = false;
        this.produtos = new ArrayList<>();
    }

    public boolean isEmUso() {
        return emUso;
    }

    public void setEmUso(boolean emUso) {
        this.emUso = emUso;
    }

    public List<ProdutosDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutosDTO> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(ProdutosDTO produto) {
        this.produtos.add(produto);
    }

    public void limparProdutos() {
        this.produtos.clear();
    }
}
