package br.com.alura.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;

import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;
import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.TITLE_APPBAR;

public class ListaAlunosActivity extends AppCompatActivity {

    private  final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITLE_APPBAR);
        configurandoFloatingButtonAdicionaAluno();

    }

    private void configurandoFloatingButtonAdicionaAluno() {
        FloatingActionButton fabAdd = findViewById(R.id.activity_lista_alunos_fab_Add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioInseriAluno();
            }
        });
    }

    private void abreFormularioInseriAluno() {
        startActivity(new Intent(ListaAlunosActivity.this,
                                FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunos();
    }

    private void listaAlunos() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listwiew);
        final List<Aluno> alunos = dao.todos();
        configuraAdapter(listaDeAlunos, alunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoEcolhido = (Aluno) parent.getItemAtPosition(position);
                abreFormularioEditaAluno(alunoEcolhido);
            }
        });
    }

    private void abreFormularioEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioAluno = new Intent(ListaAlunosActivity.this,
                                                            FormularioAlunoActivity.class);
        vaiParaFormularioAluno.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioAluno);
    }

    private void configuraAdapter(ListView listaDeAlunos, List<Aluno> alunos) {
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos)
        );
    }
}
