/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vivia
 */
public class analisadorLexico {

    public static List<Tokens> listaDeTokens = new ArrayList<>();
    List<String> gramatica = new ArrayList<>();

    private static int cont = 0;   // contar posicao
    private static char palavra[];
    private static String caminho;
    private static int inicioLexema;
    private static int contaLinha = 0;
    private static int linha;

    private static int ContarLinhas(String caminho) throws FileNotFoundException, IOException {
        LineNumberReader contLinha = new LineNumberReader(new InputStreamReader(new FileInputStream(caminho)));
        String nextLine;
        int i = 0;

        while ((nextLine = contLinha.readLine()) != null) {
            if (nextLine == null) {
                break;
            }
            i++;
        }
        return i;
    }

    public void LerArquivo(String nome) throws FileNotFoundException, IOException {

        caminho = nome;
        linha = ContarLinhas(caminho);

        Scanner arq = new Scanner(new FileReader(nome));

        for (int i = 0; linha != i; i++) {
            gramatica.add(arq.nextLine().concat("\0"));
            System.out.println(gramatica.get(i));

        }

        IniciarPalavra();
    }

    private void IniciarPalavra() {
        if (contaLinha < gramatica.size()) {
            cont = 0;
            palavra = gramatica.get(contaLinha).toCharArray();
            contaLinha++;
        }
        if (palavra[0] == '\0') {
            while (linha > contaLinha) {
                IniciarPalavra();
            }
        } else {
            Q0();
        }
    }

    public void Q0() {

        if (QEspaco(palavra[cont])) {
            cont++;
            while ((palavra[cont] == ' ') || palavra[cont] == ' ') {
                if (palavra[cont] == ' ' || palavra[cont] == ' ') {
                    cont++;
                }
            }
        }
        if (palavra[cont] == 'e') {
            inicioLexema = cont;
            cont++;
            Q1();

        } else if (palavra[cont] == 's') {
            inicioLexema = cont;
            cont++;
            Q13();
        } else if (palavra[cont] == 'l') {
            inicioLexema = cont;
            cont++;
            Q16();
        } else if (palavra[cont] == 'i') {
            inicioLexema = cont;
            cont++;
            Q19();
        } else if (palavra[cont] == 'f') {
            inicioLexema = cont;
            cont++;
            Q24();

        } else if (palavra[cont] == '(') {
            inicioLexema = cont;

            Q26();
        } else if (palavra[cont] == ')') {
            inicioLexema = cont;

            Q27();
        } else if (palavra[cont] == '{') {
            inicioLexema = cont;

            Q28();
        } else if (palavra[cont] == '}') {
            inicioLexema = cont;

            Q29();
        } else if (palavra[cont] == '+') {
            inicioLexema = cont;

            Q30();
        } else if (palavra[cont] == '-') {
            inicioLexema = cont;

            Q31();
        } else if (palavra[cont] == '/') {
            inicioLexema = cont;

            Q32();
        } else if (palavra[cont] == '*') {
            inicioLexema = cont;

            Q33();
        } else if (palavra[cont] == '>') {
            inicioLexema = cont;

            Q34();
        } else if (palavra[cont] == '=') {
            inicioLexema = cont;

            Q35();

        } else if (palavra[cont] == ';') {
            inicioLexema = cont;

            Q36();

        } else if (Letras(palavra[cont])) {
            inicioLexema = cont;

            QVariaveis();
        }
        if ((palavra.length > (cont + 1) && cont > 0)) {
            if (Digitos(palavra[cont])) {
                if (Letras(palavra[cont + 1])) {
                    inicioLexema = cont;

                    QVariaveis();
                }
                else if (QEspaco(palavra[cont + 1]) || QEspaco(palavra[cont - 1]) || Operacoes(palavra[cont + 1]) || Operacoes(palavra[cont - 1])) {
                    inicioLexema = cont;
                    QInteiros();
                }
            }
        }
    }

    private void Q1() {
        if (palavra[cont] == 's') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q2();
                }
            }

        } else if (palavra[cont] == 'n') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q7();
                }

            }

        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q2() {
        if (palavra[cont] == 'c') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q3();
                }

            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q3() {
        if (palavra[cont] == 'r') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q4();
                }

            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q4() {
        if (palavra[cont] == 'e') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q5();
                }

            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q5() {
        if (palavra[cont] == 'v') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q6();
                }

            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q6() {
        if (palavra[cont] == 'a') {
            if (palavra.length > cont + 1) {
                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;
                        } else {
                            break;
                        }
                    }

                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {

                    IniciarPalavra();
                } else {
                    QEscreva();
                }

            }
        }

    }

    private void QEscreva() {
        String tokens = "escreva";
        String lexema = "";

        int aux = inicioLexema;

        while (aux <= cont) {
            if (palavra[aux] == ' ') {
                aux++;
            } else {
                lexema += palavra[aux];
                aux++;
            }

        }
        ImprimirTokens(tokens, lexema);
    }

    private void Q7() {
        if (palavra[cont] == 'q') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q8();
                }
            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q8() {
        if (palavra[cont] == 'u') {
            if (palavra.length > (cont + 1)) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q9();
                }
            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q9() {
        if (palavra[cont] == 'a') {
            if (palavra.length > (cont + 1)) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q10();
                }
            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q10() {
        if (palavra[cont] == 'n') {
            if (palavra.length > (cont + 1)) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q11();
                }
            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q11() {
        if (palavra[cont] == 't') {
            if (palavra.length > (cont + 1)) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q12();
                }
            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q12() {
        if (palavra[cont] == 'o') {
            if (palavra.length > (cont + 1)) {
                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;

                        } else {
                            break;
                        }
                    }
                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {

                    IniciarPalavra();
                } else {
                    QEnquanto();
                }

            }
        }

    }

    private void QEnquanto() {
        String tokens = "enquanto";
        String lexema = "";

        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q13() {
        if (palavra[cont] == 'e') {
            if (palavra.length > cont + 1) {

                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;
                        } else {
                            break;
                        }
                    }
                }
                if (palavra[aux] == '(') {
                    QSe();
                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {
                    IniciarPalavra();
                }
                if (palavra[aux] == 'n') {
                    cont = aux;
                    if (palavra.length > cont + 1) {

                        if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                            cont--;
                            QVariaveis();
                        } else {
                            cont++;
                            Q14();
                        }
                    }
                }

            }

        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void QSe() {
        String tokens = "se";
        String lexema = "";

        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }
        ImprimirTokens(tokens, lexema);
    }

    private void Q14() {
        if (palavra[cont] == 'a') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q15();
                }

            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q15() {
        if (palavra[cont] == 'o') {
            if (palavra.length > cont + 1) {
                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;
                        } else {
                            break;
                        }
                    }
                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {
                    IniciarPalavra();
                } else {
                    QSenao();
                }

            }
        }

    }

    private void QSenao() {
        String tokens = "senao";
        String lexema = " ";

        int aux = inicioLexema;

        while (aux <= cont) {
            if (palavra[aux] == ' ') {
                aux++;
            } else {
                lexema += palavra[aux];
                aux++;
            }

        }
        ImprimirTokens(tokens, lexema);
    }

    private void Q16() {
        if (palavra[cont] == 'e') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q17();
                }

            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q17() {
        if (palavra[cont] == 'i') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q18();
                }

            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q18() {
        if (palavra[cont] == 'a') {
            if (palavra.length > cont + 1) {
                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;
                        } else {
                            break;
                        }
                    }
                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {
                    IniciarPalavra();
                } else {
                    QLeia();
                }
            }
        }
    }

    private void QLeia() {
        String tokens = "leia";
        String lexema = "";

        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }
        ImprimirTokens(tokens, lexema);
    }

    private void Q19() {
        if (palavra[cont] == 'n') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q20();
                }

            }

        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q20() {

        if (palavra[cont] == 't') {
            if (palavra.length > cont + 1) {
                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;

                        } else {
                            break;
                        }
                    }
                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {

                    IniciarPalavra();
                } else {

                    QVar();
                }
            }
        }
        if (palavra[cont] == 'i') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q21();
                }
            }

        }
    }

    private void Q21() {
        if (palavra[cont] == 'c') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q22();
                }
            }

        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }

    }

    private void Q22() {
        if (palavra[cont] == 'i') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q23();
                }
            }

        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }

    }

    private void Q23() {
        if (palavra[cont] == 'o') {
            if (palavra.length > cont + 1) {
                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;
                        } else {
                            break;
                        }
                    }
                } else {
                    QInicio();
                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {
                    IniciarPalavra();
                }

            }
        }
    }

    private void QInicio() {
        String tokens = "inicio";
        String lexema = "";

        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }
        ImprimirTokens(tokens, lexema);
    }

    private void Q24() {
        if (palavra[cont] == 'i') {
            if (palavra.length > cont + 1) {
                if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1]) || Digitos(palavra[cont + 1])) {
                    cont--;
                    QVariaveis();
                } else {
                    cont++;
                    Q25();
                }
            }
        } else if (QEspaco(palavra[cont + 1]) || Operacoes(palavra[cont + 1])) {
            cont--;
            QVariaveis();
        }
    }

    private void Q25() {
        if (palavra[cont] == 'm') {
            if (palavra.length > cont + 1) {
                int aux = (cont + 1);

                if (QEspaco(palavra[cont + 1])) {
                    aux++;
                    while ((palavra[aux]) == ' ') {
                        if ((palavra[aux]) == ' ') {
                            aux++;
                        } else {
                            break;
                        }
                    }
                } else {

                    QFim();
                }
                if (palavra[aux] == ';' || palavra[aux] == '=' || palavra[aux] == '\0') {
                    IniciarPalavra();
                }

            }
        }
    }

    private void QFim() {
        String tokens = "fim";
        String lexema = "";

        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }
        ImprimirTokens(tokens, lexema);
    }

    private void Q26() {
        String tokens = "abrePar";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q27() {
        String tokens = "fechaPar";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);

    }

    private void Q28() {
        String tokens = "abreChaves";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q29() {
        String tokens = "fechaChaves";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q30() {
        String tokens = "soma";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q31() {
        String tokens = "subtracao";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q32() {
        String tokens = "divisao";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q33() {
        String tokens = "multiplicacao";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private boolean Digitos(char c) {

        return (c >= '0' && c <= '9');
    }

    private boolean Letras(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private void Q34() {
        String tokens = "maior";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q35() {
        String tokens = "igual";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void Q36() {
        String tokens = "final";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void QVar() {
        String tokens = "var";
        String lexema = "";
        int aux = inicioLexema;

        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private boolean Operacoes(char c) {
        return c == '>' || c == '=' || c == '(' || c == ')' || c == '{' || c == '}' || c == ';' || c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean QEspaco(char c) {
        return (c == ' ' || c == '\n' || c == '\t' || c == '\r');
    }

    private void QVariaveis() {   // VARIAVEIS 

        while (Letras(palavra[cont]) || Digitos(palavra[cont])) {

            if (palavra.length > cont + 1) {

                if (!Operacoes(palavra[cont + 1]) && !QEspaco(palavra[cont + 1])) {
                    if (palavra[cont] > cont + 1) {
                        cont++;

                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        //RECONHECIMENTO DE TOKENS
        String tokens = "variavel";
        String lexema = "";

        int aux = inicioLexema;
        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }

        ImprimirTokens(tokens, lexema);
    }

    private void QInteiros() {   // VARIAVEIS 

        while (Digitos(palavra[cont])) {
            if (palavra.length > cont + 1) {

                if (!Operacoes(palavra[cont + 1]) && !QEspaco(palavra[cont + 1])) {
                    if (palavra[cont] > cont + 1) {
                        cont++;

                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        String tokens = "int";
        String lexema = "";

        int aux = inicioLexema;
        while (aux <= cont) {
            lexema += palavra[aux];
            aux++;
        }
        ImprimirTokens(tokens, lexema);
    }

    public void ImprimirTokens(String tokens, String lexemas) {

        Tokens novoToken = new Tokens();

        novoToken.setTokens("");
        novoToken.setLexemas("");
        novoToken.setLinha(0);
        novoToken.setColuna(0);

        novoToken.setTokens(tokens);
        novoToken.setLexemas(lexemas);
        novoToken.setLinha(contaLinha);
        novoToken.setColuna(inicioLexema);
        listaDeTokens.add(novoToken);

        if (palavra[cont] == '\0') {
            IniciarPalavra();
        } else {
            cont++;
            Q0();
        }

    }

    public void ImprimirTabela() {
        int aux = listaDeTokens.size();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Tokens.txt", false);
        } catch (IOException ex) {
            Logger.getLogger(analisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter gravarArq = new PrintWriter(fileWriter);

        for (int i = 0; aux > i; i++) {
            System.out.println(listaDeTokens.get(i));
            gravarArq.println(listaDeTokens.get(i).getTokens() + " " + listaDeTokens.get(i).getLexemas() + " " + listaDeTokens.get(i).getLinha() + " " + listaDeTokens.get(i).getColuna());
            gravarArq.flush();
        }
    }

    //for (int i = 0; aux > i; i++) {
    // System.out.println(listaDeTokens.get(i));
    // gravarArq.printf("%s\n",listaDeTokens.get(i));
    //}
    //}
}
