package br.com.alura.example.agenda.dao;

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

        Aluno alunoEncontrado = buscaAlunoPorId(aluno);

        if(alunoEncontrado != null){
            int posicao = alunos.indexOf(alunoEncontrado);
            alunos.set(posicao, aluno);
        }
    }

    private Aluno buscaAlunoPorId(Aluno aluno) {
        for (Aluno a: alunos) {

            boolean validation = a.getId().intValue() == aluno.getId().intValue();
            if(validation){
                return  a;
            }
        }
        return null;
    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPorId(aluno);
        if (alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }
    }
}
