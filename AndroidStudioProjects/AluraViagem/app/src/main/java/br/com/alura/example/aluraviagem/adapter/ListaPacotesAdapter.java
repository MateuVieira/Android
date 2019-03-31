package br.com.alura.example.aluraviagem.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.DiasUtil;
import br.com.alura.example.aluraviagem.Util.ImagemUtil;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
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
        preencheLocal(viewCriada, pacote);
        preencheImagem(viewCriada, pacote);
        preencheDias(viewCriada, pacote);
        preenchePreco(viewCriada, pacote);
    }

    private void preenchePreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_text_valor);
        preco.setText(MoedaUtil.precoFormatacaoBrasileira(pacote.getPreco()));
    }

    private void preencheDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_text_dias);
        dias.setText(DiasUtil.diasEmTexto(pacote.getDias()));
    }

    private void preencheImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_image_local);
        imagem.setImageDrawable(ImagemUtil.getDrawableImage(pacote.getImagem(), contex));
    }

    private void preencheLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_text_local);
        local.setText(pacote.getLocal());
    }



}
