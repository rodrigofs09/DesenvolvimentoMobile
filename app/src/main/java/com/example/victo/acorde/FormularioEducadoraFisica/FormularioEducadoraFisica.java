package com.example.victo.acorde.FormularioEducadoraFisica;

import java.io.Serializable;
import java.sql.Date;

public class FormularioEducadoraFisica implements Serializable {

    private Long id;
    private String dataAtendimento;
    private String nomeAssistido;
    private String motivoAtendimento;
    private String encaminhamento;
    private String idade;
    private String peso;
    private String altura;
    private String bracoDireito;
    private String bracoEsquerdo;
    private String pernaDireita;
    private String pernaEsquerda;
    private String cintura;
    private String quadril;
    private int desempenhoGeral;
    private int desempenhoEspecifico;
    private int aspectosMotrizes;
    private int aspectosCognitivos;
    private int aspectosSociais;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) { this.altura = altura;}

    public String getBracoDireito() {
        return bracoDireito;
    }

    public void setBracoDireito(String bracoDireito) {
        this.bracoDireito = bracoDireito;
    }

    public String getBracoEsquerdo() {
        return bracoEsquerdo;
    }

    public void setBracoEsquerdo(String bracoEsquerdo) {
        this.bracoEsquerdo = bracoEsquerdo;
    }

    public String getPernaDireita() {
        return pernaDireita;
    }

    public void setPernaDireita(String pernaDireita) {
        this.pernaDireita = pernaDireita;
    }

    public String getPernaEsquerda() {
        return pernaEsquerda;
    }

    public void setPernaEsquerda(String pernaEsquerda) {
        this.pernaEsquerda = pernaEsquerda;
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

    public int getDesempenhoGeral() {
        return desempenhoGeral;
    }

    public void setDesempenhoGeral(int desempenhoGeral) {
        this.desempenhoGeral = desempenhoGeral;
    }

    public int getDesempenhoEspecifico() {
        return desempenhoEspecifico;
    }

    public void setDesempenhoEspecifico(int desempenhoEspecifico) {
        this.desempenhoEspecifico = desempenhoEspecifico;
    }

    public int getAspectosMotrizes() {
        return aspectosMotrizes;
    }

    public void setAspectosMotrizes(int aspectosMotrizes) {
        this.aspectosMotrizes = aspectosMotrizes;
    }

    public int getAspectosCognitivos() {
        return aspectosCognitivos;
    }

    public void setAspectosCognitivos(int aspectosCognitivos) {
        this.aspectosCognitivos = aspectosCognitivos;
    }

    public int getAspectosSociais() {
        return aspectosSociais;
    }

    public void setAspectosSociais(int aspectosSociais) {
        this.aspectosSociais = aspectosSociais;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String obseracao) {
        this.observacao = obseracao;
    }

}
