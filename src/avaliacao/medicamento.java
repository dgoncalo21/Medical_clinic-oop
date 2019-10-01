package avaliacao;

public class medicamento extends nome
{
	private double preco;

	public medicamento()
	{
		super();
		this.preco = 0;
	}

	public medicamento(String nome, double preco)
	{
		super(nome);
		this.preco = preco;
	}

	public double getPreco()
	{
		return preco;
	}

	public void setPreco(double preco)
	{
		this.preco = preco;
	}

}
