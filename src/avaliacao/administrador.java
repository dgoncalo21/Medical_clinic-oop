package avaliacao;

import java.util.ArrayList;

public class administrador extends funcionarios
{
	private medico medico;
	private medicamento medicamento;

	public administrador()
	{
		super("Joao", "admin_user", "admin_pass");
	}

	public void registarMedico(BaseDeDados dados, String nome, String username, String password, String especializacao) // done
	{
		this.medico = new medico(nome, username, password, especializacao);
		dados.adicionarMedico(this.medico);
	}

	public void registarMedicamento(BaseDeDados dados, String nome, double preco) // done
	{
		this.medicamento = new medicamento(nome, preco);
		dados.adicionarMedicamento(nome, preco);
	}

	public void corrigirMedicoNome(BaseDeDados dados, String username, String nomeNovo) // done
	{
		int j = -1;

		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getUsername().equals(username))
			{
				j = i;
			}
		}

		this.medico = dados.getListaMedicos().get(j);
		this.medico.setNome(nomeNovo);
		ArrayList<medico> lista = new ArrayList<medico>();
		lista = dados.getListaMedicos();
		lista.set(j, this.medico);
		dados.setListaMedicos(lista);
	}

	public void corrigirMedicoUsername(BaseDeDados dados, String username, String usernameNovo) // done
	{
		int k = -1;

		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getUsername().equals(username))
			{
				k = i;
			}
		}
		this.medico = dados.getListaMedicos().get(k);
		this.medico.setUsername(usernameNovo);
		ArrayList<medico> lista = new ArrayList<medico>();
		lista = dados.getListaMedicos();
		lista.set(k, this.medico);
		dados.setListaMedicos(lista);
	}

	public void corrigirMedicoPassword(BaseDeDados dados, String username, String password) // done
	{
		int k = -1;

		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getUsername().equals(username))
			{
				k = i;
			}
		}
		this.medico = dados.getListaMedicos().get(k);
		this.medico.setPassword(password);
		ArrayList<medico> lista = new ArrayList<medico>();
		lista = dados.getListaMedicos();
		lista.set(k, this.medico);
		dados.setListaMedicos(lista);
	}

	public void corrigirMedicoEspecializacao(BaseDeDados dados, String username, String especializacao) // done
	{
		int k = -1;

		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getUsername().equals(username))
			{
				k = i;
			}
		}
		this.medico = dados.getListaMedicos().get(k);
		this.medico.setEspecializacao(especializacao);
		ArrayList<medico> lista = new ArrayList<medico>();
		lista = dados.getListaMedicos();
		lista.set(k, this.medico);
		dados.setListaMedicos(lista);
	}

	public void corrigirMedicamentoNome(BaseDeDados dados, String nome, String nomeNovo) // done
	{
		int k = -1;

		for (int i = 0; i < dados.getListaMedicamentos().size(); i++)
		{
			if (dados.getListaMedicamentos().get(i).getNome().equals(nome))
			{
				k = i;
			}
		}
		this.medicamento = dados.getListaMedicamentos().get(k);
		this.medicamento.setNome(nomeNovo);
		ArrayList<medicamento> lista = new ArrayList<medicamento>();
		lista = dados.getListaMedicamentos();
		lista.set(k, this.medicamento);
		dados.setListaMedicamentos(lista);
	}

	public void corrigirMedicamentoPreco(BaseDeDados dados, String nome, double preco) // done
	{
		int k = -1;

		for (int i = 0; i < dados.getListaMedicamentos().size(); i++)
		{
			if (dados.getListaMedicamentos().get(i).getNome().equals(nome))
			{
				k = i;
			}
		}
		this.medicamento = dados.getListaMedicamentos().get(k);
		this.medicamento.setPreco(preco);
		ArrayList<medicamento> lista = new ArrayList<medicamento>();
		lista = dados.getListaMedicamentos();
		lista.set(k, this.medicamento);
		dados.setListaMedicamentos(lista);

	}

	public void removerMedico(BaseDeDados dados, String username) // done

	{
		int j = -1;

		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getUsername().equals(username))
			{
				j = i;
			}
		}
		ArrayList<medico> lista = new ArrayList<medico>();
		lista = dados.getListaMedicos();
		lista.remove(j);
		dados.setListaMedicos(lista);
	}

	public void removerMedicamento(BaseDeDados dados, String nome) // done
	{
		int j = -1;

		for (int i = 0; i < dados.getListaMedicamentos().size(); i++)
		{
			if (dados.getListaMedicamentos().get(i).getNome().equals(nome))
			{
				j = i;
			}
		}
		ArrayList<medicamento> lista = new ArrayList<medicamento>();
		lista = dados.getListaMedicamentos();
		lista.remove(j);
		dados.setListaMedicamentos(lista);
	}

	public ArrayList<String> listarMedicos(BaseDeDados dados) // done
	{
		ArrayList<String> nomesUserMedicos = new ArrayList<String>();
		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			nomesUserMedicos.add(dados.getListaMedicos().get(i).getNome());
			nomesUserMedicos.add(dados.getListaMedicos().get(i).getUsername());
		}
		return nomesUserMedicos;
	}

	public ArrayList<String> listarMedicosEsp(BaseDeDados dados, String especializacao) // done
	{
		ArrayList<String> nomesUserMedicos = new ArrayList<String>();
		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getEspecializacao().equals(especializacao))
			{
				nomesUserMedicos.add(dados.getListaMedicos().get(i).getNome());
				nomesUserMedicos.add(dados.getListaMedicos().get(i).getUsername());
			}
		}
		return nomesUserMedicos;
	}

	public ArrayList<String> listarMedicamentos(BaseDeDados dados) // done
	{
		ArrayList<String> medicamentos = new ArrayList<String>();
		for (int i = 0; i < dados.getListaMedicamentos().size(); i++)
		{
			medicamentos.add(dados.getListaMedicamentos().get(i).getNome());
			medicamentos.add(Double.toString(dados.getListaMedicamentos().get(i).getPreco()));
		}
		return medicamentos;
	}

	public ArrayList<String> listarDoentes(BaseDeDados dados) // done
	{
		ArrayList<String> nomesDoentes = new ArrayList<String>();
		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			for (int j = 0; j < dados.getListaMedicos().get(i).getListaDoentes().size(); j++)
			{
				nomesDoentes.add(dados.getListaMedicos().get(i).getListaDoentes().get(j).getNome());
				nomesDoentes.add(dados.getListaMedicos().get(i).getListaDoentes().get(j).getNumeroIdentificacao());
			}
		}
		return nomesDoentes;
	}

	public ArrayList<String> doentePorMedico(BaseDeDados dados) // done
	{
		ArrayList<String> doentePorMedico = new ArrayList<String>();
		ArrayList<String> especialidades = new ArrayList<String>();
		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (especialidades.contains(dados.getListaMedicos().get(i).getEspecializacao()))
			{
				;
			}
			else
			{
				especialidades.add(dados.getListaMedicos().get(i).getEspecializacao());
			}
		}
		for (int i = 0; i < especialidades.size(); i++)
		{
			double numeroDoentes = 0;
			double numeroMedicos = 0;
			double media = 0;
			for (int j = 0; j < dados.getListaMedicos().size(); j++)
			{
				if (especialidades.get(i).equals(dados.getListaMedicos().get(j).getEspecializacao()))
				{
					numeroDoentes = numeroDoentes + dados.getListaMedicos().get(j).getListaDoentes().size();
					numeroMedicos = numeroMedicos + 1;
				}
			}
			media = numeroDoentes / numeroMedicos;
			doentePorMedico.add(especialidades.get(i));
			doentePorMedico.add(Double.toString(media));
		}
		return doentePorMedico;
	}

	public Double medicacaoPorPaciente(BaseDeDados dados) // done
	{
		double preco = 0;
		double doentes = 0;

		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			doentes = doentes + dados.getListaMedicos().get(i).getListaDoentes().size();
			for (int j = 0; j < dados.getListaMedicos().get(i).getListaDoentes().size(); j++)
			{
				for (int k = 0; k < dados.getListaMedicos().get(i).getListaDoentes().get(j).getListaPrescricao()
						.size(); k++)
				{
					for (int l = 0; l < dados.getListaMedicamentos().size(); l++)
					{
						if (dados.getListaMedicos().get(i).getListaDoentes().get(j).getListaPrescricao().get(k)
								.equals(dados.getListaMedicamentos().get(l).getNome()))
						{
							preco = preco + dados.getListaMedicamentos().get(l).getPreco();
						}
					}
				}
			}
		}
		return preco / doentes;
	}

	public boolean usernameErro(BaseDeDados dados, String usernameMedico) // done
	{
		boolean erro = false;
		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getUsername().equals(usernameMedico))
			{
				erro = true;
			}
		}
		return erro;
	}

	public boolean medicamentoErro(BaseDeDados dados, String nomeMedicamento) // done
	{
		boolean erro = false;
		for (int i = 0; i < dados.getListaMedicamentos().size(); i++)
		{
			if (dados.getListaMedicamentos().get(i).getNome().equals(nomeMedicamento))
			{
				erro = true;
			}
		}
		return erro;
	}

	public boolean medicamentoPrescricaoErro(BaseDeDados dados, String nomeMedicamento) // done
	{
		boolean erro = false;
		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			for (int j = 0; j < dados.getListaMedicos().get(i).getListaDoentes().size(); j++)
			{
				for (int k = 0; k < dados.getListaMedicos().get(i).getListaDoentes().get(j).getListaPrescricao()
						.size(); k++)
				{
					if (dados.getListaMedicos().get(i).getListaDoentes().get(j).getListaPrescricao().get(k)
							.equals(nomeMedicamento))
					{
						erro = true;
						break;
					}
				}
			}
		}
		return erro;
	}
}