package com.example.victo.acorde.Nutricionista;

import java.io.Serializable;
import java.util.Date;

public class Nutricionista implements Serializable{

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
    private String peso;
    private String altura;
    private String imc;
    private String cintura;
    private String quadril;
    private String bracos;
    private String alimentar;
    private String servir;
    private String qtdAlimento;
    private String preparar;
    private String patologia;
    private String habitoIntestinal;
    private String intoleranciAlimentar;
    private String alergiaAlimentar;
    private String preferenciaAlimentar;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
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

    public String getAlimentar() {
        return alimentar;
    }

    public void setAlimentar(String alimentar) {
        this.alimentar = alimentar;
    }

    public String getServir() {
        return servir;
    }

    public void setServir(String servir) {
        this.servir = servir;
    }

    public String getQtdAlimento() {
        return qtdAlimento;
    }

    public void setQtdAlimento(String qtdAlimento) {
        this.qtdAlimento = qtdAlimento;
    }

    public String getPreparar() {
        return preparar;
    }

    public void setPreparar(String preparar) {
        this.preparar = preparar;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getHabitoIntestinal() {
        return habitoIntestinal;
    }

    public void setHabitoIntestinal(String habitoIntestinal) {
        this.habitoIntestinal = habitoIntestinal;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
