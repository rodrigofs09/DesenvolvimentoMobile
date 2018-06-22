package com.example.victo.acorde.FormularioEducadoraFisica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FormularioEducadoraFisicaDAO extends SQLiteOpenHelper{

    public FormularioEducadoraFisicaDAO(Context context){
        super(context,"Acorde", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS EducadoraFisica (" +
                "    id INTEGER PRIMARY KEY, " +
                "    nomeAssistido VARCHAR, " +
                "    motivoAtendimento VARCHAR, " +
                "    encaminhamento VARCHAR, " +
                "    arco VARCHAR, " +
                "    mms VARCHAR, " +
                "    mmii VARCHAR, " +
                "    tronco VARCHAR, " +
                "    marcha1 VARCHAR, " +
                "    marcha2 VARCHAR, " +
                "    marcha3 VARCHAR, " +
                "    polichinelo VARCHAR, " +
                "    polichineloObs VARCHAR, " +
                "    lego VARCHAR, " +
                "    legoObs VARCHAR, " +
                "    pintar VARCHAR, " +
                "    controle VARCHAR, " +
                "    dimensao VARCHAR, " +
                "    dimensaoFrente VARCHAR, " +
                "    dimensaoTras VARCHAR, " +
                "    dimensaoDireita VARCHAR, " +
                "    dimensaoEsquerda VARCHAR, " +
                "    dimensaoCima VARCHAR, " +
                "    dimensaoBaixo VARCHAR, " +
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

    public void insereRelatorioEF(FormularioEducadoraFisica formularioEducadoraFisica) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEF(formularioEducadoraFisica);
        db.insert("FormularioEducadoraFisica", null, dados);
    }

    public void alteraRelatorioEF(FormularioEducadoraFisica formularioEducadoraFisica) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEF(formularioEducadoraFisica);
        String[] params = {formularioEducadoraFisica.getId().toString()};
        db.update("FormularioEducadoraFisica", dados, "id = ?", params);
    }

    public void deletaRelatorioEF(FormularioEducadoraFisica formularioEducadoraFisica) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {formularioEducadoraFisica.getId().toString()};
        db.delete("FormularioEducadoraFisica", "id = ?", params);
    }

    private ContentValues pegaDadosRelatorioEF(FormularioEducadoraFisica formularioEducadoraFisica) {
        ContentValues dados = new ContentValues();

        dados.put("nomeAssistido", formularioEducadoraFisica.getNomeAssistido());
        dados.put("motivoAtendimento", formularioEducadoraFisica.getMotivoAtendimento());
        dados.put("encaminhamento", formularioEducadoraFisica.getEncaminhamento());
        dados.put("arco", formularioEducadoraFisica.getArco());
        dados.put("mms", formularioEducadoraFisica.getMms());
        dados.put("mmii", formularioEducadoraFisica.getMmii());
        dados.put("tronco", formularioEducadoraFisica.getTronco());
        dados.put("marcha1", formularioEducadoraFisica.getMarcha1());
        dados.put("marcha2", formularioEducadoraFisica.getMarcha2());
        dados.put("marcha3", formularioEducadoraFisica.getMarcha3());
        dados.put("polichinelo", formularioEducadoraFisica.getPolichinelo());
        dados.put("polichineloObs", formularioEducadoraFisica.getPolichineloObs());
        dados.put("lego", formularioEducadoraFisica.getLego());
        dados.put("legoObs", formularioEducadoraFisica.getLegoObs());
        dados.put("pintar", formularioEducadoraFisica.getPintar());
        dados.put("controle", formularioEducadoraFisica.getControle());
        dados.put("dimensao", formularioEducadoraFisica.getDimensaoC());
        dados.put("dimensaoFrente", formularioEducadoraFisica.getDimensaoFrente());
        dados.put("dimensaoTras", formularioEducadoraFisica.getDimensaoTras());
        dados.put("dimensaoDireita", formularioEducadoraFisica.getDimensaoDireita());
        dados.put("dimensaoEsquerda", formularioEducadoraFisica.getDimensaoEsquerda());
        dados.put("dimensaoCima", formularioEducadoraFisica.getDimensaoCima());
        dados.put("dimensaoBaixo", formularioEducadoraFisica.getDimensaoBaixo());
        dados.put("observacao", formularioEducadoraFisica.getObservacao());

        return dados;
    }

    public List<FormularioEducadoraFisica> buscaRelatorioEF() {

        String sql = "SELECT * FROM EducadoraFisica;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<FormularioEducadoraFisica> formularioEducadoraFisicas = new ArrayList<FormularioEducadoraFisica>();

        while(cursor.moveToNext()){

            FormularioEducadoraFisica formularioEducadoraFisica = new FormularioEducadoraFisica();
            formularioEducadoraFisica.setId(cursor.getLong(cursor.getColumnIndex("id")));
            formularioEducadoraFisica.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            formularioEducadoraFisica.setMotivoAtendimento((cursor.getString(cursor.getColumnIndex("motivoAtendimento"))));
            formularioEducadoraFisica.setEncaminhamento((cursor.getString(cursor.getColumnIndex("encaminhamento"))));
            formularioEducadoraFisica.setArco((cursor.getString(cursor.getColumnIndex("arco"))));
            formularioEducadoraFisica.setMms((cursor.getString(cursor.getColumnIndex("mms"))));
            formularioEducadoraFisica.setMmii((cursor.getString(cursor.getColumnIndex("mmii"))));
            formularioEducadoraFisica.setTronco((cursor.getString(cursor.getColumnIndex("tronco"))));
            formularioEducadoraFisica.setMarcha1((cursor.getString(cursor.getColumnIndex("marcha1"))));
            formularioEducadoraFisica.setMarcha2((cursor.getString(cursor.getColumnIndex("marcha2"))));
            formularioEducadoraFisica.setMarcha3((cursor.getString(cursor.getColumnIndex("marcha3"))));
            formularioEducadoraFisica.setPolichinelo((cursor.getString(cursor.getColumnIndex("polichinelo"))));
            formularioEducadoraFisica.setPolichineloObs((cursor.getString(cursor.getColumnIndex("polichineloObs"))));
            formularioEducadoraFisica.setLego((cursor.getString(cursor.getColumnIndex("lego"))));
            formularioEducadoraFisica.setLegoObs((cursor.getString(cursor.getColumnIndex("legoObs"))));
            formularioEducadoraFisica.setPintar((cursor.getString(cursor.getColumnIndex("pintar"))));
            formularioEducadoraFisica.setControle((cursor.getString(cursor.getColumnIndex("controle"))));
            formularioEducadoraFisica.setDimensaoC((cursor.getString(cursor.getColumnIndex("dimensao"))));
            formularioEducadoraFisica.setDimensaoFrente((cursor.getString(cursor.getColumnIndex("dimensaoFrente"))));
            formularioEducadoraFisica.setDimensaoTras((cursor.getString(cursor.getColumnIndex("dimensaoTras"))));
            formularioEducadoraFisica.setDimensaoDireita((cursor.getString(cursor.getColumnIndex("dimensaoDireita"))));
            formularioEducadoraFisica.setDimensaoEsquerda((cursor.getString(cursor.getColumnIndex("dimensaoEsquerda"))));
            formularioEducadoraFisica.setDimensaoCima((cursor.getString(cursor.getColumnIndex("dimensaoCima"))));
            formularioEducadoraFisica.setDimensaoBaixo((cursor.getString(cursor.getColumnIndex("dimensaoBaixo"))));
            formularioEducadoraFisica.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            formularioEducadoraFisicas.add(formularioEducadoraFisica);
        }

        cursor.close();

        return formularioEducadoraFisicas;
    }
}
