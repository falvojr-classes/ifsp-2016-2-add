package br.edu.ifsp.add.util;

/**
 * Exemplo do uso do padrão de projeto Strategy.
 * 
 * @author falvojr
 */
public class Robo {
    
    private Strategy strategy = new StrategyNormal();

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy estrategia) {
        this.strategy = estrategia;
    }
    
    public void movimentar() {
        this.strategy.movimentar();
    }
}
