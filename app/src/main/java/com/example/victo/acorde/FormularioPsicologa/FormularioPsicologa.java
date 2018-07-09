package com.example.victo.acorde.FormularioPsicologa;

import java.io.Serializable;

public class FormularioPsicologa implements Serializable {

    private Long id;
    private String dataAtendimento;
    private String idadeAssistido;
    private String nomeAssistido;
    private int categoriaAtendimento;
    private int individualTipo;
    private int tipoEmocionalAspectos;
    private int tipoAcupunturaAspectos;
    private int temaGrupal;
    private int encaminhamentoAcorde;
    private int encaminhamentoExterno;
    private int atendimentoFamiliaCuidadores;
    private int visitasDomiciliares;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataAtendimento() { return dataAtendimento; }

    public void setDataAtendimento(String data) {this.dataAtendimento = data;}

    public String getIdadeAssistido() {
        return idadeAssistido;
    }

    public void setIdadeAssistido(String idadeAssistido) {
        this.idadeAssistido = idadeAssistido;
    }

    public String getNomeAssistido() {
        return nomeAssistido;
    }

    public void setNomeAssistido(String nomeAssistido) { this.nomeAssistido = nomeAssistido; }

    public int getCategoriaAtendimento() {
        return categoriaAtendimento;
    }

    public void setCategoriaAtendimento(int categoriaAtendimento) {
        this.categoriaAtendimento = categoriaAtendimento;
    }

    public int getIndividualTipo() {
        return individualTipo;
    }

    public void setIndividualTipo(int individualTipo) {
        this.individualTipo = individualTipo;
    }

    public int getTipoEmocionalAspectos() {
        return tipoEmocionalAspectos;
    }

    public void setTipoEmocionalAspectos(int tipoEmocionalAspectos) {
        this.tipoEmocionalAspectos = tipoEmocionalAspectos;
    }

    public int getTipoAcupunturaAspectos() {
        return tipoAcupunturaAspectos;
    }

    public void setTipoAcupunturaAspectos(int tipoAcupunturaAspectos) {
        this.tipoAcupunturaAspectos = tipoAcupunturaAspectos;
    }

    public int getTemaGrupal() {
        return temaGrupal;
    }

    public void setTemaGrupal(int temaGrupal) {
        this.temaGrupal = temaGrupal;
    }

    public int getEncaminhamentoAcorde() {
        return encaminhamentoAcorde;
    }

    public void setEncaminhamentoAcorde(int encaminhamentoAcorde) {
        this.encaminhamentoAcorde = encaminhamentoAcorde;
    }

    public int getEncaminhamentoExterno() {
        return encaminhamentoExterno;
    }

    public void setEncaminhamentoExterno(int encaminhamentoExterno) {
        this.encaminhamentoExterno = encaminhamentoExterno;
    }

    public int getAtendimentoFamiliaCuidadores() {
        return atendimentoFamiliaCuidadores;
    }

    public void setAtendimentoFamiliaCuidadores(int atendimentoFamiliaCuidadores) {
        this.atendimentoFamiliaCuidadores = atendimentoFamiliaCuidadores;
    }

    public int getVisitasDomiciliares() {
        return visitasDomiciliares;
    }

    public void setVisitasDomiciliares(int visitasDomiciliares) {
        this.visitasDomiciliares = visitasDomiciliares;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}