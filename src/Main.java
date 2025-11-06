import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomeArquivo = "meuPlantario.txt";
        int menu;

        do {
            System.out.println("\n=== Meu Plantário ===");
            System.out.println("1 - Cadastro de Plantas");
            System.out.println("2 - Listar Plantas");
            System.out.println("3 - Remover Plantas");
            System.out.println("4 - Ver Lembretes");
            System.out.println("5 - Sair");
            System.out.println("---------------------");
            System.out.print("Opção: ");
            menu = sc.nextInt();
            while (menu > 5 && menu < 1) {
                System.out.println("ERRO. digite uma opção válida.");
                menu = sc.nextInt();
            }

            switch (menu) {
                case 1:
                    String nome, intensidadeRega;
                    int diasRega, diasAdubo, switchRega, maisCadastro = 1;
                    while (maisCadastro == 1) {
                        System.out.println("\n=== CADASTRO DE PLANTAS ===\n");
                        System.out.print("Digite o nome da planta: ");
                        sc.nextLine();
                        nome = sc.nextLine();
                        System.out.print("Digite o intervalo de rega (em dias): ");
                        diasRega = sc.nextInt();
                        System.out.print("Digite o intervalo de adubagem (em dias): ");
                        diasAdubo = sc.nextInt();
                        System.out.print("Qual das regas é feita? \n1 - Rega baixa \n2 - Rega média \n3 - Rega alta");
                        System.out.print("\nOpção: ");
                        switchRega = sc.nextInt();

                        while (switchRega < 1 && switchRega > 3) {
                            System.out.println("ERRO. digite uma opção válida.");
                            switchRega = sc.nextInt();
                        }

                        switch (switchRega) {
                            case 1:
                                intensidadeRega = "rega baixa";
                                break;
                            case 2:
                                intensidadeRega = "rega média";
                                break;
                            default:
                                intensidadeRega = "rega alta";
                        }

                        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
                            writer.write(nome + ";" + diasRega + ";" + intensidadeRega + ";" + diasAdubo + "\n");
                            System.out.println("Planta salva com sucesso!");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar: " + e.getMessage());
                        }

                        System.out.println("\nDigite 1 para cadastrar outra planta ou 0 para voltar ao menu: ");
                        maisCadastro = sc.nextInt();
                        while (maisCadastro != 0 && maisCadastro != 1) {
                            System.out.println("ERRO. digite uma opção válida.");
                            maisCadastro = sc.nextInt();
                        }

                        if (maisCadastro == 0) {
                            System.out.println("\nRetornando ao Menu...\n");
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n=== LISTA PLANTAS ===\n");
                    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
                        String linha;
                        boolean temPlanta = false;

                        while ((linha = reader.readLine()) != null) {
                            temPlanta = true;
                            String[] partes = linha.split(";");

                            if (partes.length >= 1) {
                                String nomePlanta = partes[0];
                                System.out.println("- " + nomePlanta);
                            }
                        }

                        if (!temPlanta) {
                            System.out.println("Nenhuma planta cadastrada ainda...\n");
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao ler a lista: " + e.getMessage() + "\n");
                    }
                    System.out.print("\nVoltando ao menu...\n");
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("\nEncerrando programa...\n");
                    break;
                default:
            }
        } while (menu!= 4);
    }
}