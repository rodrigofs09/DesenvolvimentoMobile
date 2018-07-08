package com.example.victo.acorde.FormularioPsicopedagoga;

import java.io.Serializable;

public class FormularioPsicopedagoga implements Serializable {

    private Long id;
    private String dataAtendimento;
    //private String tipoAtendimento;
    private String nomeAssistido;
    private String motivoAtendimento;
    private String encaminhamento;
    //private String profissional;

    private int tipoAtendimento;
    private int aspectosTrabalhados;
    private int aspectosTrabalhadosAcupuntura;
    private int atividadesLudicasLeitura;
    private int atividadesCoordenacaoSurtiramEfeito;
    private int avaliacoesObtiveramResultadosPositivos;
    private int planejamentoSeguePercursoEsperado;
    private int materiaisSaoSuficientesParaAtividades;

    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataAtendimento() { return dataAtendimento; }

    public void setDataAtendimento(String data) {this.dataAtendimento = data;}

    public String getNomeAssistido() {
        return nomeAssistido;
    }

    public void setNomeAssistido(String nomeAssistido) {
        this.nomeAssistido = nomeAssistido;
    }

    public String getMotivoAtendimento() {
        return motivoAtendimento;
    }

    public void setMotivoAtendimento(String motivoAtendimento) {
        this.motivoAtendimento = motivoAtendimento;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public int getTipoAtendimento(){
        return this.tipoAtendimento;
    }

    public void setTipoAtendimento(int tipoAtendimento){
        this.tipoAtendimento = tipoAtendimento;
    }

    public int getAspectosTrabalhados(){
        return this.aspectosTrabalhados;
    }

    public void setAspectosTrabalhados(int aspectosTrabalhados){
        this.aspectosTrabalhados = aspectosTrabalhados;
    }

    public int getAspectosTrabalhadosAcupuntura(){
        return this.aspectosTrabalhadosAcupuntura;
    }

    public void setAspectosTrabalhadosAcupuntura(int aspectosTrabalhadosAcupuntura){
        this.aspectosTrabalhadosAcupuntura = aspectosTrabalhadosAcupuntura;
    }

    public int getAtividadesLudicasLeitura(){
        return this.atividadesLudicasLeitura;
    }

    public void setAtividadesLudicasLeitura(int atividadesLudicasLeitura){
        this.atividadesLudicasLeitura = atividadesLudicasLeitura;
    }

    public int getAtividadesCoordenacaoSurtiramEfeito(){
        return this.atividadesCoordenacaoSurtiramEfeito;
    }

    public void setAtividadesCoordenacaoSurtiramEfeito(int atividadesCoordenacaoSurtiramEfeito){
        this.atividadesCoordenacaoSurtiramEfeito = atividadesCoordenacaoSurtiramEfeito;
    }

    public int getAvaliacoesObtiveramResultadosPositivos(){
        return this.avaliacoesObtiveramResultadosPositivos;
    }

    public void setAvaliacoesObtiveramResultadosPositivos(int avaliacoesObtiveramResultadosPositivos){
        this.avaliacoesObtiveramResultadosPositivos = avaliacoesObtiveramResultadosPositivos;
    }

    public int getPlanejamentoSeguePercursoEsperado(){
        return this.planejamentoSeguePercursoEsperado;
    }

    public void setPlanejamentoSeguePercursoEsperado(int planejamentoSeguePercursoEsperado){
        this.planejamentoSeguePercursoEsperado = planejamentoSeguePercursoEsperado;
    }

    public int getMateriaisSaoSuficientesParaAtividades(){
        return this.materiaisSaoSuficientesParaAtividades;
    }

    public void setMateriaisSaoSuficientesParaAtividades(int materiaisSaoSuficientesParaAtividades){
        this.materiaisSaoSuficientesParaAtividades = materiaisSaoSuficientesParaAtividades;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
