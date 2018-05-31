package com.example.victo.acorde.EducadoraFisica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class EducadoraFisicaDAO extends SQLiteOpenHelper{

    public EducadoraFisicaDAO(Context context){
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

    public void insereRelatorioEF(EducadoraFisica educadoraFisica) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEF(educadoraFisica);
        db.insert("EducadoraFisica", null, dados);
    }

    public void alteraRelatorioEF(EducadoraFisica educadoraFisica) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEF(educadoraFisica);
        String[] params = {educadoraFisica.getId().toString()};
        db.update("EducadoraFisica", dados, "id = ?", params);
    }

    public void deletaRelatorioEF(EducadoraFisica educadoraFisica) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {educadoraFisica.getId().toString()};
        db.delete("EducadoraFisica", "id = ?", params);
    }

    private ContentValues pegaDadosRelatorioEF(EducadoraFisica educadoraFisica) {
        ContentValues dados = new ContentValues();

        dados.put("nomeAssistido", educadoraFisica.getNomeAssistido());
        dados.put("motivoAtendimento", educadoraFisica.getMotivoAtendimento());
        dados.put("encaminhamento", educadoraFisica.getEncaminhamento());
        dados.put("arco", educadoraFisica.getArco());
        dados.put("mms", educadoraFisica.getMms());
        dados.put("mmii", educadoraFisica.getMmii());
        dados.put("tronco", educadoraFisica.getTronco());
        dados.put("marcha1", educadoraFisica.getMarcha1());
        dados.put("marcha2", educadoraFisica.getMarcha2());
        dados.put("marcha3", educadoraFisica.getMarcha3());
        dados.put("polichinelo", educadoraFisica.getPolichinelo());
        dados.put("polichineloObs", educadoraFisica.getPolichineloObs());
        dados.put("lego", educadoraFisica.getLego());
        dados.put("legoObs", educadoraFisica.getLegoObs());
        dados.put("pintar", educadoraFisica.getPintar());
        dados.put("controle", educadoraFisica.getControle());
        dados.put("dimensao", educadoraFisica.getDimensaoC());
        dados.put("dimensaoFrente", educadoraFisica.getDimensaoFrente());
        dados.put("dimensaoTras", educadoraFisica.getDimensaoTras());
        dados.put("dimensaoDireita", educadoraFisica.getDimensaoDireita());
        dados.put("dimensaoEsquerda", educadoraFisica.getDimensaoEsquerda());
        dados.put("dimensaoCima", educadoraFisica.getDimensaoCima());
        dados.put("dimensaoBaixo", educadoraFisica.getDimensaoBaixo());
        dados.put("observacao", educadoraFisica.getObservacao());

        return dados;
    }

    public List<EducadoraFisica> buscaRelatorioEF() {

        String sql = "SELECT * FROM EducadoraFisica;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<EducadoraFisica> educadoraFisicas = new ArrayList<EducadoraFisica>();

        while(cursor.moveToNext()){

            EducadoraFisica educadoraFisica = new EducadoraFisica();
            educadoraFisica.setId(cursor.getLong(cursor.getColumnIndex("id")));
            educadoraFisica.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            educadoraFisica.setMotivoAtendimento((cursor.getString(cursor.getColumnIndex("motivoAtendimento"))));
            educadoraFisica.setEncaminhamento((cursor.getString(cursor.getColumnIndex("encaminhamento"))));
            educadoraFisica.setArco((cursor.getString(cursor.getColumnIndex("arco"))));
            educadoraFisica.setMms((cursor.getString(cursor.getColumnIndex("mms"))));
            educadoraFisica.setMmii((cursor.getString(cursor.getColumnIndex("mmii"))));
            educadoraFisica.setTronco((cursor.getString(cursor.getColumnIndex("tronco"))));
            educadoraFisica.setMarcha1((cursor.getString(cursor.getColumnIndex("marcha1"))));
            educadoraFisica.setMarcha2((cursor.getString(cursor.getColumnIndex("marcha2"))));
            educadoraFisica.setMarcha3((cursor.getString(cursor.getColumnIndex("marcha3"))));
            educadoraFisica.setPolichinelo((cursor.getString(cursor.getColumnIndex("polichinelo"))));
            educadoraFisica.setPolichineloObs((cursor.getString(cursor.getColumnIndex("polichineloObs"))));
            educadoraFisica.setLego((cursor.getString(cursor.getColumnIndex("lego"))));
            educadoraFisica.setLegoObs((cursor.getString(cursor.getColumnIndex("legoObs"))));
            educadoraFisica.setPintar((cursor.getString(cursor.getColumnIndex("pintar"))));
            educadoraFisica.setControle((cursor.getString(cursor.getColumnIndex("controle"))));
            educadoraFisica.setDimensaoC((cursor.getString(cursor.getColumnIndex("dimensao"))));
            educadoraFisica.setDimensaoFrente((cursor.getString(cursor.getColumnIndex("dimensaoFrente"))));
            educadoraFisica.setDimensaoTras((cursor.getString(cursor.getColumnIndex("dimensaoTras"))));
            educadoraFisica.setDimensaoDireita((cursor.getString(cursor.getColumnIndex("dimensaoDireita"))));
            educadoraFisica.setDimensaoEsquerda((cursor.getString(cursor.getColumnIndex("dimensaoEsquerda"))));
            educadoraFisica.setDimensaoCima((cursor.getString(cursor.getColumnIndex("dimensaoCima"))));
            educadoraFisica.setDimensaoBaixo((cursor.getString(cursor.getColumnIndex("dimensaoBaixo"))));
            educadoraFisica.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            educadoraFisicas.add(educadoraFisica);
        }

        cursor.close();

        return educadoraFisicas;
    }
}
