package com.example.victo.acorde.Nutricionista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.victo.acorde.EducadoraFisica.EducadoraFisica;

import java.util.ArrayList;
import java.util.List;

public class NutricionistaDAO extends SQLiteOpenHelper{

    public NutricionistaDAO(Context context){
        super(context,"Acorde", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS Nutricionista (" +
                "    id INTEGER PRIMARY KEY, " +
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
        db.execSQL("DROP TABLE IF EXISTS" + " NUTRICIONISTA");
        onCreate(db);
    }

    public void insereRelatorioNU(Nutricionista nu) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioNU(nu);
        db.insert("Nutricionista", null, dados);
    }

    public void alteraRelatorioNU(Nutricionista nu) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioNU(nu);
        String[] params = {nu.getId().toString()};
        db.update("Nutricionista", dados, "id = ?", params);
    }

    public void deletaRelatorioNU(Nutricionista nu) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {nu.getId().toString()};
        db.delete("Nutricionista", "id = ?", params);
    }

    private ContentValues pegaDadosRelatorioNU(Nutricionista nutricionista) {
        ContentValues dados = new ContentValues();

        dados.put("nomeAssistido", nutricionista.getNomeAssistido());
        dados.put("motivoAtendimento", nutricionista.getMotivoAtendimento());
        dados.put("encaminhamento", nutricionista.getEncaminhamento());
        dados.put("altura", nutricionista.getAltura());
        dados.put("peso", nutricionista.getPeso());
        dados.put("cintura", nutricionista.getCintura());
        dados.put("quadril", nutricionista.getQuadril());
        dados.put("bracos", nutricionista.getBracos());
        dados.put("alimentarSozinho", nutricionista.getAlimentarSozinho());
        dados.put("servirSozinho", nutricionista.getServirSozinho());
        dados.put("qtdAlimento", nutricionista.getQtdAlimento());
        dados.put("prepararSozinho", nutricionista.getPrepararSozinho());
        dados.put("habitoIntestinal", nutricionista.getHabitoIntestinal());
        dados.put("mastigacao", nutricionista.getMastigacao());
        dados.put("patologia", nutricionista.getPatologia());
        dados.put("intoleranciAlimentar", nutricionista.getIntoleranciAlimentar());
        dados.put("alergiaAlimentar", nutricionista.getAlergiaAlimentar());
        dados.put("preferenciaAlimentar", nutricionista.getPreferenciaAlimentar());
        dados.put("naoConsome", nutricionista.getNaoConsome());
        dados.put("observacao", nutricionista.getObservacao());

        return dados;
    }

    public List<Nutricionista> buscaRelatorioNU() {

        String sql = "SELECT * FROM Nutricionista;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Nutricionista> nutricionistas = new ArrayList<Nutricionista>();

        while(cursor.moveToNext()){

            Nutricionista nutricionista = new Nutricionista();
            nutricionista.setId(cursor.getLong(cursor.getColumnIndex("id")));
            nutricionista.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            nutricionista.setMotivoAtendimento((cursor.getString(cursor.getColumnIndex("motivoAtendimento"))));
            nutricionista.setEncaminhamento((cursor.getString(cursor.getColumnIndex("encaminhamento"))));
            nutricionista.setAltura((cursor.getString(cursor.getColumnIndex("altura"))));
            nutricionista.setPeso((cursor.getString(cursor.getColumnIndex("peso"))));
            nutricionista.setCintura((cursor.getString(cursor.getColumnIndex("cintura"))));
            nutricionista.setQuadril((cursor.getString(cursor.getColumnIndex("quadril"))));
            nutricionista.setBracos((cursor.getString(cursor.getColumnIndex("bracos"))));
            nutricionista.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            nutricionistas.add(nutricionista);
        }

        cursor.close();

        return nutricionistas;
    }
}
