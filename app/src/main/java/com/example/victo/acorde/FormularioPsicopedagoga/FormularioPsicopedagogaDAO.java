package com.example.victo.acorde.FormularioPsicopedagoga;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FormularioPsicopedagogaDAO extends SQLiteOpenHelper {

    public FormularioPsicopedagogaDAO(Context context) {
        super(context, "Acorde", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS FormularioPsicopedagoga (" +
                "    id INTEGER PRIMARY KEY, " +
                "    dataAtendimento VARCHAR," +
                "    nomeAssistido VARCHAR, " +
                "    motivoAtendimento VARCHAR, " +
                "    encaminhamento INTEGER, " +
                "    tipoAtendimento INTEGER, " +
                "    aspectosTrabalhados INTEGER, " +
                "    aspectosTrabalhadosAcupuntura INTEGER, " +
                "    atividadesLudicasLeitura INTEGER, " +
                "    atividadesCoordenacaoSurtiramEfeito INTEGER, " +
                "    avaliacoesObtiveramResultadosPositivos INTEGER, " +
                "    planejamentoSeguePercursoEsperado INTEGER, " +
                "    materiaisSaoSuficientesParaAtividades INTEGER, " +
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

    public void insereFormularioNU(FormularioPsicopedagoga nu) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosFormularioNU(nu);
        db.insert("FormularioPsicopedagoga", null, dados);
    }

    public void alteraFormularioNU(FormularioPsicopedagoga nu) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosFormularioNU(nu);
        String[] params = {nu.getId().toString()};
        db.update("FormularioPsicopedagoga", dados, "id = ?", params);
    }

    public void deletaFormularioNU(FormularioPsicopedagoga nu) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {nu.getId().toString()};
        db.delete("FormularioPsicopedagoga", "id = ?", params);
    }

    private ContentValues pegaDadosFormularioNU(FormularioPsicopedagoga formularioPsicopedagoga) {
        ContentValues dados = new ContentValues();

        dados.put("dataAtendimento", formularioPsicopedagoga.getDataAtendimento());
        dados.put("nomeAssistido", formularioPsicopedagoga.getNomeAssistido());
        dados.put("motivoAtendimento", formularioPsicopedagoga.getMotivoAtendimento());
        dados.put("encaminhamento", formularioPsicopedagoga.getEncaminhamento());

        dados.put("tipoAtendimento", formularioPsicopedagoga.getTipoAtendimento());
        dados.put("aspectosTrabalhados", formularioPsicopedagoga.getAspectosTrabalhados());
        dados.put("aspectosTrabalhadosAcupuntura", formularioPsicopedagoga.getAspectosTrabalhadosAcupuntura());
        dados.put("atividadesLudicasLeitura", formularioPsicopedagoga.getAtividadesLudicasLeitura());
        dados.put("atividadesCoordenacaoSurtiramEfeito", formularioPsicopedagoga.getAtividadesCoordenacaoSurtiramEfeito());
        dados.put("avaliacoesObtiveramResultadosPositivos", formularioPsicopedagoga.getAvaliacoesObtiveramResultadosPositivos());
        dados.put("planejamentoSeguePercursoEsperado", formularioPsicopedagoga.getPlanejamentoSeguePercursoEsperado());
        dados.put("materiaisSaoSuficientesParaAtividades", formularioPsicopedagoga.getMateriaisSaoSuficientesParaAtividades());

        dados.put("observacao", formularioPsicopedagoga.getObservacao());

        return dados;
    }

    public List<FormularioPsicopedagoga> buscaFormularioNU() {

        String sql = "SELECT * FROM FormularioPsicopedagoga;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<FormularioPsicopedagoga> formulariosPsicopedagoga = new ArrayList<>();

        while (cursor.moveToNext()) {

            FormularioPsicopedagoga formularioPsicopedagoga = new FormularioPsicopedagoga();

            formularioPsicopedagoga.setId(cursor.getLong(cursor.getColumnIndex("id")));
            formularioPsicopedagoga.setDataAtendimento((cursor.getString(cursor.getColumnIndex("dataAtendimento"))));
            formularioPsicopedagoga.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            formularioPsicopedagoga.setMotivoAtendimento((cursor.getString(cursor.getColumnIndex("motivoAtendimento"))));
            formularioPsicopedagoga.setEncaminhamento((cursor.getString(cursor.getColumnIndex("encaminhamento"))));

            formularioPsicopedagoga.setTipoAtendimento((cursor.getInt(cursor.getColumnIndex("tipoAtendimento"))));
            formularioPsicopedagoga.setAspectosTrabalhados((cursor.getInt(cursor.getColumnIndex("aspectosTrabalhados"))));
            formularioPsicopedagoga.setAspectosTrabalhadosAcupuntura((cursor.getInt(cursor.getColumnIndex("aspectosTrabalhadosAcupuntura"))));
            formularioPsicopedagoga.setAtividadesLudicasLeitura((cursor.getInt(cursor.getColumnIndex("atividadesLudicasLeitura"))));
            formularioPsicopedagoga.setAtividadesCoordenacaoSurtiramEfeito((cursor.getInt(cursor.getColumnIndex("atividadesCoordenacaoSurtiramEfeito"))));
            formularioPsicopedagoga.setAvaliacoesObtiveramResultadosPositivos((cursor.getInt(cursor.getColumnIndex("avaliacoesObtiveramResultadosPositivos"))));
            formularioPsicopedagoga.setPlanejamentoSeguePercursoEsperado((cursor.getInt(cursor.getColumnIndex("planejamentoSeguePercursoEsperado"))));
            formularioPsicopedagoga.setMateriaisSaoSuficientesParaAtividades((cursor.getInt(cursor.getColumnIndex("materiaisSaoSuficientesParaAtividades"))));

            formularioPsicopedagoga.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            formulariosPsicopedagoga.add(formularioPsicopedagoga);
        }

        cursor.close();

        return formulariosPsicopedagoga;
    }
}
