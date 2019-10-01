package avaliacao;

public class Login
{
	public Login(BaseDeDados dados, String username, String password)
	{
		administrador administrador = new administrador();

		if (administrador.getUsername().equals(username) && administrador.getPassword().equals(password))
		{
			menuAdmin menuAdmin = new menuAdmin(dados);
		}
		else
		{
			boolean medicoValido = false;
			int indice = 0;
			for (int i = 0; i < dados.getListaMedicos().size(); i++)
			{
				if (dados.getListaMedicos().get(i).getUsername().equals(username)
						&& dados.getListaMedicos().get(i).getPassword().equals(password))
				{
					medicoValido = true;
					indice = i;
					break;
				}
			}
			if (medicoValido == true)
			{
				menuMed menuMed = new menuMed(dados, dados.getListaMedicos().get(indice));
			}
			else
			{
				System.out.println("Credenciais invalidas");
				Interface interfac = new Interface(dados);
			}
		}
	}
}
