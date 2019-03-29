package br.com.alura.example.agenda.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;
import br.com.alura.example.agenda.ui.adapter.ListaAlunosAdapter;

import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;
import static br.com.alura.example.agenda.ui.activity.ConstantesActivities.TITLE_APPBAR_AGENDA;

public class ListaAlunosActivity extends AppCompatActivity {

    private  final AlunoDAO dao = new AlunoDAO();
    private ListaAlunosAdapter adapter;



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
            confirmaRemocao(item);
        }
        return super.onContextItemSelected(item);
    }

    private void confirmaRemocao(final MenuItem item) {
        new AlertDialog.Builder(this)
                .setTitle("Removendo Aluno")
                .setMessage("Tem certeza que quer remover o aluno?")
                .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)
                                item.getMenuInfo();
                        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                        remove(alunoEscolhido);
                    }
                })
                .setNegativeButton("não", null)
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.atualiza(dao.todos());

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

    private void listaAlunos() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listwiew);
        configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }


    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
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

    private void configuraAdapter(ListView listaDeAlunos) {


        adapter = new ListaAlunosAdapter(this);
        listaDeAlunos.setAdapter(adapter);
        
    }
}
