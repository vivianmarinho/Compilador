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
public class Tokens {
    
    private String tokens;
    private String lexemas;
    private int linha;
    private int coluna;

    @Override
    public String toString() {
        return "Tokens{" + "tokens=" + tokens + ", lexemas=" + lexemas + ", linha=" + linha + ", coluna=" + coluna + '}';
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }

    public String getLexemas() {
        return lexemas;
    }

    public void setLexemas(String lexemas) {
        this.lexemas = lexemas;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
