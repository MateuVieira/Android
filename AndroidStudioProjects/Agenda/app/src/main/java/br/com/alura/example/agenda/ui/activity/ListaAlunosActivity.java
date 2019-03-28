package br.com.alura.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    private  final AlunoDAO dao = new AlunoDAO();
    public static final String TITLE_APPBAR = "Lista de alunos";

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
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
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

        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos)
        );

        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoEcolhido = alunos.get(position);
                Intent vaiParaFormularioAluno = new Intent(ListaAlunosActivity.this,
                                                                    FormularioAlunoActivity.class);
                vaiParaFormularioAluno.putExtra("aluno", alunoEcolhido);
                startActivity(vaiParaFormularioAluno);
            }
        });
    }
}
