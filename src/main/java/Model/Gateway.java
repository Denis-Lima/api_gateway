package Model;

import javax.persistence.*;

/**
 * Author: Denis Lima
 */

@Entity
@Table(name = "gateway")
public class Gateway {
    @Id
    private Long id;

    @Column(name = "operacao")
    private String operacao;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "porta")
    private int porta;

    @Column(name = "rota")
    private String rota;

    // CONSTRUCTOR
    public Gateway() {}

    // GETTERS AND SETTERS
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperacao() {
        return this.operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getPorta() {
        return this.porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getRota() {
        return this.rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getOperacao() + " " + this.getUrl();
    }

    public String getUrl() {
        return "http://" + this.getEndereco() + ":" + this.getPorta() + this.getRota();
    }
}
