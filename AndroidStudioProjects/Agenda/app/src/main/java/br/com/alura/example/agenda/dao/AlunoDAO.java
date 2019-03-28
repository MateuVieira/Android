package br.com.alura.example.agenda.dao;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.alura.example.agenda.models.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new LinkedList<>();
    private static Integer contadorId = 1;

    public void salva(Aluno aluno) {

        aluno.setid(contadorId);
        alunos.add(aluno);
        contadorId++;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void edita(Aluno aluno){

        Aluno alunoEncontrado = null;
        for (Aluno a: alunos) {

            Boolean validation = a.getId().intValue() == aluno.getId().intValue();
            if(validation){
                alunoEncontrado = a;
                break;
            }
        }

        if(alunoEncontrado != null){
            int posicao = alunos.indexOf(alunoEncontrado);
            alunos.set(posicao, aluno);
        }
    }
}
