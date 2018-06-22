package com.example.victo.acorde.FormularioNutricionista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class FormularioNutricionistaDAO extends SQLiteOpenHelper {

    public FormularioNutricionistaDAO(Context context) {
        super(context, "Acorde", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS FormularioNutricionista (" +
                "    id INTEGER PRIMARY KEY, " +
                "    dataAtendimento DATE," +
                "    nomeAssistido VARCHAR, " +
                "    motivoAtendimento VARCHAR, " +
                "    encaminhamento VARCHAR, " +
                "    altura VARCHAR, " +
                "    peso VARCHAR, " +
                "    cintura VARCHAR, " +
                "    quadril VARCHAR, " +
                "    bracos VARCHAR, " +
                "    alimentarSozinho VARCHAR, " +
                "    servirSozinho VARCHAR, " +
                "    qtdAlimento VARCHAR, " +
                "    prepararSozinho VARCHAR, " +
                "    habitoIntestinal VARCHAR, " +
                "    mastigacao VARCHAR, " +
                "    patologia VARCHAR, " +
                "    intoleranciAlimentar VARCHAR, " +
                "    alergiaAlimentar VARCHAR, " +
                "    preferenciaAlimentar VARCHAR, " +
                "    naoConsome VARCHAR, " +
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

    public void insereFormularioNU(FormularioNutricionista nu) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosFormularioNU(nu);
        db.insert("FormularioNutricionista", null, dados);
    }

    public void alteraFormularioNU(FormularioNutricionista nu) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosFormularioNU(nu);
        String[] params = {nu.getId().toString()};
        db.update("FormularioNutricionista", dados, "id = ?", params);
    }

    public void deletaFormularioNU(FormularioNutricionista nu) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {nu.getId().toString()};
        db.delete("FormularioNutricionista", "id = ?", params);
    }

    private ContentValues pegaDadosFormularioNU(FormularioNutricionista formularioNutricionista) {
        ContentValues dados = new ContentValues();

        //dados.put("dataAtendimento", formularioNutricionista.getDataAtendimento().toString());
        dados.put("nomeAssistido", formularioNutricionista.getNomeAssistido());
        dados.put("motivoAtendimento", formularioNutricionista.getMotivoAtendimento());
        dados.put("encaminhamento", formularioNutricionista.getEncaminhamento());
        dados.put("altura", formularioNutricionista.getAltura());
        dados.put("peso", formularioNutricionista.getPeso());
        dados.put("cintura", formularioNutricionista.getCintura());
        dados.put("quadril", formularioNutricionista.getQuadril());
        dados.put("bracos", formularioNutricionista.getBracos());
        dados.put("alimentarSozinho", formularioNutricionista.getAlimentarSozinho());
        dados.put("servirSozinho", formularioNutricionista.getServirSozinho());
        dados.put("qtdAlimento", formularioNutricionista.getQtdAlimento());
        dados.put("prepararSozinho", formularioNutricionista.getPrepararSozinho());
        dados.put("habitoIntestinal", formularioNutricionista.getHabitoIntestinal());
        dados.put("mastigacao", formularioNutricionista.getMastigacao());
        dados.put("patologia", formularioNutricionista.getPatologia());
        dados.put("intoleranciAlimentar", formularioNutricionista.getIntoleranciAlimentar());
        dados.put("alergiaAlimentar", formularioNutricionista.getAlergiaAlimentar());
        dados.put("preferenciaAlimentar", formularioNutricionista.getPreferenciaAlimentar());
        dados.put("naoConsome", formularioNutricionista.getNaoConsome());
        dados.put("observacao", formularioNutricionista.getObservacao());

        return dados;
    }

    public List<FormularioNutricionista> buscaFormularioNU() {

        String sql = "SELECT * FROM FormularioNutricionista;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        List<FormularioNutricionista> formulariosNutricionista = new ArrayList<FormularioNutricionista>();

        while (cursor.moveToNext()) {

            FormularioNutricionista formularioNutricionista = new FormularioNutricionista();
            formularioNutricionista.setId(cursor.getLong(cursor.getColumnIndex("id")));
            //formularioNutricionista.setDataAtendimento(formato.parse(cursor.getString(cursor.getColumnIndex("dataAtendimento"))));
            formularioNutricionista.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            formularioNutricionista.setMotivoAtendimento((cursor.getString(cursor.getColumnIndex("motivoAtendimento"))));
            formularioNutricionista.setEncaminhamento((cursor.getString(cursor.getColumnIndex("encaminhamento"))));
            formularioNutricionista.setAltura((cursor.getString(cursor.getColumnIndex("altura"))));
            formularioNutricionista.setPeso((cursor.getString(cursor.getColumnIndex("peso"))));
            formularioNutricionista.setCintura((cursor.getString(cursor.getColumnIndex("cintura"))));
            formularioNutricionista.setQuadril((cursor.getString(cursor.getColumnIndex("quadril"))));
            formularioNutricionista.setBracos((cursor.getString(cursor.getColumnIndex("bracos"))));
            formularioNutricionista.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            formulariosNutricionista.add(formularioNutricionista);
        }

        cursor.close();

        return formulariosNutricionista;
    }
}
