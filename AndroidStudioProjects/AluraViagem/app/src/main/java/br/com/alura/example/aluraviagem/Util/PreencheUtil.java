package br.com.alura.example.aluraviagem.Util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

public class PreencheUtil {

    public static void preencheData(View viewCriada, int dia, int id) {
        TextView pacoteData = viewCriada.findViewById(id);
        pacoteData.setText(FormatadorDeDataUtil.formataData(dia));
    }

    public static void preenchePreco(View viewCriada, BigDecimal preco, int id) {
        TextView pacotePreco = viewCriada.findViewById(id);
        pacotePreco.setText(MoedaUtil.precoFormatacaoBrasileira(preco));
    }

    public static void preencheDia(View viewCriada, int dia, int id) {
        TextView pacoteDias = viewCriada.findViewById(id);
        pacoteDias.setText(DiasUtil.diasEmTexto(dia));
    }

    public static void preencheLocal(View viewCriada, String local, int id) {
        TextView pacoteLocal = viewCriada.findViewById(id);
        pacoteLocal.setText(local);
    }

    public static void preencheImagem(View viewCriada, String image, int id, Context contex) {
        ImageView pacoteImage = viewCriada.findViewById(id);
        pacoteImage.setImageDrawable(ImagemUtil.getDrawableImage(image, contex));
    }


}
