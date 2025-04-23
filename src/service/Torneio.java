package service;
import entities.Startup;

import java.util.*;


public class Torneio {

    public static void iniciaTorneio(List<Startup> startups) {

        List<Startup> vencedores;
        List<Startup> impares = new ArrayList<>();
        vencedores = Rodada.rodada(startups, impares);


        while (vencedores.size() > 1){
            //partidas = sorteiaPartidas(vencedores);
            System.out.println("- - - Nova Rodada - - -\n");

            vencedores = Rodada.rodada(vencedores, impares);

        }


        if(!vencedores.isEmpty()) {
            mostrarDetalhesTorneio(startups);
        }

        menuFinal();
    }


    // Tabela com as estatísticas de desempenho das startups
    private static void mostrarDetalhesTorneio(List<Startup> startups) {
        List<Startup> startupsOrdenadas = new ArrayList<>(startups);

        // Ordena por pontos de forma decrescente
        startupsOrdenadas.sort((s1, s2) -> Integer.compare(s2.getPontos(), s1.getPontos()));
        System.out.println("\n--- Estatísticas finais  ---");
        System.out.println("Posição | Nome                        | Slogan                                                | Fundação | Pontos | Pitch Convincente | Produto com bugs | Boa tração | Investidor irritado | Fake news no pitch");
        System.out.println("--------|-----------------------------|-------------------------------------------------------|----------|--------|-------------------|------------------|------------|---------------------|-------------------");

        for (int i = 0; i < startupsOrdenadas.size(); i++) {
            Startup s = startupsOrdenadas.get(i);

            //Alinha a esquerda, e seus devidos caracteres para encaixar na tabela

            System.out.printf("%-7d | %-27s | %-53s | %-8d | %-6d | %-17d | %-16d | %-10d | %-19d | %-17d%n",
                    i+1,
                    s.getNome(),
                    s.getSlogan(),
                    s.getAnoFundacao(),
                    s.getPontos(),
                    s.getTotalPitchConvincente(),
                    s.getTotalProdutoComBugs(),
                    s.getTotalBoaTracaoDeUsuario(),
                    s.getTotalInvestidorIrritado(),
                    s.getTotalFakeNewsNoPitch());
        }
        System.out.println("\n\n---------------------------------------------------------------------------------------------------------");
        System.out.println(startupsOrdenadas.get(0).getSlogan() + " " + startupsOrdenadas.get(0).getNome() + " é a grande vencedora do Startup Rush! "  );
        System.out.println("---------------------------------------------------------------------------------------------------------\n\n");
    }

    public static void menuFinal() {


        Scanner sc = new Scanner(System.in);
        System.out.println("Aperte qualquer ENTER para continuar..");
        sc.nextLine();
        String opMenu;
        String menu = "[1] Ver historico de batalhas" +
                "\n[2] Finalizar" +
                "\nDigite sua opção:";

        do{
            System.out.println(menu);
            opMenu = sc.nextLine();

            switch (opMenu) {
                case "1":
                    HistoricoBatalhas.imprimeHistorico();
                    break;
                case "2":
                    Utils.limpaTela();
                    System.out.println("Torneio Finalizado!");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }while(!opMenu.equals("2"));
    }
}
