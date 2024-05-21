package dto;

public class LoginDTO 
{
	private int UserID;
	private String Usuario, Senha, Contato;
	
	public int getUserID() 
	{
		return UserID;
	}
	
	public void setUserID(int userID) 
	{
		UserID = userID;
	}
	
	public String getUsuario() 
	{
		return Usuario;
	}
	public String getContato() 
	{
		return Contato;
	}
	
	public void setUsuario(String usuario) 
	{
		Usuario = usuario;
	}
	
	public String getSenha() 
	{
		return Senha;
	}
	public void setSenha(String senha) 
	{
		Senha = senha;
	}
	public void setContato(String contato) 
	{
		Contato = contato;
	}
	
}
