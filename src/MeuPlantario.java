import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MeuPlantario {
    private static Formatter arqSaida;
    private static Scanner arqEnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;

        do {
            // cadastraPlanta();
            // fechaArqEsc();
            // leRegistro();
            // fechaArqLeit();
            abreArqEscrita();
            System.out.println("\n===== Meu Plantário =====");
            System.out.println("1 - Cadastro de Plantas");
            System.out.println("2 - Listar Plantas");
            System.out.println("3 - Remover Plantas");
            System.out.println("4 - Alterar Cadastro de Plantas");
            System.out.println("5 - Regar");
            System.out.println("6 - Adubar");
            System.out.println("7 - Ver Lembretes");
            System.out.println("8 - Sugestão de plantas");
            System.out.println("9 - Sair");
            System.out.println("---------------------");
            System.out.print("Opção: ");
            menu = sc.nextInt();
            while (menu > 9 && menu < 1) {
                System.out.println("ERRO. digite uma opção válida.");
                menu = sc.nextInt();
            }

            switch (menu) {
                case 1:
                    System.out.print("\n===== CADASTRO DE PLANTAS ======\n");
                    cadastraPlanta();
                    break;
                case 2:
                    System.out.print("\n===== LISTAGEM DE PLANTAS ======\n");
                    listaPlantas();
                    break;
                case 3:
                    System.out.print("\n===== REMOÇÃO DE CADASTRO ======\n");
                    removePlanta();
                    break;
                case 4:
                    System.out.print("\n===== ALTERAÇÃO DE PLANTAS =====\n");
                    // função
                    break;
                case 5:
                    System.out.print("\n===== REGAR PLANTA =====\n");
                    // função
                    break;
                case 6:
                    System.out.print("\n===== ADUBAR PLANTA =====\n");
                    // função
                    break;
                case 7:
                    System.out.print("\n===== LEMBRETES =====\n");
                    // função
                    break;
                case 8:
                    System.out.print("\n===== SUGESTÃO DE PLANTAS =====\n");
                    // função
                    break;
                default:
                    System.out.print("Encerrando...");
            }
        } while (menu != 9);
    }

    public static void abreArqEscrita() {
        try {
            FileWriter fw = new FileWriter("plantas.txt", true);
            arqSaida = new Formatter(fw);
        } catch (SecurityException securityException) {
            System.err.println("Permissão de Escrita Negada. Fechando...");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro ao abrir o arquivo. Fechando...");
            System.exit(1);
        } catch (IOException ioException) {
            System.err.println("Erro de IO ao abrir/usar arquivo. Fechando...");
            System.exit(1);
        }
    }

    public static void abreArqLeitura() {
        try {
            arqEnt = new Scanner(new File("plantas.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro na abertura do arquivo para leitura.");
            System.exit(1);
        }
    }

    public static void cadastraPlanta() {
        Scanner scCadastro = new Scanner(System.in);
        int switchRega, switchTipo, intervaloRega, intervaloAdubo, qtdAdubo;
        String tipoRega = "", tipoAdubo = "", tipoPlanta = "";

        try {
            System.out.print("Digite o nome da planta: ");
            String nome = scCadastro.next();
            scCadastro.nextLine();

            System.out.print(
                    "Planta de:" +
                    "\n   1 - Sombra" +
                    "\n   2 - Meia-sombra" +
                    "\n   3 - Sol" +
                    "\nOpção: ");
            switchTipo = scCadastro.nextInt();
            while (switchTipo < 1 || switchTipo > 3) {
                System.out.print("Tipo de planta inválido. Digite novamente: ");
                switchTipo = scCadastro.nextInt();
            }
            switch (switchTipo) {
                case 1:
                    tipoPlanta = "sombra";
                    break;
                case 2:
                    tipoPlanta = "meia-sombra";
                    break;
                default:
                    tipoPlanta = "sol";
            }


            System.out.print("Digite o intervalo de rega (dias): ");
            intervaloRega = scCadastro.nextInt();
            while (intervaloRega <= 0) {
                System.out.print("Intervalo inválido. Digite um número positivo: ");
                intervaloRega = scCadastro.nextInt();
            }

            System.out.print("Digite o intervalo de adubagem em dias: ");
            intervaloAdubo = scCadastro.nextInt();
            while (intervaloAdubo <= 0) {
                System.out.print("Intervalo inválido. Digite um número positivo: ");
                intervaloAdubo = scCadastro.nextInt();
            }

            System.out.print("Digite o tipo de adubo: ");
            scCadastro.nextLine();
            tipoAdubo = scCadastro.nextLine();

            System.out.print(
                    "Qual das regas é feita?" +
                    "\n   1 - Rega baixa" +
                    "\n   2 - Rega média" +
                    "\n   3 - Rega alta" +
                    "\nOpção: ");
            switchRega = scCadastro.nextInt();
            while (switchRega < 1 || switchRega > 3) {
                System.out.print("Tipo de rega inválido. Digite novamente: ");
                switchRega = scCadastro.nextInt();
            }
            switch (switchRega) {
                case 1:
                    tipoRega = "baixa";
                    break;
                case 2:
                    tipoRega = "media";
                    break;
                default:
                    tipoRega = "alta";
            }

            arqSaida.format("%s;%s;%d;%d;%s;%s;%n", nome, tipoPlanta, intervaloRega, intervaloAdubo, tipoRega, tipoAdubo);
            fechaArqEsc();
            System.out.printf("%nPlanta '%s' foi cadastrada com sucesso!%n", nome);

        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Erro de escrita no arquivo. Finalizando...");
        } catch (NoSuchElementException elementException) {
            System.err.println("Entrada inválida ou finalizada inesperadamente. Digite novamente.");
            scCadastro.nextLine();
        }
    }

    public static void listaPlantas() {
        Scanner scLista = new Scanner(System.in);
        int switchLista;
        String filtroTipo = "";

        System.out.print(
                "\nOpções de listagem: " +
                "\n   1 - Listar todas as plantas: " +
                "\n   2 - Listar plantas de sombra: " +
                "\n   3 - Listar plantas de meia-sombra: " +
                "\n   4 - Listar plantas de sol: " +
                "\nOpção: ");
        switchLista = scLista.nextInt();
        while (switchLista < 1 || switchLista > 4) {
            System.out.print("Opção inexistente. Digite novamente: ");
            switchLista = scLista.nextInt();
        }

        switch (switchLista) {
            case 1:
                filtroTipo = "todas";
                break;
            case 2:
                filtroTipo = "sombra";
                break;
            case 3:
                filtroTipo = "meia-sombra";
                break;
            default:
                filtroTipo = "sol";
        }
        exibeListaPlantas(filtroTipo);
    }

    public static void exibeListaPlantas(String filtro) {
        abreArqLeitura();
        if (arqEnt == null) {
            System.out.println("Arquivo plantas.txt não encontrado.");
            return;
        } else {
            try {
                int contador = 0;
                String[] linhasTemp = new String[100];
                int totalLinhas = 0;

                // Primeiro lê todas as linhas válidas
                while (arqEnt.hasNextLine() && totalLinhas < 100) {
                    String linha = arqEnt.nextLine(). trim();
                    if (!linha.isEmpty()) {
                        String[] dados = linha.split(";");
                        if (dados.length >= 6) {
                            if (filtro.equals("todas") || dados[1].equals(filtro)) {
                                linhasTemp[totalLinhas] = linha;
                                totalLinhas++;
                            }
                        }
                    }
                }

                // Se não encontrou nenhuma, só mostra mensagem e sai
                if (totalLinhas == 0) {
                    System.out.println("\n=====================================================");
                    if (filtro.equals("todas")) {
                        System.out.println("Nenhuma planta cadastrada ainda.");
                    } else {
                        System.out.printf("Nenhuma planta do tipo '%s' encontrada.\n", filtro);
                    }
                    System.out.println("=====================================================");
                    return;
                }

                // Se encontrou, mostra cabeçalho e lista
                System.out.println("\n=====================================================");
                if (filtro.equals("todas")) {
                    System.out.println("LISTAGEM DE TODAS AS PLANTAS");
                } else {
                    System.out.println("LISTAGEM DE PLANTAS DE " + filtro.toUpperCase());
                }
                System.out.println("==========================================================================================================");
                System.out.printf("%-22s %-15s %-12s %-15s %-12s %-20s%n",
                        "Nome", "Tipo", "Rega(dias)", "Adubo(dias)", "Tipo Rega", "Tipo Adubo");
                System. out.println("----------------------------------------------------------------------------------------------------------");

                for (int i = 0; i < totalLinhas; i++) {
                    String[] dados = linhasTemp[i].split(";");
                    String nome = dados[0];
                    String tipoPlanta = dados[1];
                    int intervaloRega = Integer.parseInt(dados[2]);
                    int intervaloAdubo = Integer.parseInt(dados[3]);
                    String tipoRega = dados[4];
                    String tipoAdubo = dados[5];

                    System.out.printf("%-22s %-15s %-12d %-15d %-12s %-20s%n",
                            nome, tipoPlanta, intervaloRega, intervaloAdubo,
                            tipoRega, tipoAdubo);
                }

                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out. println("Total de plantas listadas: " + totalLinhas);
                System.out.println("==========================================================================================================");

            } catch (NoSuchElementException elementException) {
                System.err.println("Erro ao ler os dados do arquivo.");
            } catch (IllegalStateException stateException) {
                System. err.println("Erro na leitura do arquivo.");
            } catch (NumberFormatException numberException) {
                System.err. println("Arquivo com formato incorreto.");
            }
            fechaArqLeit();
        }
    }

    public static void removePlanta() {
        Scanner scRemove = new Scanner(System.in);
        String[] linhas = new String[100];
        int total = 0;
        boolean encontrou = false;

        abreArqLeitura();
        while (arqEnt.hasNextLine()) {
            linhas[total] = arqEnt.nextLine();
            total++;
        }
        fechaArqLeit();

        if (total == 0) {
            System.out.println("Nenhuma planta cadastrada.");
        } else {
            System.out.println("Plantas cadastradas: ");
            for (int i = 0; i < total; i++) {
                String[] p = linhas[i].split(";");
                System.out.println((i + 1) + " - " + p[0]);
            }

            System.out.println("Digite o nome da planta para remover: ");
            String nome = scRemove.nextLine();

            try {
                Formatter arqNovo = new Formatter("plantas.txt");
                for (int i = 0; i < total; i++) {
                    String[] p = linhas[i].split(";");
                    if (p[0].equalsIgnoreCase(nome) && !encontrou) {
                        System.out.println("Planta '" + p[0] + "' removida!");
                        encontrou = true;
                    } else {
                        arqNovo.format("%s%n", linhas[i]);
                    }
                }
                arqNovo.close();

                if (!encontrou) {
                    System.out.println("Planta não encontrada.");
                }
            } catch (SecurityException securityException) {
                System.err.println("Permissão de Escrita Negada.  Fechando.. .");
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("Erro ao abrir o arquivo para escrita.");
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Erro de escrita no arquivo.");
            }
        }
    }

    public static void alteraPlanta() {
        Scanner sc = new Scanner(System.in);
        String [] linhas = new String[100];
        String nomeBusca;
        int total = 0;
        boolean encontrado = false;
    }

    public static void regaPlanta() {

    }

    public static void adubaPlanta() {

    }

    public static void abreLembrete() {

    }

    public static void sugerePlantas() {

    }

    public static void fechaArqEsc() {
        if (arqSaida != null) {
            arqSaida.close();
        }
    }

    public static void fechaArqLeit() {
        if (arqEnt != null) {
            arqEnt.close();
        }
    }
}