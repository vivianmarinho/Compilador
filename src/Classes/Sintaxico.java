/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vivia
 */
public class Sintaxico {

    private List<Tokens> listaTokens = new ArrayList();
    private List<String> pilha = new ArrayList();
    List<String> arquivos = new ArrayList();

    public int analisadorSintatico() {

        listarTokens();
        empilhar("$");
        empilhar("PROGRAMA");

        while (!pilha.isEmpty() && !listaTokens.isEmpty()) {
            if (pilha.get(0).equals(listaTokens.get(0).getTokens())) {
                desempilhar(pilha.get(0));
                listaTokens.remove(0);
            } else {
                int aux = 0;

                aux = tabelaSintatica(pilha.get(0), listaTokens.get(0).getTokens());
                if (aux == -1) {
                    System.out.println("\n\nERRO Sintatico: " + listaTokens.get(0).getLexemas() + " Linha: " + listaTokens.get(0).getLinha() + " Coluna: " + listaTokens.get(0).getColuna() + "\n\n");
                    break;
                } else {
                    criacaoSintaxica(aux);
                }
            }
        }
        return 0;
    }

    public void imprimirLog() {
        for (int i = 0; i < arquivos.size(); i++) {
            System.out.println(arquivos.get(i));
            System.out.println("\n======================================================\n");
        }
    }

    private void empilhar(String elemento) {
        pilha.add(0, elemento);
        arquivos.add("Elemento empilhado: " + elemento);
    }

    private void desempilhar(String nome) {
        pilha.remove(0);
        arquivos.add("Elemento desempilhado: " + nome);
    }

    public void listarTokens() {

        System.out.println("==============================================\n\n");

        for (int i = 0; i < analisadorLexico.listaDeTokens.size(); i++) {
            listaTokens.add(analisadorLexico.listaDeTokens.get(i));
        }

        Tokens terminal = new Tokens();
        terminal.setTokens("$");
        terminal.setLexemas("$");
        terminal.setLinha(0);
        terminal.setColuna(0);
        listaTokens.add(terminal);

    }

    private int tabelaSintatica(String linha, String coluna) {

        //inicio programa
        if (linha.equals("PROGRAMA") && coluna.equals("inicio")) {
            return 0;
        } // inicio lista de comandos
        else if (linha.equals("LISTA_COMANDOS") && coluna.equals("variavel")) {
            return 1;

        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("int")) {
            return 1;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("var")) {
            return 1;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("escreva")) {
            return 1;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("leia")) {
            return 1;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("se")) {
            return 1;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("enquanto")) {
            return 1;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("fim")) {
            return 2;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("fechaPar")) {
            return 2;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("fechaChaves")) {
            return 2;

        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("abreChaves")) {
            return 2;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("abrePar")) {
            return 2;
        } else if (linha.equals("LISTA_COMANDOS") && coluna.equals("final")) {
            return 2;
        }

        // inicio comando
        if (linha.equals("COMANDOS") && coluna.equals("var")) {
            return 5;
        } else if (linha.equals("COMANDOS") && coluna.equals("variavel")) {
            return 6;
        } else if (linha.equals("COMANDOS") && coluna.equals("int")) {
            return 6;
        } else if (linha.equals("COMANDOS") && coluna.equals("escreva")) {
            return 10;
        } else if (linha.equals("COMANDOS") && coluna.equals("leia")) {
            return 11;
        } else if (linha.equals("COMANDOS") && coluna.equals("se")) {
            return 15;
        } else if (linha.equals("COMANDOS") && coluna.equals("enquanto")) {
            return 18;
        }

        // inicio comando operacoes
        if (linha.equals("OPERACOES") && coluna.equals("soma")) {
            return 23;
        } else if (linha.equals("OPERACOES") && coluna.equals("subtracao")) {
            return 24;
        } else if (linha.equals("OPERACOES") && coluna.equals("divisao")) {
            return 25;
        } else if (linha.equals("OPERACOES") && coluna.equals("multiplicacao")) {
            return 26;
        }

        // inicio operador logico
        if (linha.equals("OPERADOR_LOGICA") && coluna.equals("maior")) {
            return 27;
        } else if (linha.equals("OPERADOR_LOGICA") && coluna.equals("igual")) {
            return 28;
        } else if (linha.equals("OPERADOR_LOGICA") && coluna.equals("maiorIgual")) {
            return 29;
        }

        // inicio do tipo
        if (linha.equals("TIPO") && coluna.equals("variavel")) {
            return 4;
        } else if (linha.equals("TIPO") && coluna.equals("int")) {
            return 3;
        }

        // inicio simbolos
        if (linha.equals("SIMBOLOS") && coluna.equals("final")) {
            return 30;
        } else if (linha.equals("SIMBOLOS") && coluna.equals("abrePar")) {
            return 31;
        } else if (linha.equals("SIMBOLOS") && coluna.equals("fechaPar")) {
            return 32;
        } else if (linha.equals("SIMBOLOS") && coluna.equals("abreChaves")) {
            return 33;
        } else if (linha.equals("SIMBOLOS") && coluna.equals("fechaChaves")) {
            return 34;
        }

        //inicio parametros
        if (linha.equals("PARAMETROS") && coluna.equals("igual")) {
            return 7;
        } else if (linha.equals("PARAMETROS") && coluna.equals("final")) {
            return 9;
        } else if (linha.equals("PARAMETROS") && coluna.equals("abrePar")) {
            return 9;
        } else if (linha.equals("PARAMETROS") && coluna.equals("fechaPar")) {
            return 9;
        } else if (linha.equals("PARAMETROS") && coluna.equals("abreChaves")) {
            return 9;
        } else if (linha.equals("PARAMETROS") && coluna.equals("fechaChaves")) {
            return 9;
        }

        //inicio expressoes
        if (linha.equals("EXPRESSOES") && coluna.equals("variavel")) {
            return 19;
        } else if (linha.equals("EXPRESSOES") && coluna.equals("int")) {
            return 19;
        } else if (linha.equals("EXPRESSOES") && coluna.equals("abreChaves")) {
            return 20;
        }else if (linha.equals("EXPRESSOES") && coluna.equals("fechaChaves")) {
            return 20;
        }else if (linha.equals("EXPRESSOES") && coluna.equals("abrePar")) {
            return 20;
        }else if (linha.equals("EXPRESSOES") && coluna.equals("abrePar")) {
            return 20;
        }else if (linha.equals("EXPRESSOES") && coluna.equals("final")) {
            return 20;
        }

        // inicio lista de operacoes 
        if (linha.equals("LISTA_OPERACOES") && coluna.equals("soma")) {
            return 21;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("subtracao")) {
            return 21;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("divisao")) {
            return 21;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("multiplicacao")) {
            return 21;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("maior")) {
            return 22;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("igual")) {
            return 22;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("maiorIgual")) {
            return 22;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("final")) {
            return 22;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("fechaPar")) {
            return 22;
        } else if (linha.equals("LISTA_OPERACOES") && coluna.equals("fechaChaves")) {
            return 22;
        }else if (linha.equals("EXPRESSOES") && coluna.equals("abreChaves")) {
            return 22;
        }else if (linha.equals("EXPRESSOES") && coluna.equals("abrePar")) {
            return 22;
        }

        // inicio senao
        if (linha.equals("SENAO") && coluna.equals("fim")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("variavel")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("int")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("var")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("escreva")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("leia")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("se")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("senao")) {
            return 16;
        } else if (linha.equals("SENAO") && coluna.equals("enquanto")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("fechaPar")) {
            return 17;
        } else if (linha.equals("SENAO") && coluna.equals("fechaChaves")) {
            return 17;
        }else if (linha.equals("SENAO") && coluna.equals("abreChaves")) {
            return 17;
        }else if (linha.equals("SENAO") && coluna.equals("abrePar")) {
            return 17;
        }else if (linha.equals("SENAO") && coluna.equals("final")) {
            return 17;
        }

        //inicio calcular 
        if (linha.equals("CALCULAR") && coluna.equals("abrePar")) {
            return 14;
        }else if (linha.equals("CALCULAR") && coluna.equals("abreChaves")) {
            return 14;
        }else if (linha.equals("CALCULAR") && coluna.equals("fechaChaves")) {
            return 14;
        }else if (linha.equals("CALCULAR") && coluna.equals("fechaPar")) {
            return 14;
        }else if (linha.equals("CALCULAR") && coluna.equals("final")) {
            return 14;
        }

        //inicio operador
        if (linha.equals("OPERADOR") && coluna.equals("variavel")) {
            return 8;
        } else if (linha.equals("OPERADOR") && coluna.equals("int")) {
            return 8;
        } else if (linha.equals("OPERADOR") && coluna.equals("abreChaves")) {
            return 8;
        }else if (linha.equals("OPERADOR") && coluna.equals("fechaChaves")) {
            return 8;
        }else if (linha.equals("OPERADOR") && coluna.equals("abrePar")) {
            return 8;
        }else if (linha.equals("OPERADOR") && coluna.equals("fechaPar")) {
            return 8;
        }else if (linha.equals("OPERADOR") && coluna.equals("final")) {
            return 8;
        }

        //inicio tipo variavel 
        if (linha.equals("TIPO_VARIAVEL") && coluna.equals("variavel")) {
            return 13;
        } else if (linha.equals("TIPO_VARIAVEL") && coluna.equals("int")) {
            return 12;
        } else {
            return -1;

        }

    }

    private void criacaoSintaxica(int numero) {

        if (numero == 0) {

            desempilhar("PROGRAMA");

            empilhar("fim");
            empilhar("LISTA_COMANDOS");
            empilhar("inicio");

        } else if (numero == 1) {

            desempilhar("LISTA_COMANDOS");

            empilhar("LISTA_COMANDOS");
            empilhar("COMANDOS");

        } else if (numero == 2) {

            desempilhar("LISTA_COMANDOS");

            arquivos.add("Ê");

        } else if (numero == 3) {

            desempilhar("TIPO");

            empilhar("int");

        } else if (numero == 4) {

            desempilhar("TIPO");

            empilhar("variavel");

        } else if (numero == 5) {

            desempilhar("COMANDOS");

            empilhar("SIMBOLOS");
            empilhar("PARAMETROS");
            empilhar("variavel");
            empilhar("var");

        } else if (numero == 6) {

            desempilhar("COMANDOS");

            empilhar("SIMBOLOS");
            empilhar("PARAMETROS");
            empilhar("TIPO");

        } else if (numero == 7) {

            desempilhar("PARAMETROS");

            empilhar("OPERADOR");
            empilhar("igual");

        } else if (numero == 8) {

            desempilhar("OPERADOR");

            empilhar("EXPRESSOES");

        } else if (numero == 9) {

            desempilhar("PARAMETROS");

            arquivos.add("Ê");

        } else if (numero == 10) {

            desempilhar("COMANDOS");

            empilhar("SIMBOLOS");
            empilhar("SIMBOLOS");
            empilhar("TIPO_VARIAVEL");
            empilhar("SIMBOLOS");
            empilhar("escreva");

        } else if (numero == 11) {

            desempilhar("COMANDOS");

            empilhar("SIMBOLOS");
            empilhar("SIMBOLOS");
            empilhar("variavel");
            empilhar("SIMBOLOS");
            empilhar("leia");

        } else if (numero == 12) {

            desempilhar("TIPO_VARIAVEL");

            empilhar("int");

        } else if (numero == 13) {

            desempilhar("TIPO_VARIAVEL");

            empilhar("variavel");

        } else if (numero == 14) {

            desempilhar("CALCULAR");

            empilhar("SIMBOLOS");
            empilhar("EXPRESSOES");
            empilhar("OPERADOR_LOGICA");
            empilhar("EXPRESSOES");
            empilhar("SIMBOLOS");

        } else if (numero == 15) {

            desempilhar("COMANDOS");

            empilhar("SENAO");
            empilhar("SIMBOLOS");
            empilhar("LISTA_COMANDOS");
            empilhar("SIMBOLOS");
            empilhar("CALCULAR");
            empilhar("se");

        } else if (numero == 16) {

            desempilhar("SENAO");

            empilhar("SIMBOLOS");
            empilhar("LISTA_COMANDOS");
            empilhar("SIMBOLOS");
            empilhar("senao");

        } else if (numero == 17) {

            desempilhar("SENAO");

            arquivos.add("Ê");
        } else if (numero == 18) {

            desempilhar("COMANDOS");

            empilhar("SIMBOLOS");
            empilhar("LISTA_COMANDOS");
            empilhar("SIMBOLOS");
            empilhar("CALCULAR");
            empilhar("enquanto");

        } else if (numero == 19) {

            desempilhar("EXPRESSOES");

            empilhar("LISTA_OPERACOES");
            empilhar("TIPO");

        } else if (numero == 20) {

            desempilhar("EXPRESSOES");

            empilhar("LISTA_OPERACOES");
            empilhar("SIMBOLOS");
            empilhar("EXPRESSOES");
            empilhar("SIMBOLOS");

        } else if (numero == 21) {

            desempilhar("LISTA_OPERACOES");

            empilhar("EXPRESSOES");
            empilhar("OPERACOES");

        } else if (numero == 22) {

            desempilhar("LISTA_OPERACOES");

            arquivos.add("Ê");
        } else if (numero == 23) {

            desempilhar("OPERACOES");

            empilhar("soma");

        } else if (numero == 24) {

            desempilhar("OPERACOES");

            empilhar("subtracao");

        } else if (numero == 25) {

            desempilhar("OPERACOES");

            empilhar("divisao");

        } else if (numero == 26) {

            desempilhar("OPERACOES");

            empilhar("multiplicacao");

        } else if (numero == 27) {

            desempilhar("OPERADOR_LOGICA");

            empilhar("maior");

        } else if (numero == 28) {

            desempilhar("OPERADOR_LOGICA");

            empilhar("igual");

        } else if (numero == 29) {

            desempilhar("OPERADOR_LOGICA");

            empilhar("maiorIgual");

        } else if (numero == 30) {

            desempilhar("SIMBOLOS");

            empilhar("final");

        } else if (numero == 31) {

            desempilhar("SIMBOLOS");

            empilhar("abrePar");

        } else if (numero == 32) {

            desempilhar("SIMBOLOS");

            empilhar("fechaPar");

        } else if (numero == 33) {

            desempilhar("SIMBOLOS");

            empilhar("abreChaves");

        } else if (numero == 34) {

            desempilhar("SIMBOLOS");

            empilhar("fechaChaves");

        }
    }

}
