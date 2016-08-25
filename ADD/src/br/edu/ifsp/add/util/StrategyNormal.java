package br.edu.ifsp.add.util;

/**
 * Exemplo do uso do padrão de projeto Strategy.
 * Estratégia normal.
 *
 * @author falvojr
 */
public class StrategyNormal implements Strategy {

    @Override
    public void movimentar() {
        System.out.println("Movimento normal!");
    }
    
}
