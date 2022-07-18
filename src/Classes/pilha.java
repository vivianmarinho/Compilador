/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author vivia
 */
public class pilha {

    private static final int MAX = 1000;
    private String[] pilha = new String[MAX];
    private int top;

    pilha() {
        top = -1;
    }

    private boolean isEmpty() {
        return (top < 0);
    }

    public boolean push(String x) {
        if (top >= (MAX - 1)) {
            System.out.println("Estouro de Pilha!");
            return false;
        } else {
            pilha[++top] = x;
            return true;
        }
    }

    public String pop() {
        if (top < 0) {
            return "Pilha Vazia!";
        } else {
            String x = pilha[top--];
            return x;
        }
    }

    public String peek() {
        if (top < 0) {
            return "Pilha Vazia!";
        } else {
            return pilha[top];
        }
    }
}
