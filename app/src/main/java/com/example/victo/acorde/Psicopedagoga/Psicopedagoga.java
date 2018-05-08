package com.example.victo.acorde.Psicopedagoga;

import java.io.Serializable;
import java.util.Date;

public class Psicopedagoga implements Serializable{

    private Long id;
    private Date data;
    private String tipoAtendimento;
    private String motivo;
    private String impressoes;
    private String encaminhamento;
    private String profissional;
    private String nome;
    private Date dataNascimento;
    private String diagnostico;
    private String raciocinioLogico;
    private String comunicacao;
    private String compreensaoComplexas;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getImpressoes() {
        return impressoes;
    }

    public void setImpressoes(String impressoes) {
        this.impressoes = impressoes;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getRaciocinioLogico() {
        return raciocinioLogico;
    }

    public void setRaciocinioLogico(String raciocinioLogico) {
        this.raciocinioLogico = raciocinioLogico;
    }

    public String getComunicacao() {
        return comunicacao;
    }

    public void setComunicacao(String comunicacao) {
        this.comunicacao = comunicacao;
    }

    public String getCompreensaoComplexas() {
        return compreensaoComplexas;
    }

    public void setCompreensaoComplexas(String compreensaoComplexas) {
        this.compreensaoComplexas = compreensaoComplexas;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
