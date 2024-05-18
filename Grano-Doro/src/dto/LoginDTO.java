package dto;

public class LoginDTO 
{
	private int UserID;
	private String Usuario, Senha;
	
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
	
	
}
