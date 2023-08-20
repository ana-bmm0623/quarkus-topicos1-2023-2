package br.unitins.topicos1.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Oculos extends PanacheEntity{
    private String referencia;
    private String cor;
    private String tamanho;

    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

     public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

     public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}
