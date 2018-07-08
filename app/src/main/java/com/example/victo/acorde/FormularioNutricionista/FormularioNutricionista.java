package com.example.victo.acorde.FormularioNutricionista;

import java.io.Serializable;
import java.util.Date;

public class FormularioNutricionista implements Serializable {

    private Long id;
    private String dataAtendimento;
    private String nomeAssistido;
    private String motivoAtendimento;
    private String encaminhamento;
    private String idade;
    private String altura;
    private String peso;
    private String cintura;
    private String quadril;
    private String bracos;
    private int alimentarSozinho;
    private int servirSozinho;
    private int qtdAlimento;
    private int prepararSozinho;
    private int habitoIntestinal;
    private int mastigacao;
    private int patologia;
    private int alergiaAlimentar;
    private int preferenciaAlimentar;
    private int naoConsome;
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
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

    public int getAlimentarSozinho() {
        return alimentarSozinho;
    }

    public void setAlimentarSozinho(int alimentarSozinho) {
        this.alimentarSozinho = alimentarSozinho;
    }

    public int getServirSozinho() {
        return servirSozinho;
    }

    public void setServirSozinho(int servirSozinho) {
        this.servirSozinho = servirSozinho;
    }

    public int getQtdAlimento() {
        return qtdAlimento;
    }

    public void setQtdAlimento(int qtdAlimento) {
        this.qtdAlimento = qtdAlimento;
    }

    public int getPrepararSozinho() {
        return prepararSozinho;
    }

    public void setPrepararSozinho(int prepararSozinho) {
        this.prepararSozinho = prepararSozinho;
    }

    public int getHabitoIntestinal() {
        return habitoIntestinal;
    }

    public void setHabitoIntestinal(int habitoIntestinal) {
        this.habitoIntestinal = habitoIntestinal;
    }

    public int getMastigacao() {
        return mastigacao;
    }

    public void setMastigacao(int mastigacao) {
        this.mastigacao = mastigacao;
    }

    public int getPatologia() {
        return patologia;
    }

    public void setPatologia(int patologia) {
        this.patologia = patologia;
    }

    public int getAlergiaAlimentar() {
        return alergiaAlimentar;
    }

    public void setAlergiaAlimentar(int alergiaAlimentar) {
        this.alergiaAlimentar = alergiaAlimentar;
    }

    public int getPreferenciaAlimentar() {
        return preferenciaAlimentar;
    }

    public void setPreferenciaAlimentar(int preferenciaAlimentar) {
        this.preferenciaAlimentar = preferenciaAlimentar;
    }

    public int getNaoConsome() {
        return naoConsome;
    }

    public void setNaoConsome(int naoConsome) {
        this.naoConsome = naoConsome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}