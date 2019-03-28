package br.com.alura.example.agenda.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.alura.example.agenda.models.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new LinkedList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
