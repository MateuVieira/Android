package br.com.alura.example.aluraviagem.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.example.aluraviagem.R;
import br.com.alura.example.aluraviagem.Util.MoedaUtil;
import br.com.alura.example.aluraviagem.models.Pacote;

public class PagamentoPacoteActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR_PAGAMENTO = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pacote);
        setTitle(TITLE_APPBAR_PAGAMENTO);


        Pacote pacote = new Pacote("São Paulo",
                            "sao_paulo_sp",
                            2,
                            new BigDecimal(243.99));

        preeenchePreco(pacote);
    }

    private void preeenchePreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_pacote_text_preco);
        preco.setText(MoedaUtil.precoFormatacaoBrasileira(pacote.getPreco()));
    }
}
