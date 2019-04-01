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

        preencheImagem(pacote);
        preencheLocal(pacote);
        preencheDia(pacote);
        preenchePreco(pacote);
        preencheData(pacote);

        Intent intent = new Intent(this, PagamentoPacoteActivity.class);
        startActivity(intent);

    }

    private void preencheData(Pacote pacote) {
        TextView pacoteData = findViewById(R.id.resumo_pacote_text_data);
        pacoteData.setText(FormatadorDeDataUtil.formataData(pacote.getDias()));
    }

    private void preenchePreco(Pacote pacote) {
        TextView pacotePreco = findViewById(R.id.resumo_pacote_text_preco);
        pacotePreco.setText(MoedaUtil.precoFormatacaoBrasileira(pacote.getPreco()));
    }

    private void preencheDia(Pacote pacote) {
        TextView pacoteDias = findViewById(R.id.resumo_pacote_text_dias);
        pacoteDias.setText(DiasUtil.diasEmTexto(pacote.getDias()));
    }

    private void preencheLocal(Pacote pacote) {
        TextView pacoteLocal = findViewById(R.id.resumo_pacote_text_local);
        pacoteLocal.setText(pacote.getLocal());
    }

    private void preencheImagem(Pacote pacote) {
        ImageView pacoteImage = findViewById(R.id.resumo_pacote_imagem);
        pacoteImage.setImageDrawable(ImagemUtil.getDrawableImage(pacote.getImagem(), this));
    }
}
