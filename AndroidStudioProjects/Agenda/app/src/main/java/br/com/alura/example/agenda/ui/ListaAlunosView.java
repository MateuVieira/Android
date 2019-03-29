package br.com.alura.example.agenda.ui;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.alura.example.agenda.dao.AlunoDAO;
import br.com.alura.example.agenda.models.Aluno;
import br.com.alura.example.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private  final AlunoDAO dao;
    private  final ListaAlunosAdapter adapter;
    private  final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(context);
        this.dao = new AlunoDAO();
    }

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog.Builder(context)
                .setTitle("Removendo Aluno")
                .setMessage("Tem certeza que quer remover o aluno?")
                .setPositiveButton("sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)
                            item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("não", null)
                .show();
    }


    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);

    }

    public  void atualiza(){
        adapter.atualiza(dao.todos());
    }
}
