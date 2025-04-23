package service;

import entities.Startup;


import java.util.*;

public class Batalha {


    final static int WIN = 30;
    // Método para mostrar a batalha que será administrada
    public static Startup batalha(List<Startup> startups) {
        int i = 0;
        Startup a = startups.get(0);
        Startup b = startups.get(1);

        String opMenu;


        Utils.limpaTela();
        imprimeConfronto(startups, i);
        Scanner sc = new Scanner(System.in);


        Set<String> opcoesUsadas = new HashSet<>();
        do{

            String equipes = "\n\nEscolha a equipe que deseja avaliar " +
                    "\n[1]" + a.getNome() + " -- Pontos: " + a.getPontos() +
                    "\n[2]" + b.getNome() + " -- Pontos: " + b.getPontos() +
                    "\nDigite sua opção:";
            System.out.println(equipes);
            opMenu = sc.nextLine();

            if (opcoesUsadas.contains(opMenu)){
                System.out.println("Equipe já avaliada durante essa rodada!");
            }

            switch (opMenu) {
                case "1":
                    if(!opcoesUsadas.contains("1")) {
                        avaliaEquipe(a);
                        opcoesUsadas.add("1");
                    }
                    break;
                case "2":
                    if(!opcoesUsadas.contains("2")) {
                        avaliaEquipe(b);
                        opcoesUsadas.add("2");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }while (opcoesUsadas.size() < 2);



        if (a.getPontos() == b.getPontos()) {
            sharkFight(startups);
            //aumenta aleatoriamente o ponto de alguma das duas
        }



        String vencedoraA = "\n\n------------------------------------------------------------------\n" +

                a.getNome() + " é a vencedora da batalha entre |" + a.getNome() + "(" + a.getPontos() + ") x (" + b.getPontos() + ")" + b.getNome() +
                "|\n------------------------------------------------------------------";

        String vencedoraB = "\n\n------------------------------------------------------------------\n" +
                b.getNome() + " é a vencedora da batalha entre |" + a.getNome() + " (" + a.getPontos() + ") x (" + b.getPontos() + ") " + b.getNome() +
                "|\n------------------------------------------------------------------";



        //Registra a batalha no histórico
        String registro = a.getNome() + " (" + a.getPontos() + ") x (" + b.getPontos() + ") " + b.getNome();
        HistoricoBatalhas.adicionarRegistro(registro);


        // Verifica o vencedor e retorna
        if (a.getPontos() > b.getPontos()) {
            a.setPontos(a.getPontos() + WIN);
            System.out.println(vencedoraA);
            return a;

        } else {
            b.setPontos(b.getPontos() + WIN);
            System.out.println(vencedoraB);
            return b;
        }
    }

    //Método para administrar a avaliacao da equipe
    public static void avaliaEquipe(Startup startup) {
        Scanner sc = new Scanner(System.in);


        String opMenu;
        Set<String> opcoesUsadas = new HashSet<>();

        do{
            // String criada dentro do laço pra atualizar a apresentação dos pontos da startup
            String menu = "Registrar avaliacao de " + startup.getNome() + " Pontos: " + startup.getPontos() +
                    "\n[1] Pitch convincente (+6 pontos)" +
                    "\n[2] Produto com bugs (-4 pontos)" +
                    "\n[3] Boa tração de usuários (+3 pontos)" +
                    "\n[4] Investidor irritado (-6 pontos)" +
                    "\n[5] Fake news no pitch (-8 pontos)" +
                    "\n[S] Finalizar o registro." +
                    "\n\n Digite sua opção: ";




            System.out.println(menu);
            opMenu = sc.nextLine().toUpperCase();
            if (opcoesUsadas.contains(opMenu) && !opMenu.equals("S")) {

                Utils.limpaTela();
                System.out.println("Essa equipe já registrou esse evento." +
                        " O evento só pode ser registrado uma vez por rodada!\n");
            }

            switch (opMenu) {
                case "1":
                    if (!opcoesUsadas.contains("1")) {
                        startup.setPontos(startup.getPontos() + 6);
                        startup.setTotalPitchConvincente(startup.getTotalPitchConvincente() + 1);
                        Utils.limpaTela();
                        System.out.println("[Pitch convincente] para a equipe " + startup.getNome());
                        opcoesUsadas.add("1");
                    }
                    break;
                case "2":
                    if (!opcoesUsadas.contains("2")) {
                        startup.setPontos(startup.getPontos() - 4);
                        startup.setTotalProdutoComBugs(startup.getTotalProdutoComBugs() + 1);
                        Utils.limpaTela();
                        System.out.println("[Produto com bugs] para a equipe" + startup.getNome());
                        opcoesUsadas.add("2");
                    }
                    break;
                case "3":
                    if (!opcoesUsadas.contains("3")) {
                        startup.setPontos(startup.getPontos() + 3);
                        startup.setTotalBoaTracaoDeUsuario(startup.getTotalBoaTracaoDeUsuario() + 1);
                        Utils.limpaTela();
                        System.out.println("[Boa tração de usuários] para a equipe " + startup.getNome());
                        opcoesUsadas.add("3");
                    }
                    break;
                case "4":
                    if (!opcoesUsadas.contains("4")) {
                        startup.setPontos(startup.getPontos() - 6);
                        startup.setTotalInvestidorIrritado(startup.getTotalInvestidorIrritado() + 1);
                        Utils.limpaTela();
                        System.out.println("[Investidor irritador]' para a equipe " + startup.getNome());
                        opcoesUsadas.add("4");
                    }
                    break;
                case "5":
                    if (!opcoesUsadas.contains("5")) {
                        startup.setPontos(startup.getPontos() - 8);
                        startup.setTotalFakeNewsNoPitch(startup.getTotalFakeNewsNoPitch() + 1);
                        Utils.limpaTela();
                        System.out.println("[Fake news no pitch] para a equipe" + startup.getNome());
                        opcoesUsadas.add("5");
                    }
                    break;
                case "S":
                    Utils.limpaTela();
                    System.out.println("Finalizando avaliação...");
                    break;
                default:
                    Utils.limpaTela();
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (!opMenu.equals("S"));

    }

    //Imprime as startups que vão se enfrentar
    public static void imprimeConfronto(List<Startup> startups, int i) {
        Startup a = startups.get(0);
        Startup b = startups.get(1);
        System.out.println(i + 1 + ".  |" + a.getNome() + " (" + a.getPontos() + ") X (" + b.getPontos() + ") " + b.getNome() + "|");
    }

    //Função para decidir um vencedor em caso de empate na batalha
    public static void sharkFight(List<Startup> startups) {
        Startup a = startups.get(0);
        Startup b = startups.get(1);
        System.out.println("\n\nEmpate entre " + a.getNome() + " e " + b.getNome() + ".");
        System.out.println("Será realizado o Shark Fight.");

        //Gera um index aleatório entre 0 e 1
        Random random = new Random();
        int indexSorteado = random.nextInt(2);
        int pontos = startups.get(indexSorteado).getPontos();
        pontos += 2;

        startups.get(indexSorteado).setPontos(pontos);
        System.out.println("\n\n-------RESULTADO DO SHARK FIGHT----------");
        System.out.println("\nA equipe sorteada foi: " + startups.get(indexSorteado).getNome());
        System.out.println("\n-----------------------------------------");
    }

}
