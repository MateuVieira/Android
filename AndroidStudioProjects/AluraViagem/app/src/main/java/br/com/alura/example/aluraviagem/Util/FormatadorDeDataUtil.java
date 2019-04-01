package br.com.alura.example.aluraviagem.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatadorDeDataUtil {

    public static String formataData(int diasViagem) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, diasViagem);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM");
        String formatDataIda = simpleFormat.format(dataIda.getTime());
        String formatDataVolta = simpleFormat.format(dataVolta.getTime());
        String dataFormatadaDaViagem = formatDataIda + " - " + formatDataVolta + " de " + dataVolta.get(Calendar.YEAR);

        return dataFormatadaDaViagem;
    }

}
