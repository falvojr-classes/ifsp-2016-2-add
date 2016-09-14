package br.edu.ifsp.add.util;

/**
 * Exemplo de implementação do padrão de projeto Singleton Lazy (Preguiçoso).
 *
 * @author falvojr
 */
public class SingletonPreguicoso {

    private static SingletonPreguicoso instancia;

    /**
     * Construtor privado, com o objetivo de evitar criações externas.
     */
    private SingletonPreguicoso() {
        System.out.println("Criou!");
    }

    /**
     * Verifica o estado do atributo, setando sua instância apenas quando a
     * mesma for realmente necessária (por demanda).
     *
     * @return instância de SingletonPreguicoso.
     */
    public static SingletonPreguicoso getInstancia() {
        if (SingletonPreguicoso.instancia == null) {
            SingletonPreguicoso.instancia = new SingletonPreguicoso();
        }
        return SingletonPreguicoso.instancia;
    }

    public void teste() {
        System.out.println("teste");
    }
}
