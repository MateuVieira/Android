package br.com.alura.example.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.Nullable;
import br.com.alura.example.agenda.models.Aluno;

import static br.com.alura.example.agenda.dao.ConstantesDAO.DAO_DATABASE_NAME;
import static br.com.alura.example.agenda.dao.ConstantesDAO.DAO_DB_TABLE_ALUNOS;
import static br.com.alura.example.agenda.dao.ConstantesDAO.DAO_DB_TABLE_ALUNOS_EMAIL;
import static br.com.alura.example.agenda.dao.ConstantesDAO.DAO_DB_TABLE_ALUNOS_ID;
import static br.com.alura.example.agenda.dao.ConstantesDAO.DAO_DB_TABLE_ALUNOS_NOME;
import static br.com.alura.example.agenda.dao.ConstantesDAO.DAO_DB_TABLE_ALUNOS_TELEFONE;

public class AlunoDAO  extends SQLiteOpenHelper {

    private final static List<Aluno> alunos = new LinkedList<>();
    private static Integer contadorId = 1;

    public AlunoDAO(@Nullable Context context) {
        super(context, DAO_DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + DAO_DB_TABLE_ALUNOS + " ( " +
                DAO_DB_TABLE_ALUNOS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                DAO_DB_TABLE_ALUNOS_NOME + " VARCHAR(100)," +
                DAO_DB_TABLE_ALUNOS_TELEFONE + " VARCHAR(12)," +
                DAO_DB_TABLE_ALUNOS_EMAIL + " VARCHAR(100));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + DAO_DB_TABLE_ALUNOS + ";";
        db.execSQL(sql);
        onCreate(db);
    }

    public void salva(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(DAO_DB_TABLE_ALUNOS,null, dadosContentValuesInsert(aluno));
        db.close();
    }

    private ContentValues dadosContentValuesInsert(Aluno aluno) {
        ContentValues dados = new ContentValues();
        dados.put(DAO_DB_TABLE_ALUNOS_NOME, aluno.getNome());
        dados.put(DAO_DB_TABLE_ALUNOS_TELEFONE, aluno.getTelefone());
        dados.put(DAO_DB_TABLE_ALUNOS_EMAIL, aluno.getEmail());
        return dados;
    }

    public List<Aluno> todos() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor query = buscaAlunosBD(db);
        List<Aluno> alunos = new ArrayList<>();
        populaListaAluno(query, alunos);
        query.close();
        db.close();

        return alunos;
    }

    private Cursor buscaAlunosBD(SQLiteDatabase db) {
        String sql = "SELECT * FROM Alunos ORDER BY " + DAO_DB_TABLE_ALUNOS_NOME;

        return db.rawQuery(sql, null);
    }

    public void remove(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        queryDelete(aluno, db);
        db.close();
    }

    public void edita(Aluno aluno){
        SQLiteDatabase db = getWritableDatabase();
        updateInfoDAOAluno(aluno, db);
        db.close();
    }

    private void queryDelete(Aluno aluno, SQLiteDatabase db) {
        String where = DAO_DB_TABLE_ALUNOS_ID + " = " + aluno.getId();
        db.delete(DAO_DB_TABLE_ALUNOS,
                where,null);
    }

    private void updateInfoDAOAluno(Aluno aluno, SQLiteDatabase db) {
        String where = DAO_DB_TABLE_ALUNOS_ID + " == " + aluno.getId();
        db.update(DAO_DB_TABLE_ALUNOS,
                dadosContentValuesInsert(aluno),
                  where, null);
    }

    private void populaListaAluno(Cursor query, List<Aluno> alunos) {
        while (query.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setid(query.getInt(query.getColumnIndex(DAO_DB_TABLE_ALUNOS_ID)));
            aluno.setNome(query.getString(query.getColumnIndex(DAO_DB_TABLE_ALUNOS_NOME)));
            aluno.setTelefone(query.getString(query.getColumnIndex(DAO_DB_TABLE_ALUNOS_TELEFONE)));
            aluno.setEmail(query.getString(query.getColumnIndex(DAO_DB_TABLE_ALUNOS_EMAIL)));
            alunos.add(aluno);
        }
    }
}
