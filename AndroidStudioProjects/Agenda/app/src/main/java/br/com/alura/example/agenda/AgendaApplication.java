package br.com.alura.example.agenda;

import android.app.Application;

import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.salva(new Aluno("Alex", "123", "teste1@gmail.com"));
        alunoDAO.salva(new Aluno("Fran", "1234", "teste2@gmail.com"));
        alunoDAO.salva(new Aluno("Nico", "12345", "teste3@gmail.com"));
    }
}
