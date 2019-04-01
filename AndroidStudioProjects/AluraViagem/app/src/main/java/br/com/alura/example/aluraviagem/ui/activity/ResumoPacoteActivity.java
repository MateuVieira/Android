package br.com.alura.example.aluraviagem.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.DiasUtil;
import br.com.alura.example.aluraviagem.Util.FormatadorDeDataUtil;
import br.com.alura.example.aluraviagem.Util.ImagemUtil;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
import br.com.alura.example.aluraviagem.models.Pacote;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR_RESUMO = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITLE_APPBAR_RESUMO);

        Pacote pacote = new Pacote("São Paulo",
                    "sao_paulo_sp",
                    2,
                    new BigDecimal(243.99));

        preencheImagem(pacote.getImagem(), R.id.resumo_pacote_imagem);
        preencheLocal(pacote.getLocal(), R.id.resumo_pacote_text_local);
        preencheDia(pacote.getDias(), R.id.resumo_pacote_text_dias);
        preenchePreco(pacote.getPreco(), R.id.resumo_pacote_text_preco);
        preencheData(pacote.getDias(), R.id.resumo_pacote_text_data);

        Intent intent = new Intent(this, PagamentoPacoteActivity.class);
        startActivity(intent);

    }

    private void preencheData(int dia, int id) {
        TextView pacoteData = findViewById(id);
        pacoteData.setText(FormatadorDeDataUtil.formataData(dia));
    }

    private void preenchePreco(BigDecimal preco, int id) {
        TextView pacotePreco = findViewById(id);
        pacotePreco.setText(MoedaUtil.precoFormatacaoBrasileira(preco));
    }

    private void preencheDia(int dia, int id) {
        TextView pacoteDias = findViewById(id);
        pacoteDias.setText(DiasUtil.diasEmTexto(dia));
    }

    private void preencheLocal(String local, int id) {
        TextView pacoteLocal = findViewById(id);
        pacoteLocal.setText(local);
    }

    private void preencheImagem(String image, int id) {
        ImageView pacoteImage = findViewById(id);
        pacoteImage.setImageDrawable(ImagemUtil.getDrawableImage(image, this));
    }
}
