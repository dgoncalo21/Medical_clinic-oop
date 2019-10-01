package avaliacao;

import java.util.ArrayList;

public class BaseDeDados
{
	private ArrayList<medicamento> listaMedicamentos = new ArrayList<medicamento>();
	private ArrayList<medico> listaMedicos = new ArrayList<medico>();

	public BaseDeDados()
	{
		medico medico1 = new medico("Andre Ramos", "dre_ramos", "123450", "Dermatologia");
		this.listaMedicos.add(medico1);
		medico medico2 = new medico("Alina Rosinha", "rosinha123", "borboleta", "Clinica geral");
		this.listaMedicos.add(medico2);
		medico medico3 = new medico("Natercia Barata", "te_barata", "angola1995", "Medico de familia");
		this.listaMedicos.add(medico3);

		medicamento medicamento1 = new medicamento("silkis", 3);
		this.listaMedicamentos.add(medicamento1);
		medicamento medicamento2 = new medicamento("ben-u-ron", 2.5);
		this.listaMedicamentos.add(medicamento2);
		medicamento medicamento3 = new medicamento("combiron", 8);
		this.listaMedicamentos.add(medicamento3);

		ArrayList<String> listaPatologias1 = new ArrayList<String>();
		listaPatologias1.add("psoriase");
		ArrayList<String> listaPatologias2 = new ArrayList<String>();
		listaPatologias2.add("cefaleia");
		ArrayList<String> listaPatologias3 = new ArrayList<String>();
		listaPatologias3.add("anemia");
		ArrayList<String> listaPrescricao1 = new ArrayList<String>();
		listaPrescricao1.add("silkis");
		ArrayList<String> listaPrescricao2 = new ArrayList<String>();
		listaPrescricao2.add("ben-u-ron");
		ArrayList<String> listaPrescricao3 = new ArrayList<String>();
		listaPrescricao3.add("combiron");

		this.listaMedicos.get(0).registarDoente("Ana Costa", "153276829103", listaPatologias1, listaPrescricao1);
		this.listaMedicos.get(1).registarDoente("Ricardo Jorge", "187329032", listaPatologias2, listaPrescricao2);
		this.listaMedicos.get(2).registarDoente("Margarida Simoes", "1672387982013", listaPatologias3,
				listaPrescricao3);
	}

	public void adicionarMedico(medico medico)
	{
		this.listaMedicos.add(medico);
	}

	public void adicionarMedicamento(String nome, double preco)
	{
		medicamento med = new medicamento(nome, preco);
		this.listaMedicamentos.add(med);
	}

	public ArrayList<medicamento> getListaMedicamentos()
	{
		return listaMedicamentos;
	}

	public void setListaMedicamentos(ArrayList<medicamento> listaMedicamentos)
	{
		this.listaMedicamentos = listaMedicamentos;
	}

	public ArrayList<medico> getListaMedicos()
	{
		return listaMedicos;
	}

	public void setListaMedicos(ArrayList<medico> listaMedicos)
	{
		this.listaMedicos = listaMedicos;
	}
}