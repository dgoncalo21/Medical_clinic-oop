package avaliacao;

import java.util.Scanner;

public class Interface
{
	public Interface(BaseDeDados dados)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Gestao de informacao da clinica medica \n");

		String username = "";
		String password = "";

		while (username.length() == 0)
		{
			System.out.println("Inserir username: \n");
			username = sc.nextLine();
		}

		while (password.length() == 0)
		{
			System.out.println("Inserir password: \n");
			password = sc.nextLine();
		}

		Login login = new Login(dados, username, password);

		sc.close();
	}
}