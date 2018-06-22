package com.example.victo.acorde.FormularioNutricionista;

import java.io.Serializable;
import java.util.Date;

public class FormularioNutricionista implements Serializable {

    private Long id;
    private Date dataAtendimento;
    //private String tipoAtendimento;
    private String nomeAssistido;
    private String motivoAtendimento;
    private String encaminhamento;
    //private String profissional;
    private String altura;
    private String peso;
    private String cintura;
    private String quadril;
    private String bracos;
    private String alimentarSozinho;
    private String servirSozinho;
    private String qtdAlimento;
    private String prepararSozinho;
    private String habitoIntestinal;
    private String mastigacao;
    private String patologia;
    private String intoleranciAlimentar;
    private String alergiaAlimentar;
    private String preferenciaAlimentar;
    private String naoConsome;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date data) {
        this.dataAtendimento = data;
    }

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

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getQuadril() {
        return quadril;
    }

    public void setQuadril(String quadril) {
        this.quadril = quadril;
    }

    public String getBracos() {
        return bracos;
    }

    public void setBracos(String bracos) {
        this.bracos = bracos;
    }

    public String getAlimentarSozinho() {
        return alimentarSozinho;
    }

    public void setAlimentarSozinho(String alimentarSozinho) {
        this.alimentarSozinho = alimentarSozinho;
    }

    public String getServirSozinho() {
        return servirSozinho;
    }

    public void setServirSozinho(String servirSozinho) {
        this.servirSozinho = servirSozinho;
    }

    public String getQtdAlimento() {
        return qtdAlimento;
    }

    public void setQtdAlimento(String qtdAlimento) {
        this.qtdAlimento = qtdAlimento;
    }

    public String getPrepararSozinho() {
        return prepararSozinho;
    }

    public void setPrepararSozinho(String prepararSozinho) {
        this.prepararSozinho = prepararSozinho;
    }

    public String getHabitoIntestinal() {
        return habitoIntestinal;
    }

    public void setHabitoIntestinal(String habitoIntestinal) {
        this.habitoIntestinal = habitoIntestinal;
    }

    public String getMastigacao() {
        return mastigacao;
    }

    public void setMastigacao(String mastigacao) {
        this.mastigacao = mastigacao;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getIntoleranciAlimentar() {
        return intoleranciAlimentar;
    }

    public void setIntoleranciAlimentar(String intoleranciAlimentar) {
        this.intoleranciAlimentar = intoleranciAlimentar;
    }

    public String getAlergiaAlimentar() {
        return alergiaAlimentar;
    }

    public void setAlergiaAlimentar(String alergiaAlimentar) {
        this.alergiaAlimentar = alergiaAlimentar;
    }

    public String getPreferenciaAlimentar() {
        return preferenciaAlimentar;
    }

    public void setPreferenciaAlimentar(String preferenciaAlimentar) {
        this.preferenciaAlimentar = preferenciaAlimentar;
    }

    public String getNaoConsome() {
        return naoConsome;
    }

    public void setNaoConsome(String naoConsome) {
        this.naoConsome = naoConsome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}