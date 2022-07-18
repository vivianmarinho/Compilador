/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import arquivo.Posfixa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivia
 */
public class Intermediario {

    List<Tokens> listaTokens = new ArrayList();
    List<String> logIntermediario = new ArrayList();
    public static List<String> codigoIntermediario = new ArrayList();
    public static List<String> tabelaDeVariaveis = new ArrayList();

    String formula = "";
    private char FITA[];

    public void listarTokens() {

        System.out.println("==============================================");

        for (int i = 0; i < analisadorLexico.listaDeTokens.size(); i++) {
            listaTokens.add(analisadorLexico.listaDeTokens.get(i));

        }
    }

    public void codigoIntermediario() {
        listarTokens();

        for (int p = 0; p < listaTokens.size(); p++) {
            if (listaTokens.get(p).getTokens().equals("var")) {

                codigoIntermediario.add("variavel " + listaTokens.get(p + 1).getLexemas());
                tabelaDeVariaveis.add(listaTokens.get(p + 1).getLexemas());

                logIntermediario.add("Reconhecido a variavel " + listaTokens.get(p + 2).getLexemas());
            }
        }

        for (int i = 0; i < listaTokens.size(); i++) {

            if (listaTokens.get(i).getTokens().equals("escreva")) {
                codigoIntermediario.add("write " + listaTokens.get(i + 2).getLexemas());
                logIntermediario.add("Reconhecido o comando de leitura da variavel " + listaTokens.get(i + 2).getLexemas());

            } else if (listaTokens.get(i).getTokens().equals("leia")) {
                codigoIntermediario.add("read " + listaTokens.get(i + 2).getLexemas());
                logIntermediario.add("Reconhecido o comando de impressão da variavel " + listaTokens.get(i + 2).getLexemas());

            } else if (listaTokens.get(i).getTokens().equals("enquanto")) {

                codigoIntermediario.add("while");
                logIntermediario.add("Reconhecido o comando Enquanto ");

                for (int x = i + 2; x < listaTokens.size(); x++) {

                    if (!listaTokens.get(x).getTokens().equals("fechaPar")) {
                        formula += listaTokens.get(x).getLexemas() + " ";
                    } else {
                        break;
                    }
                }

                formula = Posfixa.conversao(formula);

                codigoIntermediario.add(formula);
                logIntermediario.add("Reconhecido a formula condicional " + formula);
                formula = "";
            } else if (listaTokens.get(i).getTokens().equals("se")) {

                codigoIntermediario.add("if ");
                logIntermediario.add("Reconhecido o comando Se ");

                for (int y = i + 2; y < listaTokens.size(); y++) {

                    if (!listaTokens.get(y).getTokens().equals("fechaPar")) {
                        formula += listaTokens.get(y).getLexemas() + " ";
                    } else {
                        break;
                    }
                }

                formula = Posfixa.conversao(formula);

                codigoIntermediario.add(formula);
                logIntermediario.add("Reconhecido a formula condicional " + formula);
                formula = "";

            } else if (listaTokens.get(i).getTokens().equals("senao")) {

                codigoIntermediario.add("else ");
                logIntermediario.add("Reconhecido o comando Senao ");

            } else if (listaTokens.get(i).getTokens().equals("fechaChaves")) {

                codigoIntermediario.add("fimEstrutura ");
                logIntermediario.add("Reconhecido final de estrutura condicional");

            } else if (listaTokens.get(i).getTokens().equals("igual")) {
                for (int k = i; k < listaTokens.size(); k++) {
                    if (!listaTokens.get(i).getTokens().equals("final")) {
                        if (listaTokens.get(k - 1).getLexemas().equals(";")) {
                            break;
                        }
                        formula += listaTokens.get(k - 1).getLexemas() + " ";
                    }
                }
                formula = Posfixa.conversao(formula);

                codigoIntermediario.add(formula);
                logIntermediario.add("Reconhecido a formula aritimetica " + listaTokens.get(i - 1).getLexemas() + " " + listaTokens.get(i).getLexemas() + " " + formula);
                formula = "";
            }
        }
    }

    public void imprimirCodigoIntermediario() {
        for (int i = 0; i < codigoIntermediario.size(); i++) {
            System.out.println("\n" + codigoIntermediario.get(i));
        }
    }

}
