package com.example.victo.acorde.Nutricionista;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.victo.acorde.EducadoraFisica.EducadoraFisica;

public class NutricionistaDAO extends SQLiteOpenHelper{

    public NutricionistaDAO(Context context){
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
                "    peso TEXT NOT NULL, " +
                "    altura TEXT NOT NULL, " +
                "    imc TEXT NOT NULL, " +
                "    cintura TEXT NOT NULL, " +
                "    quadril TEXT NOT NULL, " +
                "    bracos TEXT NOT NULL, " +
                "    alimentar TEXT NOT NULL, " +
                "    servir TEXT NOT NULL, " +
                "    qtdAlimento TEXT NOT NULL, " +
                "    preparar TEXT NOT NULL, " +
                "    patologia TEXT NOT NULL, " +
                "    habitoIntestinal TEXT NOT NULL, " +
                "    intoleranciAlimentar TEXT NOT NULL, " +
                "    alergiaAlimentar TEXT NOT NULL, " +
                "    preferenciaAlimentar TEXT NOT NULL, " +
                "    observacao TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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

    private ContentValues pegaDadosRelatorioNU(Nutricionista nu) {
        ContentValues dados = new ContentValues();

        /*VERIFICAR AQUI*/
        dados.put("data", nu.getData().toString());
        dados.put("tipoAtendimento", nu.getTipoAtendimento());
        dados.put("motivo", nu.getMotivo());
        dados.put("impressoes", nu.getImpressoes());
        dados.put("encaminhamento", nu.getEncaminhamento());
        dados.put("profissional", nu.getProfissional());
        dados.put("nome", nu.getNome());
        dados.put("dataNascimento", nu.getDataNascimento().toString());
        dados.put("diagnostico", nu.getDiagnostico());
        dados.put("peso", nu.getPeso());
        dados.put("altura", nu.getAltura());
        dados.put("imc", nu.getImc());
        dados.put("cintura", nu.getCintura());
        dados.put("quadril", nu.getQuadril());
        dados.put("bracos", nu.getBracos());
        dados.put("alimentar", nu.getAlimentar());
        dados.put("servir", nu.getServir());
        dados.put("qtdAlimento", nu.getQtdAlimento());
        dados.put("preparar", nu.getPreparar());
        dados.put("patologia", nu.getPatologia());
        dados.put("habitoIntestinal", nu.getHabitoIntestinal());
        dados.put("intoleranciAlimentar", nu.getIntoleranciAlimentar());
        dados.put("alergiaAlimentar", nu.getAlergiaAlimentar());
        dados.put("preferenciaAlimentar", nu.getPreferenciaAlimentar());
        dados.put("observacao", nu.getObservacao());

        return dados;
    }
}
