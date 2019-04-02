package br.com.alura.example.aluraviagem.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.FormatadorDeDataUtil;
import br.com.alura.example.aluraviagem.Util.ImagemUtil;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
import br.com.alura.example.aluraviagem.models.Pacote;

import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;
import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.TITLE_APPBAR_RESUMO_COMPRA;

public class ResumoCompraActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITLE_APPBAR_RESUMO_COMPRA);

        Intent intent = getIntent();
        if ( intent.hasExtra(CHAVE_PACOTE)) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            preencheCampos(pacote);

        }
    }

    private void preencheCampos(Pacote pacote) {
        preencheImagem(pacote.getImagem(), R.id.resumo_compra_image);
        preencheLocal(pacote.getLocal(), R.id.resumo_compra_text_local);
        preencheData(pacote.getDias(), R.id.resumo_compra_text_data);
        preenchePreco(pacote.getPreco(), R.id.resumo_compra_text_preco);
    }

    private void preencheData(int dia, int id) {
        TextView pacoteData = findViewById(id);
        pacoteData.setText(FormatadorDeDataUtil.formataData(dia));
    }

    private void preenchePreco(BigDecimal preco, int id) {
        TextView pacotePreco = findViewById(id);
        pacotePreco.setText(MoedaUtil.precoFormatacaoBrasileira(preco));
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
