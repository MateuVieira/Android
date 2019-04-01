package br.com.alura.example.aluraviagem.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.DiasUtil;
import br.com.alura.example.aluraviagem.Util.ImagemUtil;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
import br.com.alura.example.aluraviagem.models.Pacote;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacote = new Pacote("São Paulo",
                    "sao_paulo_sp",
                    2,
                    new BigDecimal(243.99));

        ImageView pacoteImage = findViewById(R.id.resumo_pacote_imagem);
        pacoteImage.setImageDrawable(ImagemUtil.getDrawableImage(pacote.getImagem(), this));

        TextView pacoteLocal = findViewById(R.id.resumo_pacote_text_local);
        pacoteLocal.setText(pacote.getLocal());

        TextView pacoteDias = findViewById(R.id.resumo_pacote_text_dias);
        pacoteDias.setText(DiasUtil.diasEmTexto(pacote.getDias()));

        TextView pacoteData = findViewById(R.id.resumo_pacote_text_data);
        pacoteData.setText("08/12 - 10/12 de 2017");

        TextView pacotePreco = findViewById(R.id.resumo_pacote_text_preco);
        pacotePreco.setText(MoedaUtil.precoFormatacaoBrasileira(pacote.getPreco()));
    }
}
