package br.com.alura.example.aluraviagem.Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PT = "pt";
    public static final String BR = "br";
    public static final String $ = "R$";
    public static final String $_ = "R$ ";

    public static String precoFormatacaoBrasileira(BigDecimal preco) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale(PT, BR));
        BigDecimal precoPacote = preco;
        return formatoBrasileiro.format(precoPacote).replace($, $_);
    }
}
