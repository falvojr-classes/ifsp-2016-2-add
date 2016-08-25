package br.edu.ifsp.add.util;

/**
 * Exemplo de implementação do padrão de projeto Singleton Eager (apressado).
 * 
 * @author falvojr
 */
public class SingletonApressado {

    /**
     * Constante que garante a criação da instância de modo "apressado".
     */
    private static final SingletonApressado INSTANCIA = new SingletonApressado();
    
    /**
     * Construtor privado, com o objetivo de evitar criações externas. 
     */
    private SingletonApressado() {
        System.out.println("Criou!"); 
    }
    
    public static SingletonApressado getInstancia() {
        return SingletonApressado.INSTANCIA;
    }
    
    public void teste() {
        System.out.println("teste");
    }
}






