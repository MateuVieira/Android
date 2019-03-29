package br.com.alura.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.models.Aluno;
import br.com.alura.example.agenda.ui.ListaAlunosView;

import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;
import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.TITLE_APPBAR_AGENDA;

public class ListaAlunosActivity extends AppCompatActivity {


    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITLE_APPBAR_AGENDA);
        configurandoFloatingButtonAdicionaAluno();
        listaAlunos();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        if( itemId == R.id.activity_lista_alunos_menu_remover) {
            listaAlunosView.confirmaRemocao(item);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualiza();

    }

    private void configurandoFloatingButtonAdicionaAluno() {
        FloatingActionButton fabAdd = findViewById(R.id.activity_lista_alunos_fab_Add);
        fabAdd.setOnClickListener(v -> abreFormularioInseriAluno());
    }

    private void abreFormularioInseriAluno() {
        startActivity(new Intent(ListaAlunosActivity.this,
                                FormularioAlunoActivity.class));
    }

    private void listaAlunos() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listwiew);
        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((parent, view, position, id) -> {
            Aluno alunoEcolhido = (Aluno) parent.getItemAtPosition(position);
            abreFormularioEditaAluno(alunoEcolhido);
        });
    }

    private void abreFormularioEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioAluno = new Intent(ListaAlunosActivity.this,
                                                            FormularioAlunoActivity.class);
        vaiParaFormularioAluno.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioAluno);
    }


}
