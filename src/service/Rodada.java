package service;

import entities.Startup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Rodada {


    //Inicia a rodada
    public static List<Startup> rodada (List<Startup>startups, List<Startup> impares) {
        Scanner sc = new Scanner(System.in);
        List<List<Startup>> partidas = sorteiaPartidas(startups, impares);
        String opMenu;
        List<Startup> vencedores = new ArrayList<>();
        Startup vencedor;


        do {
            //Número da rodada atual
            if (startups.size() == 2) {
                System.out.println("RODADA FINAL!");
            }

            System.out.println("Batalhas - - - - - - - - - - -");
            for (int i = 0; i < partidas.size(); i++) {
                Batalha.imprimeConfronto(partidas.get(i), i);
            }

            String menu = "\nEscolha a batalha que deseja administrar! - - -" +
                    "\n[ 1 - " + partidas.size() + " ]Selecione o número da batalha" +
                    "\n[ S ]Sair" +
                    "\n\nDigite sua opção:";


            System.out.println(menu);

            //Usando toUpperCase para evitar erros de leitura de letras minúsculas
            opMenu = sc.nextLine().toUpperCase();


            // Não quis usar switch case, com varias opções vazias
            if (opMenu.matches("[1-" + partidas.size() + "]") && !partidas.isEmpty()) {

                // passa a string pra int para escolher a batalha pela posição do array
                // subtrai 1 aqui pois no menu a marcação começa com +1 a mais do valor do array
                int opBatalha = Integer.parseInt(opMenu) - 1;
                if (opBatalha < partidas.size()) {
                    vencedor = Batalha.batalha(partidas.get(opBatalha));
                    vencedores.add(vencedor);
                    partidas.remove(opBatalha);
                }

            } else if (opMenu.equals("S")) {
                System.out.println("Saindo....!");
            } else {
                System.out.println("\n\nOpção inválida!\n\n\n");
            }


        } while (!opMenu.equals("S") && !partidas.isEmpty());

        // Para ter a batalha com o que passou direto
        if (!impares.isEmpty()){
            vencedores.add(impares.get(0));
            impares.clear();
        }
        return vencedores;
    }




    //Função para criar uma lista da lista das equipes que irão se enfrentar
    public static List<List<Startup>> sorteiaPartidas(List<Startup> startups, List<Startup> impares) {

        List<List<Startup>> partidas = new ArrayList<>();

        //Embaralha o array para depois separar as equipes em pares para as batalhas
        Collections.shuffle(startups);

        for (int i = 0; i < startups.size(); i += 2) {
            if (i + 1 < startups.size()) {
                List<Startup> partida = new ArrayList<>();
                partida.add(startups.get(i));
                partida.add(startups.get(i + 1));
                partidas.add(partida);
            } else {
                Startup impar = startups.get(i);
                System.out.println(impar.getNome() + " avança automaticamente");
                //+30 da "vitória" por avançar automaticamente
                impar.setPontos(impar.getPontos() + 30);
                impares.add(impar);
            }
        }
        return partidas;
    }

}
