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
        Pacote pacote = pacotes.get(position);

        TextView local = viewCriada.findViewById(R.id.item_pacote_text_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_image_local);
        imagem.setImageDrawable(getDrawableImage(pacote));

        TextView dias = viewCriada.findViewById(R.id.item_pacote_text_dias);
        dias.setText(diasEmTexto(pacote));

        TextView preco = viewCriada.findViewById(R.id.item_pacote_text_valor);
        preco.setText(precoFormatacaoBrasileira(pacote));

        return viewCriada;
    }

    private Drawable getDrawableImage(Pacote pacote) {
        Resources resources = contex.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(),
                "drawable",
                contex.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }

    private String precoFormatacaoBrasileira(Pacote pacote) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                                            new Locale("pt", "br"));
        BigDecimal precoPacote = pacote.getPreco();
        return formatoBrasileiro.format(precoPacote).replace("R$", "R$ ");
    }

    private String diasEmTexto(Pacote pacote) {
        int quantidaDeDias = pacote.getDias();
        String diasTexto = "";

        if(quantidaDeDias > 1){
            diasTexto = quantidaDeDias + " dias";
        } else {
            diasTexto = quantidaDeDias + " dia";
        }
        return diasTexto;
    }
}
