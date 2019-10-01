package avaliacao;

import java.util.ArrayList;
import java.util.Scanner;

public class menuMed
{
	public menuMed(BaseDeDados dados, medico med)
	{
		boolean sair = false;
		Scanner sc = new Scanner(System.in);

		while (sair == false)
		{
			System.out.println(
					"Que operacao pretende fazer? \n 1.Registar doente \n 2.Registar patologia \n 3.Registar prescricao de um medicamento \n 4.Corrigir nome doente \n 5.Corrigir numero de identificacao doente \n 6.Corrigir patologia \n 7.Corrigir prescricao de um medicamento \n 8.Remover doente \n 9.Remover patologia \n 10.Remover prescricao de um medicamento \n 11.Pesquisar por um dos seus doentes \n 12.Listar patologias de um dado doente \n 13.Listar os medicamentos prescritos a um dado doente \n 14.Listar Doentes \n 15.Listar todos os medicamentos \n 16.Voltar ao login \n 17.Terminar programa");

			int operacao = sc.nextInt();
			sc.nextLine();

			if (operacao > 0 && operacao < 18)
			{
				if (operacao == 1)
				{
					boolean operacao1Valida = false;
					while (operacao1Valida == false)
					{
						System.out.println("Inserir nome do doente: \n");
						String nomeDoente = sc.nextLine();

						System.out.println("Inserir numero de Identificacao do doente: \n");
						String iD = sc.nextLine();

						if (nomeDoente.length() != 0 && iD.length() != 0)
						{
							if (med.numeroIdentificacaoErro(iD) == true)
							{
								System.out.println("numer de identificacao em uso");
							}
							else
							{
								ArrayList<String> lista = new ArrayList<String>();
								med.registarDoente(nomeDoente, iD, lista, lista);
								med.atualizarDados(dados, med);

								operacao1Valida = true;
							}
						}
						else
						{
							System.out.println("Inputs vazios nao sao validos");
						}
					}
				}

				if (operacao > 1 && operacao < 14) // para as operacoes que pedem ID
				{
					boolean operacaoValida = false;
					while (operacaoValida == false)
					{

						System.out.println("Inserir numero de identificacao do doente: \n");
						String numeroIdentificacao = sc.nextLine(); // ver se e string

						if (med.numeroIdentificacaoErro(numeroIdentificacao) == false)
						{
							System.out.println("Este numero de identificacao nao se encontra registado");
						}
						else
						{
							operacaoValida = true;

							if (operacao == 2) // a patologia nao pode ser repetida dentro do mesmo doente, mas pode
												// ser igual em doentes diferentes
							{
								boolean operacao2Valida = false;
								while (operacao2Valida == false)
								{
									System.out.println("Inserir patologia: \n");
									String patologia = sc.nextLine();

									if (patologia.length() != 0)
									{
										if (med.patologiaErro(patologia) == true)
										{
											System.out.println(
													"Patologia ja presente na lista de patologias do paciente.");
										}
										else
										{
											med.registarPatologia(numeroIdentificacao, patologia);
											med.atualizarDados(dados, med);
											operacao2Valida = true;
										}

									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}

								}

							}
							else if (operacao == 3)
							{
								boolean operacao3Valida = false;
								while (operacao3Valida == false)
								{
									System.out.println("Inserir prescricao: \n");
									String prescricao = sc.nextLine();

									if (prescricao.length() != 0)
									{
										if (med.prescricaoErro(prescricao) == true)
										{

											System.out.println(
													"Medicamento prescrito ja presente na lista de prescricao do paciente.");

										}
										else
										{
											if (med.medicamentoErro(dados, prescricao) == false)
											{
												System.out.println("Medicamento prescrito nao se encontra registado");
											}
											else
											{
												med.registarPrescricao(numeroIdentificacao, prescricao);
												med.atualizarDados(dados, med);
												operacao3Valida = true;
											}
										}
									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}
								}
							}
							else if (operacao == 4)
							{
								boolean operacao4Valida = false;
								while (operacao4Valida == false)
								{
									System.out.println("Inserir novo nome: \n");
									String novoNome = sc.nextLine();

									if (novoNome.length() != 0)
									{
										med.corrigirDoenteNome(numeroIdentificacao, novoNome);
										med.atualizarDados(dados, med);
										operacao4Valida = true;
									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}
								}

							}
							else if (operacao == 5)
							{
								boolean operacao5Valida = false;
								while (operacao5Valida == false)
								{
									System.out.println("Inserir novo numero de identificacao: \n");
									String iD = sc.nextLine();

									if (iD.length() != 0)
									{
										if (med.numeroIdentificacaoErro(iD) == true)
										{
											System.out.println("Numero de identificacao em uso");
										}
										else
										{
											med.corrigirDoenteNumero(numeroIdentificacao, iD);
											med.atualizarDados(dados, med);
											operacao5Valida = true;
										}
									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}
								}
							}
							else if (operacao == 6) // tenho de verificar que a patologia existe na lista de patologias
													// e
													// que a nova patologia nao esta repetida
							{
								boolean operacao5Valida = false;
								while (operacao5Valida == false)
								{
									System.out.println("Inserir patologia que pretende atualizar: \n");
									String patologia = sc.nextLine();
									System.out.println("Inserir nova patologia: \n");
									String patologiaNova = sc.nextLine();

									if (patologia.length() != 0 && patologiaNova.length() != 0)
									{
										if (med.patologiaErro(patologiaNova) == true)
										{
											System.out.println(
													"Nova patologia ja presente na lista de patologias do paciente.");
										}
										else
										{
											if (med.patologiaErro(patologia) == false)
											{
												System.out.println(
														"A patologia que pretende alterar nao se encontra na lista de patologias do doente.");
											}
											else
											{
												med.corrigirDoentePatologia(numeroIdentificacao, patologia,
														patologiaNova);
												med.atualizarDados(dados, med);
												operacao5Valida = true;
											}
										}
									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}
								}

							}
							else if (operacao == 7) // tenho de verificar que a prescricao existe na lista de
													// prescricoes e
													// que a nova prescricao nao esta repetida
							{
								boolean operacao6Valida = false;
								while (operacao6Valida == false)
								{
									System.out.println("Inserir prescricao que pretende atualizar: \n");
									String prescricao = sc.nextLine();

									System.out.println("Inserir nova prescricao: \n");
									String prescricaoNova = sc.nextLine();

									if (prescricao.length() != 0 && prescricaoNova.length() != 0)
									{
										if (med.prescricaoErro(prescricaoNova) == true)
										{
											System.out.println(
													"Nova prescricao ja presente na lista de prescricoes do paciente.");
										}
										else
										{
											if (med.prescricaoErro(prescricao) == false)
											{
												System.out.println(
														"A prescricao que pretende alterar nao se encontra na lista de prescricao do doente.");
											}
											else
											{
												if (med.medicamentoErro(dados, prescricaoNova) == false)
												{
													System.out
															.println("Medicamento prescrito nao se encontra registado");
												}
												else
												{
													med.corrigirDoentePrescricao(numeroIdentificacao, prescricao,
															prescricaoNova);
													med.atualizarDados(dados, med);
													operacao6Valida = true;
												}
											}
										}
									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}
								}

							}
							else if (operacao == 8)
							{
								med.removerDoente(numeroIdentificacao);
								med.atualizarDados(dados, med);
							}
							else if (operacao == 9)
							{
								boolean operacao8Valida = false;
								while (operacao8Valida == false)
								{
									System.out.println("Inserir patologia: \n");
									String patologia = sc.nextLine();

									if (patologia.length() != 0)
									{
										if (med.patologiaErro(patologia) == false)
										{
											System.out.println(
													"A patologia que pretende remover nao se encontra na lista de patologias do doente.");
										}
										else
										{
											med.removerPatologia(numeroIdentificacao, patologia);
											med.atualizarDados(dados, med);
											operacao8Valida = true;
										}

									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}
								}
							}

							else if (operacao == 10)
							{
								boolean operacao9Valida = false;
								while (operacao9Valida == false)
								{
									System.out.println("Inserir prescricao: \n");
									String prescricao = sc.nextLine();

									if (prescricao.length() != 0)
									{
										if (med.prescricaoErro(prescricao) == false)
										{
											System.out.println(
													"A prescricao que pretende remover nao se encontra na lista de prescricoes do doente.");
										}
										else
										{
											med.removerPrescricao(numeroIdentificacao, prescricao);
											med.atualizarDados(dados, med);
											operacao9Valida = true;
										}
									}
									else
									{
										System.out.println("Inputs vazios nao sao validos");
									}
								}
							}
							else if (operacao == 11)
							{
								System.out.println("Numero de Identificacao: " + numeroIdentificacao);
								System.out.println("Nome: " + med.pesquisarDoente(numeroIdentificacao).get(0).get(0));
								System.out.println("Patologias: ");
								for (int i = 0; i < med.pesquisarDoente(numeroIdentificacao).get(1).size(); i++)
								{
									System.out.println(med.pesquisarDoente(numeroIdentificacao).get(1).get(i));
								}
								System.out.println("Prescricoes: ");
								for (int i = 0; i < med.pesquisarDoente(numeroIdentificacao).get(2).size(); i++)
								{
									System.out.println(med.pesquisarDoente(numeroIdentificacao).get(2).get(i));
								}
								System.out.println("\n");
							}
							else if (operacao == 12)
							{
								System.out.println("Lista de Patologias: ");
								for (int i = 0; i < med.listarPatologias(numeroIdentificacao).size(); i++)
								{
									System.out.println(med.listarPatologias(numeroIdentificacao).get(i));
								}
								System.out.println("\n");
							}
							else if (operacao == 13)
							{
								System.out.println("Lista de Prescricoes: ");
								for (int i = 0; i < med.listarPrescricao(numeroIdentificacao).size(); i++)
								{
									System.out.println(med.listarPrescricao(numeroIdentificacao).get(i));
								}
								System.out.println("\n");
							}
						}
					}
				}
				else
				{
					if (operacao == 14)
					{
						for (int i = 0; i < med.listarDoentes().size() / 2; i++)
						{
							System.out.println(
									med.listarDoentes().get(2 * i) + " -> " + med.listarDoentes().get(2 * i + 1));
						}
						System.out.println("\n");
					}
					else if (operacao == 15)
					{
						for (int i = 0; i < med.listarMedicamentos(dados).size() / 2; i++)
						{
							System.out.println(med.listarMedicamentos(dados).get(2 * i) + " -> "
									+ med.listarMedicamentos(dados).get(2 * i + 1));
						}
						System.out.println("\n");
					}
					else if (operacao == 16)
					{
						sair = true;
						Interface interfac2 = new Interface(dados);
					}
					else if (operacao == 17)
					{
						sair = true;
						System.out.println("Programa Encerrado");
					}
				}

			}
			else
			{
				System.out.println("O numero inserido nao esta presente no menu.");
			}

		}
		sc.close();
	}
}
