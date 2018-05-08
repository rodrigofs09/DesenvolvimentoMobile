package com.example.victo.acorde.Psicopedagoga;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PsicopedagogaDAO extends SQLiteOpenHelper{

    public PsicopedagogaDAO(Context context){
        super(context,"Acorde", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Psicopedagoga (" +
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
                "    raciocinioLogico TEXT NOT NULL, " +
                "    comunicacao TEXT NOT NULL, " +
                "    compreensaoComplexas TEXT NOT NULL, " +
                "    quadril TEXT NOT NULL, " +
                "    observacao TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insereRelatorioPP(Psicopedagoga pp) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioPP(pp);
        db.insert("Psicopedagoga", null, dados);
    }

    public void alteraRelatorioPP(Psicopedagoga pp) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRelatorioPP(pp);
        String[] params = {pp.getId().toString()};
        db.update("Psicopedagoga", dados, "id = ?", params);
    }

    public void deletaRelatorioPP(Psicopedagoga pp) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {pp.getId().toString()};
        db.delete("Psicopedagoga", "id = ?", params);
    }

    private ContentValues pegaDadosRelatorioPP(Psicopedagoga pp) {
        ContentValues dados = new ContentValues();

        /*VERIFICAR AQUI*/
        dados.put("data", pp.getData().toString());
        dados.put("tipoAtendimento", pp.getTipoAtendimento());
        dados.put("motivo", pp.getMotivo());
        dados.put("impressoes", pp.getImpressoes());
        dados.put("encaminhamento", pp.getEncaminhamento());
        dados.put("profissional", pp.getProfissional());
        dados.put("nome", pp.getNome());
        dados.put("dataNascimento", pp.getDataNascimento().toString());
        dados.put("raciocinioLogico", pp.getRaciocinioLogico());
        dados.put("comunicacao", pp.getComunicacao());
        dados.put("compreensaoComplexas", pp.getCompreensaoComplexas());
        dados.put("observacao", pp.getObservacao());

        return dados;
    }
}
