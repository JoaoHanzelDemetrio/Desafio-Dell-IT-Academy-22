package entities;

import service.HistoricoBatalhas;
import service.StartupService;
import service.Torneio;
import service.Utils;

import java.util.*;

public class Menu {


    public void menu() {
        Scanner sc = new Scanner(System.in);
        List<Startup> startups = new ArrayList<>();
        String opMenu;

        //Instanciei objetos para facilitar a apresentação
        Startup a = new Startup("Preto no Branco","Tecnologia. Simples assim.",2020);
        Startup b = new Startup("Pix Force","Life is short, let our machines do the watching.",2016);
        Startup c = new Startup("Privacy Tools", "Solução de Gestão de Privacidade e Proteção de Dados.", 2019);
        Startup d = new Startup("Sirros IoT", "Startup Mais Inovadora da América Latina em IoT", 2016);

        startups.add(a);
        startups.add(b);
        startups.add(c);
        startups.add(d);


        do{
            StartupService.imprimeStartups(startups);
            String menu = "\n\n - - - MENU INICIAL - - - " +
                    "\n[1]Cadastrar Startups" +
                    "\n[2]Começar torneio" +
                    "\n[3]Remover Startup" +
                    "\n[S]Sair" +
                    "\nDigite sua opção:";

            System.out.println(menu);
            opMenu= sc.nextLine().toUpperCase();

            switch (opMenu){
                case "1":
                   //Utils.limpaTela();
                    StartupService.cadastro(startups);
                    break;

                case "2":  // Verifica se tem o número mínimo de equipes, e se são pares
                    if (startups.size() >= 4 && startups.size()%2 == 0) {
                        Utils.limpaTela();
                        HistoricoBatalhas.limparHistorico();
                        Torneio.iniciaTorneio(startups);
                        StartupService.resetaPontos(startups);
                        break;
                    } else {
                        Utils.limpaTela();
                        System.out.println("É necessário um minímo de 4 Startups registradas e número pár!\n");
                    }
                    break;

                case "3":
                    if (!startups.isEmpty()){
                        StartupService.removeStartup(startups);
                    }else {
                        System.out.println("Não existe nenhuma Startup cadastrada.");
                    }
                    break;
                case "S":
                    System.out.println("Saindo....");
                    break;

                default: {
                    System.out.println("Opção invalida!\n\n");
                }
            }
        }while (!opMenu.equals("S"));
        sc.close();
    }

}
