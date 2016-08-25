package br.edu.ifsp.add.util;

/**
 * Exemplo do uso do padrão de projeto Strategy.
 * Estratégia defensiva.
 * 
 * @author falvojr
 */
public class StrategyDefensiva implements Strategy {

    @Override
    public void movimentar() {
        System.out.println("Movimento defensivo!");
    }
    
}
