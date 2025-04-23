package service;

import entities.Startup;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class StartupService {

    //Constante dos pontos iniciais
    final static int PONTOS = 70;

    public static void cadastro(List<Startup>startups){

        if (startups.size() == 8) {
            System.out.println("Número máximo de participantes atingido!!!");
        }else {
            Startup startup = new Startup();
            Scanner sc = new Scanner(System.in);
            System.out.println("        - - - CADASTRO DAS STARTUPS - - -\n");
            System.out.println("Digite o nome da Startup: ");
            startup.setNome(sc.nextLine());
            System.out.println("Qual é o slogan da " + startup.getNome() +" ?");
            startup.setSlogan(sc.nextLine());


            //Válida se está colocando um ano válido
            //Try Catch pra ver se está sendo digitado um número e não uma string
            int anoFundacao;
            boolean anoValido = false;
            while (!anoValido) {
                System.out.println("Digite o ano de fundação da Startup: ");
                try {
                    anoFundacao = Integer.parseInt(sc.nextLine());
                    int anoAtual = Year.now().getValue();
                    if (anoFundacao >= 1900 && anoFundacao <= anoAtual) {
                        startup.setAnoFundacao(anoFundacao);
                        anoValido = true;
                    } else {
                        System.out.println("Ano inválido! Digite um ano entre 1900 e " + anoAtual);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido! Digite apenas números para o ano.");
                }
            }
            startups.add(startup);
        }
    }

    public static void removeStartup(List<Startup>startups) {
        if (!startups.isEmpty()) {
            Scanner sc = new Scanner(System.in);

            String opMenu;
            do {
                System.out.println("Escolha qual Startup deseja remover:");
                imprimeStartups(startups);
                System.out.println("[S] Sair");

                //toUpperCase para validar mesmo que seja S minusculo
                opMenu = sc.nextLine().toUpperCase();
                if (opMenu.matches("[1-" + startups.size() + "]") && !startups.isEmpty()) {
                    int indexStartup = Integer.parseInt(opMenu) - 1;
                    System.out.println(startups.get(indexStartup).getNome() +
                            " foi removida.\n");
                    startups.remove(startups.get(indexStartup));
                } else if (opMenu.equals("S")) {
                    Utils.limpaTela();
                    System.out.println("Voltando ao menu inicial...");
                } else {
                    System.out.println("Opção inválida!\n\n");
                }
            }while (!opMenu.equals("S") && !startups.isEmpty());
        }
    }

    public static void imprimeStartups(List<Startup>startups){
        if (!startups.isEmpty()) {
            System.out.println("Startups participantes");
        }
        for (int i = 0; i < startups.size(); i++) {
            System.out.println(i+1 + " - " + startups.get(i).getNome());
        }
    }

    public static void resetaPontos(List<Startup>startups) {
        for (Startup startup : startups) {
            startup.setPontos(PONTOS);
        }
    }
}
