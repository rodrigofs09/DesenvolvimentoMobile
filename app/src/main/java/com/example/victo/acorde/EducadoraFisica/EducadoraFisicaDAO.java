package com.example.victo.acorde.EducadoraFisica;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EducadoraFisicaDAO extends SQLiteOpenHelper{

    public EducadoraFisicaDAO(Context context){
        super(context,"Acorde", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE EducadoraFisica (" +
                "    id INTEGER PRIMARY KEY, " +
                "    data DATE NOT NULL, " +
                "    tipoAtendimento TEXT, " +
                "    motivo TEXT, " +
                "    impressoes TEXT, " +
                "    encaminhamento TEXT, " +
                "    profissional TEXT NOT NULL, " +
                "    nome TEXT NOT NULL, " +
                "    dataNascimento DATE NOT NULL, " +
                "    diagnostico TEXT NOT NULL, " +
                "    altura TEXT NOT NULL, " +
                "    peso TEXT NOT NULL, " +
                "    cintura TEXT NOT NULL, " +
                "    quadril TEXT NOT NULL, " +
                "    bracos TEXT NOT NULL, " +
                "    imc TEXT NOT NULL, " +
                "    observacao TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insereRelatorioEF(EducadoraFisica ef) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEF(ef);
        db.insert("EducadoraFisica", null, dados);
    }

    public void alteraRelatorioEF(EducadoraFisica ef) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioEF(ef);
        String[] params = {ef.getId().toString()};
        db.update("EducadoraFisica", dados, "id = ?", params);
    }

    public void deletaRelatorioEF(EducadoraFisica ef) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {ef.getId().toString()};
        db.delete("EducadoraFisica", "id = ?", params);
    }

    private ContentValues pegaDadosRelatorioEF(EducadoraFisica ef) {
        ContentValues dados = new ContentValues();

        /*VERIFICAR AQUI*/
        dados.put("data", ef.getData().toString());
        dados.put("tipoAtendimento", ef.getTipoAtendimento());
        dados.put("motivo", ef.getMotivo());
        dados.put("impressoes", ef.getImpressoes());
        dados.put("encaminhamento", ef.getEncaminhamento());
        dados.put("profissional", ef.getProfissional());
        dados.put("nome", ef.getNome());
        dados.put("dataNascimento", ef.getDataNascimento().toString());
        dados.put("diagnostico", ef.getDiagnostico());
        dados.put("altura", ef.getAltura());
        dados.put("peso", ef.getPeso());
        dados.put("cintura", ef.getCintura());
        dados.put("quadril", ef.getQuadril());
        dados.put("bracos", ef.getBracos());
        dados.put("imc", ef.getImc());
        dados.put("observacao", ef.getObservacao());

        return dados;
    }
}
