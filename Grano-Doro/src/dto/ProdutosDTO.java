package dto;

public class ProdutosDTO 
{
	private int ProdutoID;
	private String ProdutoNome;
	private float ProdutoValor;
	
	public int getProdutoID() {
		return ProdutoID;
	}
	public void setProdutoID(int produtoID) {
		ProdutoID = produtoID;
	}
	public String getProdutoNome() {
		return ProdutoNome;
	}
	public void setProdutoNome(String produtoNome) {
		ProdutoNome = produtoNome;
	}
	public float getProdutoValor() {
		return ProdutoValor;
	}
	public void setProdutoValor(float produtoValor) {
		ProdutoValor = produtoValor;
	}
	
}