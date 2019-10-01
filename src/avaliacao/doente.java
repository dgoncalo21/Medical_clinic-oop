package avaliacao;

import java.util.ArrayList;

public class doente extends nome
{
	private ArrayList<String> listaPatologias = new ArrayList<String>();
	private ArrayList<String> listaPrescricao = new ArrayList<String>();
	private String numeroIdentificacao;

	public doente()
	{
		super();
		ArrayList<String> lista = new ArrayList<String>();
		this.numeroIdentificacao = "0";
		this.listaPatologias = lista;
		this.listaPrescricao = lista;
	}

	public doente(String nome, String numeroIdentificacao, ArrayList<String> listaPatologias,
			ArrayList<String> listaPrescricao)
	{
		super(nome);
		this.numeroIdentificacao = numeroIdentificacao;
		this.listaPatologias = listaPatologias;
		this.listaPrescricao = listaPrescricao;
	}

	public void adicionarPatologia(String patologia)
	{
		this.listaPatologias.add(patologia);
	}

	public void adicionarPrescricao(String prescricao)
	{
		this.listaPrescricao.add(prescricao);
	}

	public void corrigirPrescricao(String prescricao, String prescricaoNova)
	{
		int j = -1;

		for (int i = 0; i < this.listaPrescricao.size(); i++)
		{
			if (this.listaPrescricao.get(i).equals(prescricao))
			{
				j = i;
			}
		}
		this.listaPrescricao.set(j, prescricaoNova);
	}

	public void corrigirPatologia(String patologia, String patologiaNova)
	{
		int j = -1;

		for (int i = 0; i < this.listaPatologias.size(); i++)
		{
			if (this.listaPatologias.get(i).equals(patologia))
			{
				j = i;
			}
		}

		this.listaPatologias.set(j, patologiaNova);
	}

	public void removerPatologia(String patologia)

	{
		int j = -1;

		for (int i = 0; i < this.listaPatologias.size(); i++)
		{
			if (this.listaPatologias.get(i).equals(patologia))
			{
				j = i;
			}
		}
		this.listaPatologias.remove(j);
	}

	public void removerPrescricao(String prescricao)
	{
		int j = -1;

		for (int i = 0; i < this.listaPrescricao.size(); i++)
		{
			if (this.listaPrescricao.get(i).equals(prescricao))
			{
				j = i;
			}
		}
		this.listaPrescricao.remove(j);
	}

	public ArrayList<String> getListaPatologias()
	{
		return listaPatologias;
	}

	public void setListaPatologias(ArrayList<String> listaPatologias)
	{
		this.listaPatologias = listaPatologias;
	}

	public ArrayList<String> getListaPrescricao()
	{
		return listaPrescricao;
	}

	public void setListaPrescricao(ArrayList<String> listaPrescricao)
	{
		this.listaPrescricao = listaPrescricao;
	}

	public String getNumeroIdentificacao()
	{
		return numeroIdentificacao;
	}

	public void setNumeroIdentificacao(String numeroIdentificacao)
	{
		this.numeroIdentificacao = numeroIdentificacao;
	}

}
