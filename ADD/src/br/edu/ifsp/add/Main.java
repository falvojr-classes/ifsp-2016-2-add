package br.edu.ifsp.add;

import br.edu.ifsp.add.util.Robo;
import br.edu.ifsp.add.util.SingletonPreguicoso;
import br.edu.ifsp.add.util.StrategyAgressiva;
import br.edu.ifsp.add.util.StrategyDefensiva;

/**
 * Classe de testes.
 * 
 * @author falvojr
 */
public class Main {
    
    public static void main(String[] args) {
        
        //SingletonPreguicoso.getInstancia().teste();
        //OU
        //SingletonPreguicoso singleton = SingletonPreguicoso.getInstancia();
        //singleton.teste();
        
        Robo robo = new Robo();
        robo.movimentar();
        robo.setStrategy(new StrategyAgressiva());
        robo.movimentar();
        
        robo.setStrategy(new StrategyDefensiva());
        robo.movimentar();
        robo.movimentar();
        robo.movimentar();
    }
    
}
