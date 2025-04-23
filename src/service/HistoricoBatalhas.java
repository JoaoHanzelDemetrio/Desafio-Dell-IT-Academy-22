package service;

import java.util.ArrayList;
import java.util.List;

public class HistoricoBatalhas {

    private static final List<String> historico = new ArrayList<>();




    //Armazena detalhes da batalha no array em uma string
    public static void adicionarRegistro(String registro) {
        historico.add(registro);
    }

    public static void limparHistorico() {
        historico.clear();
    }

    public static void imprimeHistorico(){
        Utils.limpaTela();
        System.out.println("--------------HISTÓRICO DE BATALHAS DO TORNEIO---------------------------");
        for (String registro : historico) {
            System.out.println(registro);
        }
        System.out.println("-------------------------------------------------------------------------\n\n");
    }

}
