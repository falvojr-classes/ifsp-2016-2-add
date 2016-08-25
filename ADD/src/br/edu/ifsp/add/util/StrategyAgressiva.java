package br.edu.ifsp.add.util;

/**
 * Exemplo do uso do padrão de projeto Strategy.
 * Estratégia agressiva.
 * 
 * @author falvojr
 */
public class StrategyAgressiva implements Strategy {

    @Override
    public void movimentar() {
        System.out.println("Movimento agressivo!");
    }
    
}
