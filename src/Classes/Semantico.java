/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivia
 */
public class Semantico {

    private List<Tokens> listaTokens = new ArrayList();

    private List<Tokens> variaveis = new ArrayList();

    public int AnalisadorSemantico() {
        
        int a1, a2, a3, a4;
        
        listarTokens();
        a1 = declaracaoVariavel();
        a2 = daclaracaoDuplaDeVariaveis();
        a3 = divisao();
        
        if (a1 == -1 || a2 == -1 || a3 == -1) {
            return -1;
        } else {
            return 0;
        }
    }

    private int divisao() {

        for (int i = 0; i < listaTokens.size(); i++) {
            if (listaTokens.get(i).getLexemas().equals("/")) {
                if (listaTokens.get(i + 1).getLexemas().equals("0")) {
                    System.err.println("ERRO SEMANTICO - impossivel dividir por ZERO" + " Linha:  " + listaTokens.get(i + 1).getLinha() + " Coluna: " + listaTokens.get(i + 1).getColuna());
                }
            }
        }
        return 0;
    }

    private int daclaracaoDuplaDeVariaveis() {

        for (int i = 0; i < variaveis.size(); i++) {

            for (int j = (i + 1); j < variaveis.size(); j++) {
                if (variaveis.get(i).getLexemas().equals(variaveis.get(j).getLexemas())) {
                    System.err.println("ERRO SEMANTICO - Variavel existente:  " + variaveis.get(j).getLexemas() + " Linha: " + variaveis.get(j).getLinha() + " Coluna: " + variaveis.get(j).getColuna());

                    break;
                }
            }
        }
        return 0;
    }

    private int declaracaoVariavel() {

        boolean d = false;
        for (int i = 0; i < listaTokens.size(); i++) {

            if (listaTokens.get(i).getTokens().equals("variavel") && listaTokens.get(i - 1).getTokens().equals("var")) {
                variaveis.add(listaTokens.get(i));
            }

        }
        for (int a = 0; a < listaTokens.size(); a++) {
            if (listaTokens.get(a).getTokens().equals("variavel")) {

                for (int k = 0; k < variaveis.size(); k++) {
                    d = listaTokens.get(a).getLexemas().equals(variaveis.get(k).getLexemas());
                    if (d == true) {
                        break;
                    }
                }
                if (d == true) {
                    continue;
                } else {

                    System.err.println("ERRO SEMANTICO - Variavel não declarada corretamente:  " + listaTokens.get(a).getLexemas() + " Linha: " + listaTokens.get(a).getLinha() + " Coluna: " + listaTokens.get(a).getColuna());
                    break;
                }

            }
        }
        return 0;

    }

    public void listarTokens() {

        System.out.println("==============================================");

        for (int i = 0; i < analisadorLexico.listaDeTokens.size(); i++) {
            listaTokens.add(analisadorLexico.listaDeTokens.get(i));

        }
    }

}
