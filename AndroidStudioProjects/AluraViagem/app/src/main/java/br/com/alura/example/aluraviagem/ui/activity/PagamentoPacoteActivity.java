package br.com.alura.example.aluraviagem.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
import br.com.alura.example.aluraviagem.models.Pacote;

import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;
import static br.com.alura.example.aluraviagem.ui.activity.PacoteActivityConstantes.TITLE_APPBAR_PAGAMENTO;

public class PagamentoPacoteActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pacote);
        setTitle(TITLE_APPBAR_PAGAMENTO);

        Intent intent = getIntent();
        if ( intent.hasExtra(CHAVE_PACOTE)) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            preeenchePreco(pacote);
            vaiParaResumoCompra(pacote);
        }
    }

    private void vaiParaResumoCompra(final Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_pacote_button_finalizar_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoPacoteActivity.this,
                                            ResumoCompraActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacote);
                startActivity(intent);
            }
        });
    }

    private void preeenchePreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_pacote_text_preco);
        preco.setText(MoedaUtil.precoFormatacaoBrasileira(pacote.getPreco()));
    }





}
