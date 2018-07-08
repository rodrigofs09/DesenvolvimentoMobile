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
        super(context,"Acorde", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS FormularioEducadoraFisica (" +
                "    id INTEGER PRIMARY KEY, " +
                "    nomeAssistido VARCHAR, " +
                "    motivoAtendimento VARCHAR, " +
                "    encaminhamento VARCHAR, " +
                "    idade VARCHAR, " +
                "    peso VARCHAR, " +
                "    altura VARCHAR, " +
                "    bracoDireito VARCHAR, " +
                "    bracoEsquerdo VARCHAR, " +
                "    pernaDireita VARCHAR, " +
                "    pernaEsquerda VARCHAR, " +
                "    cintura VARCHAR, " +
                "    quadril VARCHAR, " +
                "    desempenhoGeral INTEGER, " +
                "    desempenhoEspecifico INTEGER, " +
                "    aspectosMotrizes INTEGER, " +
                "    aspectosCognitivos INTEGER, " +
                "    aspectosSociais INTEGER, " +
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
        dados.put("idade", formularioEducadoraFisica.getIdade());
        dados.put("peso", formularioEducadoraFisica.getPeso());
        dados.put("altura", formularioEducadoraFisica.getAltura());
        dados.put("bracoDireito", formularioEducadoraFisica.getBracoDireito());
        dados.put("bracoEsquerdo", formularioEducadoraFisica.getBracoEsquerdo());
        dados.put("pernaDireita", formularioEducadoraFisica.getPernaDireita());
        dados.put("pernaEsquerda", formularioEducadoraFisica.getPernaEsquerda());
        dados.put("cintura", formularioEducadoraFisica.getCintura());
        dados.put("quadril", formularioEducadoraFisica.getQuadril());
        dados.put("desempenhoGeral", formularioEducadoraFisica.getDesempenhoGeral());
        dados.put("desempenhoEspecifico", formularioEducadoraFisica.getDesempenhoEspecifico());
        dados.put("aspectosMotrizes", formularioEducadoraFisica.getAspectosMotrizes());
        dados.put("aspectosCognitivos", formularioEducadoraFisica.getAspectosCognitivos());
        dados.put("aspectosSociais", formularioEducadoraFisica.getAspectosSociais());
        dados.put("observacao", formularioEducadoraFisica.getObservacao());

        return dados;
    }

    public List<FormularioEducadoraFisica> buscaRelatorioEF() {

        String sql = "SELECT * FROM EducadoraFisica;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<FormularioEducadoraFisica> formularioEducadoraFisicas = new ArrayList<>();

        while(cursor.moveToNext()){

            FormularioEducadoraFisica formularioEducadoraFisica = new FormularioEducadoraFisica();
            formularioEducadoraFisica.setId(cursor.getLong(cursor.getColumnIndex("id")));
            formularioEducadoraFisica.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            formularioEducadoraFisica.setMotivoAtendimento((cursor.getString(cursor.getColumnIndex("motivoAtendimento"))));
            formularioEducadoraFisica.setEncaminhamento((cursor.getString(cursor.getColumnIndex("encaminhamento"))));
            formularioEducadoraFisica.setIdade((cursor.getString(cursor.getColumnIndex("idade"))));
            formularioEducadoraFisica.setPeso((cursor.getString(cursor.getColumnIndex("peso"))));
            formularioEducadoraFisica.setAltura((cursor.getString(cursor.getColumnIndex("altura"))));
            formularioEducadoraFisica.setBracoDireito((cursor.getString(cursor.getColumnIndex("bracoDireito"))));
            formularioEducadoraFisica.setBracoEsquerdo((cursor.getString(cursor.getColumnIndex("bracoEsquerdo"))));
            formularioEducadoraFisica.setPernaDireita((cursor.getString(cursor.getColumnIndex("pernaDireita"))));
            formularioEducadoraFisica.setPernaEsquerda((cursor.getString(cursor.getColumnIndex("pernaEsquerda"))));
            formularioEducadoraFisica.setCintura((cursor.getString(cursor.getColumnIndex("cintura"))));
            formularioEducadoraFisica.setQuadril((cursor.getString(cursor.getColumnIndex("quadril"))));
            formularioEducadoraFisica.setDesempenhoGeral((cursor.getInt(cursor.getColumnIndex("desempenhoGeral"))));
            formularioEducadoraFisica.setDesempenhoEspecifico((cursor.getInt(cursor.getColumnIndex("desempenhoEspecifico"))));
            formularioEducadoraFisica.setAspectosMotrizes((cursor.getInt(cursor.getColumnIndex("aspectosMotrizes"))));
            formularioEducadoraFisica.setAspectosCognitivos((cursor.getInt(cursor.getColumnIndex("aspectosCognitivos"))));
            formularioEducadoraFisica.setAspectosSociais((cursor.getInt(cursor.getColumnIndex("aspectosSociais"))));
            formularioEducadoraFisica.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            formularioEducadoraFisicas.add(formularioEducadoraFisica);
        }

        cursor.close();

        return formularioEducadoraFisicas;
    }
}
