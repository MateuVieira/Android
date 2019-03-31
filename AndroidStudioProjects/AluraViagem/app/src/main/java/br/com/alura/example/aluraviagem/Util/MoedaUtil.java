package br.com.alura.example.aluraviagem.Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static String precoFormatacaoBrasileira(BigDecimal preco) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br"));
        BigDecimal precoPacote = preco;
        return formatoBrasileiro.format(precoPacote).replace("R$", "R$ ");
    }
}
