package avaliacao;

import java.util.Scanner;

public class menuAdmin
{
	private administrador admin = new administrador();

	public menuAdmin(BaseDeDados dados)
	{

		boolean sair = false;
		Scanner sc = new Scanner(System.in);
		while (sair == false)
		{
			System.out.println(
					"Que operacao pretende fazer? \n 1.Registar medico \n 2.Registar medicamento \n 3.Atualizar medico \n 4.Atualizar medicamento \n 5.Remover medico \n 6.Remover medicamento \n 7.Listar Medicos \n 8.Listar medicos por especialidade \n 9.Listar medicamentos \n 10.Listar doentes \n 11.Numero de doentes por medico em cada especialidade \n 12.Custo medio da medicacao de cada paciente \n 13.Voltar ao login \n 14.Terminar programa");

			int operacao = sc.nextInt();
			sc.nextLine();
			if (operacao > 0 && operacao < 15)
			{
				if (operacao == 1)
				{
					boolean operacao1Valida = false;
					while (operacao1Valida == false)
					{
						System.out.println("Inserir nome do medico: \n");
						String nomeMedico = sc.nextLine();

						System.out.println("Inserir username do medico: \n");
						String usernameMedico = sc.nextLine();

						System.out.println("Inserir password do medico: \n");
						String passMedico = sc.nextLine();

						System.out.println("Inserir especializacao do medico: \n");
						String especializacao = sc.nextLine();

						if (nomeMedico.length() != 0 && usernameMedico.length() != 0 && passMedico.length() != 0
								&& especializacao.length() != 0)
						{
							if (admin.usernameErro(dados, usernameMedico) == true)
							{
								System.out.println("Username em uso");
							}
							else
							{
								admin.registarMedico(dados, nomeMedico, usernameMedico, passMedico, especializacao);
								operacao1Valida = true;
							}
						}
						else
						{
							System.out.println("Inputs vazios nao sao validos");
						}
					}
				}
				else if (operacao == 2)
				{
					boolean operacao2Valida = false;
					while (operacao2Valida == false)
					{
						System.out.println("Inserir nome do medicamento: \n");
						String nomeMedicamento = sc.nextLine();

						sc.nextLine();
						System.out.println("Inserir preco do medicamento: \n");
						double precoMedicamento = sc.nextDouble();

						if (nomeMedicamento.length() != 0 && Double.toString(precoMedicamento).length() != 0)
						{
							if (admin.medicamentoErro(dados, nomeMedicamento) == true)
							{
								System.out.println("Medicamento em uso");
							}
							else
							{
								admin.registarMedicamento(dados, nomeMedicamento, precoMedicamento);
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
					boolean operacao1 = false;
					while (operacao1 == false)
					{
						System.out.println(
								"O que pretende atualizar? \n 1.Nome \n 2.Especializacao \n 3.Username \n 4.Password \n");

						int atualizaMedico = sc.nextInt();
						sc.nextLine();
						if (atualizaMedico > 0 && atualizaMedico < 5)
						{
							operacao1 = true;
							boolean operacao3Valida = false;
							while (operacao3Valida == false)
							{
								System.out.println("Inserir username do medico a atualizar: \n");
								String username = sc.nextLine();
								if (admin.usernameErro(dados, username) == true)
								{
									operacao3Valida = true;
									if (atualizaMedico == 1)
									{
										boolean operacao31Valida = false;
										while (operacao31Valida == false)
										{
											System.out.println("Inserir novo nome: \n");
											String nomeNovo = sc.nextLine();

											if (username.length() != 0 && nomeNovo.length() != 0)
											{
												admin.corrigirMedicoNome(dados, username, nomeNovo);
												operacao31Valida = true;
											}
											else
											{
												System.out.println("Inputs vazios nao sao validos");
											}
										}
									}
									else if (atualizaMedico == 2)
									{
										boolean operacao32Valida = false;
										while (operacao32Valida == false)
										{
											System.out.println("Inserir nova especializacao: \n");
											String especializacao = sc.nextLine();

											if (username.length() != 0 && especializacao.length() != 0)
											{
												admin.corrigirMedicoEspecializacao(dados, username, especializacao);
												operacao32Valida = true;
											}
											else
											{
												System.out.println("Inputs vazios nao sao validos");
											}
										}

									}
									else if (atualizaMedico == 3)
									{
										boolean operacao33Valida = false;
										while (operacao33Valida == false)
										{
											System.out.println("Inserir novo username: \n");
											String usernameNovo = sc.nextLine();

											if (username.length() != 0 && usernameNovo.length() != 0)
											{
												if (admin.usernameErro(dados, usernameNovo) == true)
												{
													System.out.println("Username em uso");
												}
												else
												{
													admin.corrigirMedicoUsername(dados, username, usernameNovo);
													operacao33Valida = true;
												}
											}
											else
											{
												System.out.println("Inputs vazios nao sao validos");
											}
										}
									}

									else
									{
										boolean operacao34Valida = false;
										while (operacao34Valida == false)
										{
											System.out.println("Inserir nova password: \n");
											String password = sc.nextLine();

											if (username.length() != 0 && password.length() != 0)
											{
												admin.corrigirMedicoPassword(dados, username, password);
												operacao34Valida = true;
											}
											else
											{
												System.out.println("Inputs vazios nao sao validos");
											}
										}
									}
								}
								else
								{
									System.out.println("Username nao se encontra na base de dados");
								}
							}
						}
						else
						{
							System.out.println("Numero nao esta presente no menu. Inserir novo numero");
						}
					}
				}

				else if (operacao == 4)
				{
					boolean operacao4 = false;
					while (operacao4 == false)
					{
						System.out.println("O que pretende atualizar? \n 1.Nome \n 2.Preco \n");
						int atualizaMedicamento = sc.nextInt();
						sc.nextLine();

						if (atualizaMedicamento > 0 && atualizaMedicamento < 3)
						{
							operacao4 = true;
							boolean operacao4Valida = false;
							while (operacao4Valida == false)
							{
								System.out.println("Inserir nome do medicamento a atualizar: \n");
								String nomeMedicamento = sc.nextLine();
								if (admin.medicamentoErro(dados, nomeMedicamento) == true)
								{
									if (atualizaMedicamento == 1)
									{
										if (admin.medicamentoPrescricaoErro(dados, nomeMedicamento) == false)
										{
											operacao4Valida = true;
											boolean operacao41Valida = false;
											while (operacao41Valida == false)
											{
												System.out.println("Inserir novo nome do medicamento: \n");
												String nomeNovo = sc.nextLine();

												if (nomeMedicamento.length() != 0 && nomeNovo.length() != 0)
												{
													if (admin.medicamentoErro(dados, nomeNovo) == true)
													{
														System.out.println("Nome novo do medicamento em uso");
													}
													else
													{
														admin.corrigirMedicamentoNome(dados, nomeMedicamento, nomeNovo);
														operacao41Valida = true;
													}
												}
												else
												{
													System.out.println("Inputs vazios nao sao validos");
												}
											}
										}
										else
										{
											System.out.println("Nao se pode atualizar medicamentos prescritos");
										}

									}
									else
									{
										boolean operacao42Valida = false;
										while (operacao42Valida == false)
										{
											System.out.println("Inserir novo preco do medicamento: \n");
											double preco = sc.nextDouble();

											if (nomeMedicamento.length() != 0 && Double.toString(preco).length() != 0)
											{
												admin.corrigirMedicamentoPreco(dados, nomeMedicamento, preco);
												operacao42Valida = true;
											}
											else
											{
												System.out.println("Inputs vazios nao sao validos");
											}
										}
									}
								}
								else
								{
									System.out.println("Medicamento não está registado");
								}
							}
						}
						else
						{
							System.out.println("Numero nao esta presente no menu.");
						}
					}

				}

				else if (operacao == 5)
				{
					boolean operacao5 = false;
					while (operacao5 == false)
					{
						System.out.println("Inserir username do medico: \n");
						String username = sc.nextLine();

						if (admin.usernameErro(dados, username) == true)
						{
							operacao5 = true;
							for (int i = 0; i < dados.getListaMedicos().size(); i++)
							{
								if (dados.getListaMedicos().get(i).getUsername().equals(username))
								{
									if (dados.getListaMedicos().get(i).getListaDoentes().size() == 0)
									{
										admin.removerMedico(dados, username);
										break;
									}
									else
									{
										System.out.println("Nao se pode remover medicos com pacientes");
									}
								}
							}

						}
						else
						{
							System.out.println("Medico nao se encontra registado");
						}
					}
				}

				else if (operacao == 6)
				{
					boolean operacao6 = false;
					while (operacao6 == false)
					{
						System.out.println("Inserir nome do medicamento: \n");
						String nomeMedicamento = sc.nextLine();

						if (admin.medicamentoErro(dados, nomeMedicamento) == true)
						{
							operacao6 = true;

							int l = 0;
							for (int i = 0; i < dados.getListaMedicos().size(); i++)
							{
								for (int j = 0; j < dados.getListaMedicos().get(i).getListaDoentes().size(); j++)
								{
									for (int k = 0; k < dados.getListaMedicos().get(i).getListaDoentes().get(j)
											.getListaPrescricao().size(); k++)
									{
										if (dados.getListaMedicos().get(i).getListaDoentes().get(j).getListaPrescricao()
												.contains(nomeMedicamento))
										{
											System.out.println("Nao se pode remover medicamentos prescritos");
											l = 1;
											break;
										}
									}
								}
							}
							if (l == 0)
							{
								admin.removerMedicamento(dados, nomeMedicamento);
							}
						}
						else
						{
							System.out.println("Medicamento nao se encontra registado");
						}
					}
				}

				else if (operacao == 7)
				{
					for (int i = 0; i < admin.listarMedicos(dados).size() / 2; i++)
					{
						System.out.println(admin.listarMedicos(dados).get(2 * i) + " -> "
								+ admin.listarMedicos(dados).get(2 * i + 1));
					}
					System.out.println("\n");
				}
				else if (operacao == 8)
				{
					boolean operacao8Valida = false;
					boolean especializPresente = false;
					while (operacao8Valida == false)
					{
						System.out.println("Inserir especializacao : \n");
						String especializacao = sc.nextLine();

						if (especializacao.length() != 0)
						{
							for (int i = 0; i < dados.getListaMedicos().size(); i++)
							{
								if (dados.getListaMedicos().get(i).getEspecializacao().equals(especializacao))
								{
									especializPresente = true;
									break;
								}
							}
							if (especializPresente == true)
							{
								for (int i = 0; i < admin.listarMedicosEsp(dados, especializacao).size() / 2; i++)
								{
									System.out.println(admin.listarMedicosEsp(dados, especializacao).get(2 * i) + " -> "
											+ admin.listarMedicosEsp(dados, especializacao).get(2 * i + 1));
								}
								System.out.println("\n");
								operacao8Valida = true;
							}
							else
							{
								System.out.println("Nao existem medicos com essa especializacao.");
							}
						}
						else
						{
							System.out.println("Inputs vazios nao sao validos.");
						}
					}
				}
				else if (operacao == 9)
				{
					for (int i = 0; i < admin.listarMedicamentos(dados).size() / 2; i++)
					{
						System.out.println(admin.listarMedicamentos(dados).get(2 * i) + " -> "
								+ admin.listarMedicamentos(dados).get(2 * i + 1));
					}
				}
				else if (operacao == 10)
				{
					for (int i = 0; i < admin.listarDoentes(dados).size() / 2; i++)
					{
						System.out.println(admin.listarDoentes(dados).get(2 * i) + " -> "
								+ admin.listarDoentes(dados).get(2 * i + 1));
					}
					System.out.println("\n");
				}
				else if (operacao == 11)
				{
					for (int i = 0; i < admin.doentePorMedico(dados).size() / 2; i++)
					{
						System.out.println(admin.doentePorMedico(dados).get(2 * i) + " -> "
								+ admin.doentePorMedico(dados).get(2 * i + 1));
					}
					System.out.println("\n");
				}
				else if (operacao == 12)
				{
					System.out.println("Valor: " + admin.medicacaoPorPaciente(dados));
				}
				else if (operacao == 13)
				{
					sair = true;
					Interface interfac2 = new Interface(dados);
				}
				else if (operacao == 14)
				{
					sair = true;
					System.out.println("Programa Encerrado");
				}
			}

			else
			{
				System.out.println("Numero nao esta presente no menu.\n");
			}

		}
		sc.close();

	}

}
