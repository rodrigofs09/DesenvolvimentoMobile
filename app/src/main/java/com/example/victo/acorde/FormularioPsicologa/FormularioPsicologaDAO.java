package com.example.victo.acorde.FormularioPsicologa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FormularioPsicologaDAO extends SQLiteOpenHelper {

    public FormularioPsicologaDAO(Context context) {
        super(context, "Acorde", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS FormularioPsicologa (" +
                "    id INTEGER PRIMARY KEY, " +
                "    dataAtendimento VARCHAR," +
                "    nomeAssistido VARCHAR, " +
                "    idadeAssistido VARCHAR, " +
                "    categoriaAtendimento INTEGER, " +
                "    individualTipo INTEGER, " +
                "    aspectoTipoEmocional INTEGER, " +
                "    aspectoTipoAcupuntura INTEGER, " +
                "    temaGrupal INTEGER, " +
                "    encaminhamentoAcorde INTEGER, " +
                "    encaminhamentoExterno INTEGER, " +
                "    atendimentoFamiliarCuidador INTEGER, " +
                "    visitaDomiciliar INTEGER, " +
                "    observacao VARCHAR); ";
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

    public void insereFormularioPSI(FormularioPsicologa psi) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosFormularioPSI(psi);
        db.insert("FormularioPsicologa", null, dados);
    }

    public void alteraFormularioPSI(FormularioPsicologa psi) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosFormularioPSI(psi);
        String[] params = {psi.getId().toString()};
        db.update("FormularioPsicologa", dados, "id = ?", params);
    }

    public void deletaFormularioPSI(FormularioPsicologa psi) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {psi.getId().toString()};
        db.delete("FormularioPsicologa", "id = ?", params);
    }

    private ContentValues pegaDadosFormularioPSI(FormularioPsicologa formularioPsicologa) {
        ContentValues dados = new ContentValues();

        dados.put("dataAtendimento", formularioPsicologa.getDataAtendimento());
        dados.put("nomeAssistido", formularioPsicologa.getNomeAssistido());
        dados.put("idadeAssistido", formularioPsicologa.getIdadeAssistido());
        dados.put("categoriaAtendimento", formularioPsicologa.getCategoriaAtendimento());
        dados.put("individualTipo", formularioPsicologa.getIndividualTipo());
        dados.put("aspectoTipoEmocional", formularioPsicologa.getTipoEmocionalAspectos());
        dados.put("aspectoTipoAcupuntura", formularioPsicologa.getTipoAcupunturaAspectos());
        dados.put("temaGrupal", formularioPsicologa.getTemaGrupal());
        dados.put("encaminhamentoAcorde", formularioPsicologa.getEncaminhamentoAcorde());
        dados.put("encaminhamentoExterno", formularioPsicologa.getEncaminhamentoExterno());
        dados.put("atendimentoFamiliarCuidador", formularioPsicologa.getAtendimentoFamiliaCuidadores());
        dados.put("visitaDomiciliar", formularioPsicologa.getVisitasDomiciliares());
        dados.put("observacao", formularioPsicologa.getObservacao());

        return dados;
    }

    public List<FormularioPsicologa> buscaFormularioPSI() {

        String sql = "SELECT * FROM FormularioPsicologa;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<FormularioPsicologa> formulariosPsicologa = new ArrayList<>();

        while (cursor.moveToNext()) {

            FormularioPsicologa formularioPsicologa = new FormularioPsicologa();
            formularioPsicologa.setId(cursor.getLong(cursor.getColumnIndex("id")));
            formularioPsicologa.setDataAtendimento((cursor.getString(cursor.getColumnIndex("dataAtendimento"))));
            formularioPsicologa.setNomeAssistido((cursor.getString(cursor.getColumnIndex("nomeAssistido"))));
            formularioPsicologa.setIdadeAssistido((cursor.getString(cursor.getColumnIndex("idadeAssistido"))));
            formularioPsicologa.setCategoriaAtendimento((cursor.getInt(cursor.getColumnIndex("categoriaAtendimento"))));
            formularioPsicologa.setIndividualTipo((cursor.getInt(cursor.getColumnIndex("individualTipo"))));
            formularioPsicologa.setTipoEmocionalAspectos((cursor.getInt(cursor.getColumnIndex("aspectoTipoEmocional"))));
            formularioPsicologa.setTipoAcupunturaAspectos((cursor.getInt(cursor.getColumnIndex("aspectoTipoAcupuntura"))));
            formularioPsicologa.setTemaGrupal((cursor.getInt(cursor.getColumnIndex("temaGrupal"))));
            formularioPsicologa.setEncaminhamentoAcorde((cursor.getInt(cursor.getColumnIndex("encaminhamentoAcorde"))));
            formularioPsicologa.setEncaminhamentoExterno((cursor.getInt(cursor.getColumnIndex("encaminhamentoExterno"))));
            formularioPsicologa.setAtendimentoFamiliaCuidadores((cursor.getInt(cursor.getColumnIndex("atendimentoFamiliarCuidador"))));
            formularioPsicologa.setVisitasDomiciliares((cursor.getInt(cursor.getColumnIndex("visitaDomiciliar"))));
            formularioPsicologa.setObservacao((cursor.getString(cursor.getColumnIndex("observacao"))));

            formulariosPsicologa.add(formularioPsicologa);
        }

        cursor.close();

        return formulariosPsicologa;
    }
}
