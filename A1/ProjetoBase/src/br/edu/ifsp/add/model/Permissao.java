package br.edu.ifsp.add.model;

/**
 * Entidade que representa uma Permissão.
 *
 * @author Venilton FalvoJr
 *
 * @since 11/10/2016
 */
public class Permissao {

    private Long id;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
