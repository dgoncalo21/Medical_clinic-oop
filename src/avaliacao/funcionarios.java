package avaliacao;

public class funcionarios extends nome
{
	private String username;
	private String password;

	public funcionarios()
	{
		super();
		this.username = "Password nao definida ";
		this.password = "Username nao definida ";
	}

	public funcionarios(String nome, String username, String password)
	{
		super(nome);
		this.username = username;
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
