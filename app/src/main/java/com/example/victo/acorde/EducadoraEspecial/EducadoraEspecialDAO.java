package com.example.victo.acorde.EducadoraEspecial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class EducadoraEspecialDAO extends SQLiteOpenHelper {
    public EducadoraEspecialDAO(Context context){
        super(context,"Acorde", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS EducadoraEspecial (" +
                "    id INTEGER PRIMARY KEY, " +
                "    nomeAssistido VARCHAR, " +
                "    motivoAtendimento VARCHAR, " +
                "    encaminhamento VARCHAR, " +
                "    comunicacaoVerbal VARCHAR, " +
                "    segueInstrucoes VARCHAR, " +
                "    respondePerguntas VARCHAR, " +
                "    imitaModelos VARCHAR, " +
                "    permaneceNasTarefas VARCHAR, " +
                "    completaTarefas VARCHAR, " +
                "    reconheceAtividades VARCHAR, " +
                "    reconheceTrabalhos VARCHAR, " +
                "    reconheceErros VARCHAR, " +
                "    reconheceNecessidade VARCHAR, " +
                "    compreendeOrdensSimples VARCHAR, " +
                "    compreendeOrdensComplexas VARCHAR, " +
                "    raciocinio VARCHAR, " +
                "    memoriaRemota VARCHAR, " +
                "    memoriaRecente VARCHAR, " +
                "    memoriaImediata VARCHAR, " +
                "    assimilaAtividades VARCHAR, " +
                "    verbalizaPensamentos VARCHAR, " +
                "    escreve VARCHAR, " +
                "    consegueLer VARCHAR, " +
                "    gestualizaMaos VARCHAR, " +
                "    fazGaratuja VARCHAR, " +
                "    assinaNome VARCHAR, " +
                "    coloriFiguras VARCHAR, " +
                "    copiaLinhas VARCHAR, " +
                "    escreveCaneta VARCHAR, " +
                "    usaBorracha VARCHAR, " +
                "    reconheceCores VARCHAR, " +
                "    reconheceLetrasAlfabeto VARCHAR, " +
                "    reconheceLetrasNome VARCHAR, " +
                "    fazPareamento VARCHAR, " +
                "    reconheceNumeros VARCHAR, " +
                "    possuiNocao VARCHAR, " +
                "    possuiAtencao VARCHAR, " +
                "    observacao VARCHAR);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insereRelatorioEE(EducadoraEspecial ee) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEE(ee);
        db.insert("EducadoraEspecial", null, dados);
    }

    public void alteraRelatorioEE(EducadoraEspecial ee) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEE(ee);
        String[] params = {ee.getId().toString()};
        db.update("EducadoraEspecial", dados, "id = ?", params);
    }

    public void deletaRelatorioEE(EducadoraEspecial ee) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {ee.getId().toString()};
        db.delete("EducadoraEspecial", "id = ?", params);
    }

    private ContentValues pegaDadosRelatorioEE(EducadoraEspecial educadoraEspecial) {
        ContentValues dados = new ContentValues();

        dados.put("nomeAssistido", educadoraEspecial.getNomeAssistido());
        dados.put("motivoAtendimento", educadoraEspecial.getMotivoAtendimento());
        dados.put("encaminhamento", educadoraEspecial.getEncaminhamento());
        dados.put("comunicacaoVerbal", educadoraEspecial.getComunicacaoVerbal());
        dados.put("segueInstrucoes", educadoraEspecial.getSegueInstrucoes());
        dados.put("respondePerguntas", educadoraEspecial.getRespondePerguntas());
        dados.put("imitaModelos", educadoraEspecial.getImitaModelos());
        dados.put("permaneceNasTarefas", educadoraEspecial.getPermaneceNasTarefas());
        dados.put("completaTarefas", educadoraEspecial.getCompletaTarefas());
        dados.put("reconheceAtividades", educadoraEspecial.getReconheceAtividades());
        dados.put("reconheceTrabalhos", educadoraEspecial.getReconheceTrabalhos());
        dados.put("reconheceErros", educadoraEspecial.getReconheceErros());
        dados.put("reconheceNecessidade", educadoraEspecial.getReconheceNecessidade());
        dados.put("compreendeOrdensSimples", educadoraEspecial.getCompreendeOrdensSimples());
        dados.put("compreendeOrdensComplexas", educadoraEspecial.getCompreendeOrdensComplexas());
        dados.put("raciocinio", educadoraEspecial.getRaciocinio());
        dados.put("memoriaRemota", educadoraEspecial.getMemoriaRemota());
        dados.put("memoriaRecente", educadoraEspecial.getMemoriaRecente());
        dados.put("memoriaImediata", educadoraEspecial.getMemoriaImediata());
        dados.put("assimilaAtividades", educadoraEspecial.getAssimilaAtividades());
        dados.put("verbalizaPensamentos", educadoraEspecial.getVerbalizaPensamentos());
        dados.put("escreve", educadoraEspecial.getEscreve());
        dados.put("consegueLer", educadoraEspecial.getConsegueLer());
        dados.put("gestualizaMaos", educadoraEspecial.getGestualizaMaos());
        dados.put("fazGaratuja", educadoraEspecial.getFazGaratuja());
        dados.put("assinaNome", educadoraEspecial.getAssinaNome());
        dados.put("coloriFiguras", educadoraEspecial.getColoriFiguras());
        dados.put("copiaLinhas", educadoraEspecial.getCopiaLinhas());
        dados.put("escreveCaneta", educadoraEspecial.getEscreveCaneta());
        dados.put("usaBorracha", educadoraEspecial.getUsaBorracha());
        dados.put("reconheceCores", educadoraEspecial.getReconheceCores());
        dados.put("reconheceLetrasAlfabeto", educadoraEspecial.getReconheceLetrasAlfabeto());
        dados.put("reconheceLetrasNome", educadoraEspecial.getReconheceLetrasNome());
        dados.put("fazPareamento", educadoraEspecial.getFazPareamento());
        dados.put("reconheceNumeros", educadoraEspecial.getReconheceNumeros());
        dados.put("possuiNocao", educadoraEspecial.getPossuiNocao());
        dados.put("possuiAtencao", educadoraEspecial.getPossuiAtencao());
        dados.put("observacao", educadoraEspecial.getObservacao());

        return dados;
    }

    public List<EducadoraEspecial> buscaRelatorioEE() {

        String sql = "SELECT * FROM EducadoraEspecial;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<EducadoraEspecial> educadoraEspecials = new ArrayList<EducadoraEspecial>();

        while(cursor.moveToNext()){

            EducadoraEspecial educadoraEspecial = new EducadoraEspecial();
            educadoraEspecial.setId(cursor.getLong(cursor.getColumnIndex("id")));
            educadoraEspecial.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            educadoraEspecial.setMotivoAtendimento((cursor.getString(cursor.getColumnIndex("motivoAtendimento"))));
            educadoraEspecial.setEncaminhamento((cursor.getString(cursor.getColumnIndex("encaminhamento"))));
            /*educadoraEspecial.setComunicacaoVerbal((cursor.getString(cursor.getColumnIndex("comunicacaoVerbal"))));
            educadoraEspecial.setSegueInstrucoes(cursor.getString(cursor.getColumnIndex("segueInstrucoes"))););
            educadoraEspecial.setRespondePerguntas((cursor.getString(cursor.getColumnIndex("respondePerguntas"))));
            educadoraEspecial.setImitaModelos((cursor.getString(cursor.getColumnIndex("imitaModelos"))));
            educadoraEspecial.setPermaneceNasTarefas((cursor.getString(cursor.getColumnIndex("permaneceNasTarefas"))));
            educadoraEspecial.setCompletaTarefas((cursor.getString(cursor.getColumnIndex("completaTarefas"))));
            educadoraEspecial.setReconheceAtividades((cursor.getString(cursor.getColumnIndex("reconheceAtividades"))));
            educadoraEspecial.setReconheceTrabalhos((cursor.getString(cursor.getColumnIndex("reconheceTrabalhos"))));
            educadoraEspecial.setReconheceErros((cursor.getString(cursor.getColumnIndex("reconheceErros"))));
            educadoraEspecial.setReconheceNecessidade((cursor.getString(cursor.getColumnIndex("reconheceNecessidade"))));
            educadoraEspecial.setCompreendeOrdensSimples((cursor.getString(cursor.getColumnIndex("compreendeOrdensSimples"))));
            educadoraEspecial.setCompreendeOrdensComplexas(cursor.getString(cursor.getColumnIndex("compreendeOrdensComplexas"))););
            educadoraEspecial.setRaciocinio((cursor.getString(cursor.getColumnIndex("raciocinio"))));
            educadoraEspecial.setMemoriaRemota((cursor.getString(cursor.getColumnIndex("memoriaRemota"))));
            educadoraEspecial.setMemoriaRecente((cursor.getString(cursor.getColumnIndex("memoriaRecente"))));
            educadoraEspecial.setMemoriaImediata((cursor.getString(cursor.getColumnIndex("memoriaImediata"))));
            educadoraEspecial.setAssimilaAtividades((cursor.getString(cursor.getColumnIndex("assimilaAtividades"))));
            educadoraEspecial.setVerbalizaPensamentos((cursor.getString(cursor.getColumnIndex("verbalizaPensamentos"))));
            educadoraEspecial.setEscreve((cursor.getString(cursor.getColumnIndex("escreve"))));
            educadoraEspecial.setConsegueLer((cursor.getString(cursor.getColumnIndex("consegueLer"))));
            educadoraEspecial.setGestualizaMaos((cursor.getString(cursor.getColumnIndex("gestualizaMaos"))));
            educadoraEspecial.setFazGaratuja((cursor.getString(cursor.getColumnIndex("fazGaratuja"))));
            educadoraEspecial.setAssinaNome((cursor.getString(cursor.getColumnIndex("assinaNome"))));
            educadoraEspecial.setColoriFiguras((cursor.getString(cursor.getColumnIndex("coloriFiguras"))));
            educadoraEspecial.setCopiaLinhas(cursor.getString(cursor.getColumnIndex("copiaLinhas"))););
            educadoraEspecial.setEscreveCaneta((cursor.getString(cursor.getColumnIndex("escreveCaneta"))));
            educadoraEspecial.setUsaBorracha((cursor.getString(cursor.getColumnIndex("usaBorracha"))));
            educadoraEspecial.setReconheceCores((cursor.getString(cursor.getColumnIndex("reconheceCores"))));
            educadoraEspecial.setReconheceLetrasAlfabeto(cursor.getString(cursor.getColumnIndex("reconheceLetrasAlfabeto"))););
            educadoraEspecial.setReconheceLetrasNome((cursor.getString(cursor.getColumnIndex("reconheceLetrasNome"))));
            educadoraEspecial.setFazPareamento((cursor.getString(cursor.getColumnIndex("fazPareamento"))));
            educadoraEspecial.setReconheceNumeros((cursor.getString(cursor.getColumnIndex("reconheceNumeros"))));
            educadoraEspecial.setPossuiNocao((cursor.getString(cursor.getColumnIndex("possuiNocao"))));
            educadoraEspecial.setPossuiAtencao((cursor.getString(cursor.getColumnIndex("possuiAtencao"))));*/
            educadoraEspecial.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            educadoraEspecials.add(educadoraEspecial);
        }

        cursor.close();

        return educadoraEspecials;
    }
}
