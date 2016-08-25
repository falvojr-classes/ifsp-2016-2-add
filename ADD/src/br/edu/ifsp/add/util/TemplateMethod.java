package br.edu.ifsp.add.util;

/**
 * Exemplo de implementação do padrão de projeto Template Method.
 * 
 * @author falvojr
 */
public abstract class TemplateMethod {
   
    public void metodoConcreto1() {
        System.out.println("metodoConcreto1");
    }
    
    public abstract void metodoAbstrato1();
    
    public abstract void metodoAbstrato2();
    
    public abstract void metodoAbstrato3();
}
