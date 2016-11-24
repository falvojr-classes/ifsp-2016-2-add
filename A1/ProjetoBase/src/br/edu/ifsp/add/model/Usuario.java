package br.edu.ifsp.add.model;

/**
 * Entidade que representa um Usuário.
 *
 * @author Venilton FalvoJr
 *
 * @since 11/10/2016
 */
public class Usuario {

    private Long id;
    private String email;
    private String senha;
    private boolean ativo = true;
    private Permissao permissao;
    /**
     * Atributo transiente, ou seja, não será persistido.
     */
    private String confirmacaoSenha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }

}
