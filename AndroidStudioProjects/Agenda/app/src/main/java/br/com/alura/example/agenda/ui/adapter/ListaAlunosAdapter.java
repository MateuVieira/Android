package br.com.alura.example.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.example.agenda.R;
import br.com.alura.example.agenda.models.Aluno;

public class ListaAlunosAdapter  extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = configuraView(parent);
        vinculaDadosAlunoNaView(position, view);
        return view;
    }

    private View configuraView(ViewGroup parent) {
        return LayoutInflater.from(context)
                    .inflate(R.layout.item_aluno, parent, false);
    }

    private void vinculaDadosAlunoNaView(int position, View view) {
        Aluno aluno = alunos.get(position);

        TextView nome = view.findViewById(R.id.item_aluno_nome);
        nome.setText(aluno.getNome());

        TextView telefone = view.findViewById(R.id.item_aluno_telefone);
        telefone.setText(aluno.getTelefone());
    }

    private void clear() {
        this.alunos.clear();
    }

    private void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void atualiza( List<Aluno> alunos) {
        this.clear();
        this.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        this.alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
