package br.com.alura.example.aluraviagem.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.DiasUtil;
import br.com.alura.example.aluraviagem.Util.FormatadorDeDataUtil;
import br.com.alura.example.aluraviagem.Util.ImagemUtil;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
import br.com.alura.example.aluraviagem.models.Pacote;

import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;
import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.TITLE_APPBAR_RESUMO_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITLE_APPBAR_RESUMO_PACOTE);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if ( intent.hasExtra(CHAVE_PACOTE)) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            preecheCampos(pacote);
            vaiParaPagamentoPacote(pacote);
        }
    }

    private void vaiParaPagamentoPacote(final Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_button_comprar);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this,
                        PagamentoPacoteActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

    private void preecheCampos(Pacote pacote) {
        preencheImagem(pacote.getImagem(), R.id.resumo_pacote_imagem);
        preencheLocal(pacote.getLocal(), R.id.resumo_pacote_text_local);
        preencheDia(pacote.getDias(), R.id.resumo_pacote_text_dias);
        preenchePreco(pacote.getPreco(), R.id.resumo_pacote_text_preco);
        preencheData(pacote.getDias(), R.id.resumo_pacote_text_data);
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
