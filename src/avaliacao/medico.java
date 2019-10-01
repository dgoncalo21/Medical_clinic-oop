package avaliacao;

import java.util.ArrayList;

public class medico extends funcionarios
{
	private String especializacao;
	private doente doente;
	private ArrayList<doente> listaDoentes = new ArrayList<doente>();

	public medico()
	{
		super();
		this.especializacao = "Nao definida";
	}

	public medico(String nome, String username, String password, String especializacao)
	{
		super(nome, username, password);
		this.especializacao = especializacao;
	}

	public void registarDoente(String nome, String numeroIdentificacao, ArrayList<String> listaPatologias, // done
			ArrayList<String> listaPrescricao)
	{
		this.doente = new doente(nome, numeroIdentificacao, listaPatologias, listaPrescricao);
		this.listaDoentes.add(this.doente);
	}

	public void registarPatologia(String numeroIdentificacao, String patologia) // done
	{
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		this.doente.adicionarPatologia(patologia);
		listaDoentes.set(j, this.doente);
	}

	public void registarPrescricao(String numeroIdentificacao, String prescricao) // done
	{
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}

		this.doente = this.listaDoentes.get(j);
		this.doente.adicionarPrescricao(prescricao);
		listaDoentes.set(j, this.doente);
	}

	public void corrigirDoenteNome(String numeroIdentificacao, String nomeNovo) // done
	{

		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}

		this.doente = this.listaDoentes.get(j);
		this.doente.setNome(nomeNovo);
		listaDoentes.set(j, this.doente);
	}

	public void corrigirDoenteNumero(String numeroIdentificacao, String numeroIdentificacaoNovo) // done
	{
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		this.doente.setNumeroIdentificacao(numeroIdentificacaoNovo);
		listaDoentes.set(j, this.doente);
	}

	public void corrigirDoentePrescricao(String numeroIdentificacao, String prescricao, String prescricaoNova) // done
	{
		int j = -1;
		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		this.doente.corrigirPrescricao(prescricao, prescricaoNova);
		listaDoentes.set(j, this.doente);
	}

	public void corrigirDoentePatologia(String numeroIdentificacao, String patologia, String patologiaNova) // done
	{
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		this.doente.corrigirPatologia(patologia, patologiaNova);
		listaDoentes.set(j, this.doente);
	}

	public void removerDoente(String numeroIdentificacao) // done
	{
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.listaDoentes.remove(j);
	}

	public void removerPatologia(String numeroIdentificacao, String patologia) // done
	{

		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		this.doente.removerPatologia(patologia);
		listaDoentes.set(j, this.doente);
	}

	public void removerPrescricao(String numeroIdentificacao, String prescricao) // done
	{
		int j = -1;
		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		this.doente.removerPrescricao(prescricao);
		listaDoentes.set(j, this.doente);
	}

	public ArrayList<String> listarDoentes() // done
	{
		ArrayList<String> nomesIDDoentes = new ArrayList<String>();
		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			nomesIDDoentes.add(this.listaDoentes.get(i).getNome());
			nomesIDDoentes.add(this.listaDoentes.get(i).getNumeroIdentificacao());
		}
		return nomesIDDoentes;
	}

	public ArrayList<ArrayList<String>> pesquisarDoente(String numeroIdentificacao) // done
	{
		ArrayList<ArrayList<String>> pesquisaDoente = new ArrayList<ArrayList<String>>();
		ArrayList<String> nomeDoente = new ArrayList<String>();
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		nomeDoente.add(this.doente.getNome());
		pesquisaDoente.add(nomeDoente);
		pesquisaDoente.add(this.doente.getListaPatologias());
		pesquisaDoente.add(this.doente.getListaPrescricao());

		return pesquisaDoente;
	}

	public ArrayList<String> listarPatologias(String numeroIdentificacao) // done
	{
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}
		this.doente = this.listaDoentes.get(j);
		return this.doente.getListaPatologias();
	}

	public ArrayList<String> listarPrescricao(String numeroIdentificacao) // done
	{
		ArrayList<String> listaPrescricao = new ArrayList<String>();
		int j = -1;

		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				j = i;
			}
		}

		listaPrescricao = this.listaDoentes.get(j).getListaPrescricao();

		return listaPrescricao;
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

	public String getEspecializacao()
	{
		return especializacao;
	}

	public void setEspecializacao(String especializacao)
	{
		this.especializacao = especializacao;
	}

	public ArrayList<doente> getListaDoentes()
	{
		return listaDoentes;
	}

	public void setListaDoentes(ArrayList<doente> listaDoentes)
	{
		this.listaDoentes = listaDoentes;
	}

	public boolean numeroIdentificacaoErro(String numeroIdentificacao) // done
	{
		boolean erro = false;
		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			if (this.listaDoentes.get(i).getNumeroIdentificacao().equals(numeroIdentificacao))
			{
				erro = true;
			}
		}
		return erro;
	}

	public boolean patologiaErro(String patologia) // done
	{
		boolean erro = false;
		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			for (int j = 0; j < this.listaDoentes.get(i).getListaPatologias().size(); j++)
			{
				if (this.listaDoentes.get(i).getListaPatologias().get(j).equals(patologia))
				{
					erro = true;
				}
			}
		}
		return erro;

	}

	public boolean prescricaoErro(String prescricao) // done
	{
		boolean erro = false;
		for (int i = 0; i < this.listaDoentes.size(); i++)
		{
			for (int j = 0; j < this.listaDoentes.get(i).getListaPrescricao().size(); j++)
			{
				if (this.listaDoentes.get(i).getListaPrescricao().get(j).equals(prescricao))
				{
					erro = true;
				}
			}
		}
		return erro;

	}

	public void atualizarDados(BaseDeDados dados, medico med) // done
	{
		ArrayList<medico> atualizar = new ArrayList<medico>();
		atualizar = dados.getListaMedicos();
		for (int i = 0; i < dados.getListaMedicos().size(); i++)
		{
			if (dados.getListaMedicos().get(i).getUsername().equals(med.getUsername()) == true)
			{
				atualizar.set(i, med);
				break;
			}
		}
		dados.setListaMedicos(atualizar);
	}

	public boolean medicamentoErro(BaseDeDados dados, String prescricao) // done
	{
		boolean erro = false;
		for (int i = 0; i < dados.getListaMedicamentos().size(); i++)
		{
			if (dados.getListaMedicamentos().get(i).getNome().equals(prescricao))
			{
				erro = true;
				break;
			}
		}
		return erro;
	}
}
