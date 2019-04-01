package br.com.alura.example.aluraviagem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.DiasUtil;
import br.com.alura.example.aluraviagem.Util.FormatadorDeDataUtil;
import br.com.alura.example.aluraviagem.Util.ImagemUtil;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
import br.com.alura.example.aluraviagem.Util.PreencheUtil;
import br.com.alura.example.aluraviagem.models.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context contex;

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
        Pacote pacote = pacotes.get(position);
        preenchendoListView(viewCriada, pacote);
        return viewCriada;
    }

    private void preenchendoListView(View viewCriada, Pacote pacote) {
        PreencheUtil.preencheLocal(viewCriada, pacote.getLocal(), R.id.item_pacote_text_local);
        PreencheUtil.preencheImagem(viewCriada, pacote.getImagem(), R.id.item_pacote_image_local, contex);
        PreencheUtil.preencheDia(viewCriada, pacote.getDias(), R.id.item_pacote_text_dias);
        PreencheUtil.preenchePreco(viewCriada, pacote.getPreco(), R.id.item_pacote_text_valor);
    }

}
