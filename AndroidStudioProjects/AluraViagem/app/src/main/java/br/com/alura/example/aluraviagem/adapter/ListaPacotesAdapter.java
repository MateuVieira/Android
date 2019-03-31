package br.com.alura.example.aluraviagem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.List;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.models.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context contex;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context contex){

        this.pacotes = pacotes;
        this.contex = contex;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewCriada = LayoutInflater.from(contex)
                            .inflate(R.layout.item_pacote, parent, false);


        return viewCriada;
    }
}
